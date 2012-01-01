package dojo.gwt.client.widget;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;

/**
 * Ecran placé à l'avant afin de verrouiller l'application en attendant la fin
 * d'un traitement asynchrone.
 */
public class Spinner {

	private PopupPanel popupPanel;

	public Spinner() {
		initializePopup();
		fillPopup();
	}

	private void initializePopup() {
		popupPanel = new PopupPanel();
		popupPanel.setModal(true);
		popupPanel.setGlassEnabled(true);
		popupPanel.setAutoHideEnabled(false);
	}

	private void fillPopup() {
		popupPanel.setWidget(new Label("WAIT"));
	}

	public void show() {
		popupPanel.center();
	}

	public void hide() {
		popupPanel.hide();
	}

}
