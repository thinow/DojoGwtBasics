package dojo.gwt.client.screen.top;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.IsWidget;

public interface TopView extends IsWidget {

	public interface Presenter {

	}

	void setPresenter(Presenter presenter);

	/** Retire tous les éléments de la liste. */
	void clearList();

	/** Ajoute un film dans la liste. */
	void addMovie(String label, ClickHandler handler);

}
