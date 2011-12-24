package dojo.gwt.client.place.mapper;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.Place;

import dojo.gwt.client.place.MainPlace;
import dojo.gwt.client.screen.main.MainActivity;

public class ActivityMapper implements
		com.google.gwt.activity.shared.ActivityMapper {

	@Override
	public Activity getActivity(Place place) {

		if (place instanceof MainPlace) {
			return new MainActivity((MainPlace) place);
		}

		return null;
	}

}
