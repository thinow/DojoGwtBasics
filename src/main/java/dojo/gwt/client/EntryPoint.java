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

import dojo.gwt.client.injection.ClientFactory;
import dojo.gwt.client.injection.Injector;
import dojo.gwt.client.place.MainPlace;
import dojo.gwt.client.place.mapper.ActivityMapper;
import dojo.gwt.client.place.mapper.PlaceHistoryMapper;

public class EntryPoint implements com.google.gwt.core.client.EntryPoint {

	private SimplePanel bodyPanel = new SimplePanel();

	private EventBus eventBus = new SimpleEventBus();
	private Place defaultPlace = new MainPlace("DEFAULT");

	private Injector injector;

	public EntryPoint() {
		injector = GWT.create(Injector.class);
	}

	@Override
	public void onModuleLoad() {
		injectBodyPanel();
		registerActivities();
		handleHistory();
	}

	private void injectBodyPanel() {
		RootPanel.get().add(bodyPanel);
	}

	private void registerActivities() {
		ActivityMapper mapper = new ActivityMapper(injector);

		ActivityManager manager = new ActivityManager(mapper, eventBus);
		manager.setDisplay(bodyPanel);
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

}
