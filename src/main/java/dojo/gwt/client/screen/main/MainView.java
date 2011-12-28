package dojo.gwt.client.screen.main;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PushButton;

public class MainView extends FlowPanel {

	public interface Presenter {
		void onButtonClick();
	}

	private Presenter presenter;

	public MainView() {
		PushButton button = new PushButton("Go to place...");
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				presenter.onButtonClick();
			}
		});
		add(button);

		Label label = new Label("MainActivity !");
		add(label);
	}

	public void setWord(String word) {
		add(new Label(word));
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}
