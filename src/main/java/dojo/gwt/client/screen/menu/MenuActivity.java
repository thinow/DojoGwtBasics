package dojo.gwt.client.screen.menu;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

import dojo.gwt.client.injection.ClientFactory;
import dojo.gwt.client.place.AddPlace;
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

		view.addButton("Ajouter une bière", goTo(new AddPlace()));
		view.addButton("Les 10 meilleures bières", goTo(new TopPlace(10)));
		view.addButton("Les 10 bières les plus fortes", goTo(Place.NOWHERE));
		view.addButton("Rechercher une bière", goTo(Place.NOWHERE));

		panel.setWidget(view);
	}

	private ClickHandler goTo(final Place nextPlace) {
		return new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (nextPlace == Place.NOWHERE) {
					Window.alert("Oops ! Cette page n'existe pas !");
					return;
				}

				clientFactory.getPlaceController().goTo(nextPlace);
			}
		};
	}

	public void setPlace(MenuPlace place) {
		this.place = place;
	}

}
