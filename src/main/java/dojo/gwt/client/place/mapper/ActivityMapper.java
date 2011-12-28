package dojo.gwt.client.place.mapper;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.Place;

import dojo.gwt.client.injection.Injector;
import dojo.gwt.client.place.MainPlace;
import dojo.gwt.client.screen.main.MainActivity;

public class ActivityMapper implements
		com.google.gwt.activity.shared.ActivityMapper {

	private Injector injector;

	public ActivityMapper(Injector injector) {
		this.injector = injector;
	}

	@Override
	public Activity getActivity(Place place) {

		if (place instanceof MainPlace) {
			MainActivity activity = injector.getMainActivity();
			activity.setPlace((MainPlace) place);
			return activity;
		}

		return null;
	}

}
