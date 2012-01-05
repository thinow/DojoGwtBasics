package dojo.gwt.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.PopupPanel;

import dojo.gwt.client.image.Images;

/**
 * Ecran placé à l'avant afin de verrouiller l'application en attendant la fin
 * d'un traitement asynchrone.
 */
public class Spinner {

	private PopupPanel popupPanel;

	private Images images = GWT.create(Images.class);

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
		Image imageWidget = new Image(images.getSpinner());
		popupPanel.setWidget(imageWidget);
	}

	public void show() {
		popupPanel.center();
	}

	public void hide() {
		popupPanel.hide();
	}

}
