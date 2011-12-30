package dojo.gwt.client.screen.menu;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

import dojo.gwt.client.injection.ClientFactory;
import dojo.gwt.client.place.MenuPlace;
import dojo.gwt.client.place.TopPlace;
import dojo.gwt.client.screen.menu.MenuView.Presenter;

public class MenuActivity extends AbstractActivity implements Presenter {

	@Inject
	private MenuView view;

	@Inject
	private ClientFactory clientFactory;

	@SuppressWarnings("unused")
	private MenuPlace place;

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view.setPresenter(this);

		view.addButton("Top 10 des films", goTo(new TopPlace(10)));
		view.addButton("Rechercher un film", goTo(Place.NOWHERE));

		panel.setWidget(view);
	}

	private ClickHandler goTo(final Place nextPlace) {
		return new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				clientFactory.getPlaceController().goTo(nextPlace);
			}
		};
	}

	public void setPlace(MenuPlace place) {
		this.place = place;
	}

}
