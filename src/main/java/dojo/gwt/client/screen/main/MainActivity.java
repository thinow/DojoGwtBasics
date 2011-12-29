package dojo.gwt.client.screen.main;

import java.util.Date;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

import dojo.gwt.client.injection.ClientFactory;
import dojo.gwt.client.place.MainPlace;
import dojo.gwt.client.screen.main.MainView.Presenter;
import dojo.gwt.shared.TimeServiceAsync;

public class MainActivity extends AbstractActivity implements Presenter {

	@Inject
	private ClientFactory clientFactory;

	@Inject
	private MainView view;

	@Inject
	private TimeServiceAsync timeService;

	private MainPlace place;

	public void start(AcceptsOneWidget parent, EventBus eventBus) {
		view.setPresenter(this);
		view.addWord(place.getToken());

		parent.setWidget(view);
	}

	public void setPlace(MainPlace place) {
		this.place = place;
	}

	@Override
	public void onGoToButtonClick() {
		String now = String.valueOf(new Date().getTime());

		MainPlace nextPlace = new MainPlace(now);
		clientFactory.getPlaceController().goTo(nextPlace);
	}

	@Override
	public void onTimeButtonClick() {
		timeService.getTime(new AsyncCallback<Date>() {
			@Override
			public void onSuccess(Date result) {
				Window.alert(String.valueOf(result));
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Erreur lors de la récupération de l'heure");
				GWT.log("erreur !", caught);
			}
		});
	}
}
