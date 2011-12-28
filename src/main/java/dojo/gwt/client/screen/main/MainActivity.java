package dojo.gwt.client.screen.main;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import dojo.gwt.client.place.MainPlace;

public class MainActivity extends AbstractActivity {

	private MainView view;
	private MainPlace place;

	public MainActivity(MainPlace place) {
		this.place = place;
	}

	public void start(AcceptsOneWidget parent, EventBus eventBus) {
		view = new MainView();
		view.setWord(place.getToken());

		parent.setWidget(view);

		GWT.log(getClass().getName() + " has started successfully !");
	}

}
