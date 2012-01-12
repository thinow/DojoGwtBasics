package dojo.gwt.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class AddPlace extends Place {

	public static class Tokenizer implements PlaceTokenizer<AddPlace> {

		@Override
		public AddPlace getPlace(String token) {
			return new AddPlace();
		}

		@Override
		public String getToken(AddPlace place) {
			return null;
		}

	}

}
