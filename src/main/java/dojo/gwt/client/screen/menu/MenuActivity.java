package dojo.gwt.client.screen.menu;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

import dojo.gwt.client.place.MenuPlace;
import dojo.gwt.client.screen.menu.MenuView.Presenter;

public class MenuActivity extends AbstractActivity implements Presenter {

	@Inject
	private MenuView view;

	@SuppressWarnings("unused")
	private MenuPlace place;

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		panel.setWidget(view);
	}

	public void setPlace(MenuPlace place) {
		this.place = place;
	}

}
