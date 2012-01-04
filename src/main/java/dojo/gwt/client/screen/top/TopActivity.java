package dojo.gwt.client.screen.top;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

import dojo.gwt.client.event.async.finished.AsyncFinishedEvent;
import dojo.gwt.client.event.async.started.AsyncStartedEvent;
import dojo.gwt.client.place.TopPlace;
import dojo.gwt.client.screen.top.TopView.Presenter;
import dojo.gwt.shared.rpc.object.BeerReference;
import dojo.gwt.shared.rpc.service.BeerServiceAsync;

public class TopActivity extends AbstractActivity implements Presenter {

	private TopPlace place;

	@Inject
	private TopView view;

	@Inject
	private BeerServiceAsync beerService;

	private EventBus eventBus;

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		this.eventBus = eventBus;

		panel.setWidget(view);
		view.setPresenter(this);

		view.clearList();
		startDataRetreiving();
	}

	private void startDataRetreiving() {
		eventBus.fireEvent(new AsyncStartedEvent());

		Integer count = place.getCount();
		beerService.getTopBeers(count, new AsyncCallback<BeerReference[]>() {

			@Override
			public void onSuccess(BeerReference[] result) {
				displayBeers(result);
				eventBus.fireEvent(new AsyncFinishedEvent());
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Erreur lors de la récupération des bières");
				eventBus.fireEvent(new AsyncFinishedEvent());
			}
		});
	}

	private void displayBeers(BeerReference[] beers) {
		for (BeerReference beer : beers) {
			view.addBeer(beer.getLabel(), goTo(beer));
		}
	}

	private ClickHandler goTo(BeerReference beer) {
		return new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Window.alert("Oops ! Cette page n'est pas encore disponible !");
			}
		};
	}

	public void setPlace(TopPlace place) {
		this.place = place;
	}

}
