package dojo.gwt.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.web.bindery.event.shared.EventBus;

import dojo.gwt.client.event.async.finished.AsyncFinishedEvent;
import dojo.gwt.client.event.async.finished.AsyncFinishedHandler;
import dojo.gwt.client.event.async.started.AsyncStartedEvent;
import dojo.gwt.client.event.async.started.AsyncStartedHandler;
import dojo.gwt.client.injection.ClientFactory;
import dojo.gwt.client.injection.Injector;
import dojo.gwt.client.place.MenuPlace;
import dojo.gwt.client.place.mapper.ActivityMapper;
import dojo.gwt.client.place.mapper.PlaceHistoryMapper;
import dojo.gwt.client.widget.Spinner;

/**
 * Point d'entrée de la WebApp GWT.
 */
public class EntryPoint implements com.google.gwt.core.client.EntryPoint,
		AsyncStartedHandler, AsyncFinishedHandler {

	private SimplePanel bodyPanel = new SimplePanel();

	private EventBus eventBus = new SimpleEventBus();
	private Place defaultPlace = new MenuPlace();

	private Injector injector = GWT.create(Injector.class);

	private Spinner spinner = new Spinner();

	@Override
	public void onModuleLoad() {
		injectBodyPanel();
		registerActivities();
		registerWaitingMessagesEvents();
		handleHistory();
	}

	private void injectBodyPanel() {
		RootPanel root = RootPanel.get("mainContent");
		root.add(bodyPanel);
	}

	private void registerActivities() {
		ActivityMapper mapper = new ActivityMapper(injector);

		ActivityManager manager = new ActivityManager(mapper, eventBus);
		manager.setDisplay(bodyPanel);
	}

	private void registerWaitingMessagesEvents() {
		eventBus.addHandler(AsyncStartedEvent.TYPE, this);
		eventBus.addHandler(AsyncFinishedEvent.TYPE, this);
	}

	private void handleHistory() {
		ClientFactory clientFactory = injector.getClientFactory();

		PlaceController placeController = new PlaceController(eventBus);
		clientFactory.setPlaceController(placeController);

		PlaceHistoryMapper mapper = GWT.create(PlaceHistoryMapper.class);

		PlaceHistoryHandler handler = new PlaceHistoryHandler(mapper);
		handler.register(placeController, eventBus, defaultPlace);
		handler.handleCurrentHistory();
	}

	@Override
	public void onAsynchronousTreatmentStarted() {
		spinner.show();
	}

	@Override
	public void onAsynchronousTreatmentFinished() {
		spinner.hide();
	}

}
