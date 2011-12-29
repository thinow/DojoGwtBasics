package dojo.gwt.client.screen.main;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PushButton;

public class MainView extends FlowPanel {

	public interface Presenter {
		/** Déclenchement d'un clic sur le bouton de parcours des pages. */
		void onGoToButtonClick();

		/** Déclenchement d'un clic sur le bouton de récupération de l'heure. */
		void onTimeButtonClick();
	}

	private Presenter presenter;

	public MainView() {
		addTimeButton();
		addGoToButton();

		addWord("MainActivity !");
	}

	private void addTimeButton() {
		PushButton button = new PushButton("What time is it please ?");
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				presenter.onTimeButtonClick();
			}
		});
		add(button);
	}

	private void addGoToButton() {
		PushButton button = new PushButton("Go to place...");
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				presenter.onGoToButtonClick();
			}
		});
		add(button);
	}

	public void addWord(String word) {
		add(new Label(word));
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}
