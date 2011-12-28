package dojo.gwt.client;

import com.google.gwt.place.shared.PlaceController;

public class ClientFactory {

	private PlaceController placeController;

	public PlaceController getPlaceController() {
		return placeController;
	}

	public void setPlaceController(PlaceController placeController) {
		this.placeController = placeController;
	}

}
