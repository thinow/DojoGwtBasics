package dojo.gwt.client.screen.add;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

import dojo.gwt.client.event.async.finished.AsyncFinishedEvent;
import dojo.gwt.client.event.async.started.AsyncStartedEvent;
import dojo.gwt.client.injection.ClientFactory;
import dojo.gwt.client.place.AddPlace;
import dojo.gwt.client.place.MenuPlace;
import dojo.gwt.client.screen.add.AddView.Presenter;
import dojo.gwt.shared.rpc.service.BeerServiceAsync;

public class AddActivity extends AbstractActivity implements Presenter {

	@Inject
	private AddView view;

	@Inject
	private BeerServiceAsync service;

	@Inject
	private ClientFactory clientFactory;

	private EventBus eventBus;

	@SuppressWarnings("unused")
	private AddPlace place;

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		this.eventBus = eventBus;

		view.setPresenter(this);
		panel.setWidget(view);
	}

	public void setPlace(AddPlace place) {
		this.place = place;
	}

	@Override
	public void onSaveButtonClicked() {
		startWaitingScreen();

		String label = view.getLabel().getValue();
		String description = view.getDescription().getValue();
		Double grade = view.getGrade().getValue();
		Double alcohol = view.getAlcohol().getValue();
		String brewery = view.getBrewery().getValue();
		String country = view.getCountry().getValue();

		service.addBeer(label, description, grade, alcohol, brewery, country,
				new AsyncCallback<Void>() {

					@Override
					public void onFailure(Throwable caught) {
						stopWaitingScreen();

						GWT.log("Erreur :", caught);
						Window.alert("Erreur : " + caught.getMessage());
					}

					@Override
					public void onSuccess(Void result) {
						stopWaitingScreen();
						goToNextPlace();
					}

				});
	}

	private void goToNextPlace() {
		clientFactory.getPlaceController().goTo(new MenuPlace());
	}

	private void startWaitingScreen() {
		eventBus.fireEvent(new AsyncStartedEvent());
	}

	private void stopWaitingScreen() {
		eventBus.fireEvent(new AsyncFinishedEvent());
	}

}
