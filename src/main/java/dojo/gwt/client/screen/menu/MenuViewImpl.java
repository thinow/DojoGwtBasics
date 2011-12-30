package dojo.gwt.client.screen.menu;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.PushButton;

public class MenuViewImpl extends FlowPanel implements MenuView {

	@SuppressWarnings("unused")
	private Presenter presenter;

	public MenuViewImpl() {
		addButton("Top 10 des films");
		addButton("Rechercher un film");
	}

	private void addButton(String buttonText) {
		add(new PushButton(buttonText));
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}
