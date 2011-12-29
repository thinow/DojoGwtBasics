package dojo.gwt.client.screen.main;

import java.util.Date;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

import dojo.gwt.client.injection.ClientFactory;
import dojo.gwt.client.place.MainPlace;
import dojo.gwt.client.screen.main.MainView.Presenter;

public class MainActivity extends AbstractActivity implements Presenter {

	@Inject
	private ClientFactory clientFactory;

	@Inject
	private MainView view;

	private MainPlace place;

	public void start(AcceptsOneWidget parent, EventBus eventBus) {
		view.setPresenter(this);
		view.setWord(place.getToken());

		parent.setWidget(view);

		GWT.log(getClass().getName() + " has started successfully !");
	}

	public void setPlace(MainPlace place) {
		this.place = place;
	}

	@Override
	public void onButtonClick() {
		String now = String.valueOf(new Date().getTime());

		MainPlace nextPlace = new MainPlace(now);
		clientFactory.getPlaceController().goTo(nextPlace);
	}
}
