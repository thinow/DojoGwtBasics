package dojo.gwt.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class TopPlace extends Place {

	private Integer count;

	public TopPlace(Integer count) {
		this.count = count;
	}

	/**
	 * Récupère le nombre d'items à afficher.
	 */
	public Integer getCount() {
		return count;
	}

	public static class Tokenizer implements PlaceTokenizer<TopPlace> {

		@Override
		public TopPlace getPlace(String token) {
			return new TopPlace(Integer.valueOf(token));
		}

		@Override
		public String getToken(TopPlace place) {
			return String.valueOf(place.getCount());
		}

	}

}
