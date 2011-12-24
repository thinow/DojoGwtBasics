package dojo.gwt.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class MainPlace extends Place {

	private String token;

	public MainPlace(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public static class Tokenizer implements PlaceTokenizer<MainPlace> {

		public MainPlace getPlace(String token) {
			return new MainPlace(token);
		}

		public String getToken(MainPlace place) {
			return place.token;
		}
	}

}
