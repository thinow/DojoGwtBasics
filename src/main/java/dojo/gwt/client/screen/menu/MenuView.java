package dojo.gwt.client.screen.menu;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.IsWidget;

public interface MenuView extends IsWidget {

	public interface Presenter {

	}

	void setPresenter(Presenter presenter);

	/** Ajoute un bouton dans l'écran. */
	void addButton(String buttonText, ClickHandler handler);

}
