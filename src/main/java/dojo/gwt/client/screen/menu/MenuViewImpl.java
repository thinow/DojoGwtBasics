package dojo.gwt.client.screen.menu;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.PushButton;

public class MenuViewImpl extends FlowPanel implements MenuView {

	@SuppressWarnings("unused")
	private Presenter presenter;

	@Override
	public void addButton(String buttonText, ClickHandler handler) {
		PushButton button = new PushButton(buttonText);
		button.addClickHandler(handler);

		this.add(button);
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}
