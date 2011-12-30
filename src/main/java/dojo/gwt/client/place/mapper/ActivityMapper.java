package dojo.gwt.client.place.mapper;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.Place;

import dojo.gwt.client.injection.Injector;
import dojo.gwt.client.place.MainPlace;
import dojo.gwt.client.place.MenuPlace;
import dojo.gwt.client.place.TopPlace;
import dojo.gwt.client.screen.main.MainActivity;
import dojo.gwt.client.screen.menu.MenuActivity;
import dojo.gwt.client.screen.top.TopActivity;

public class ActivityMapper implements
		com.google.gwt.activity.shared.ActivityMapper {

	private Injector injector;

	public ActivityMapper(Injector injector) {
		this.injector = injector;
	}

	@Override
	public Activity getActivity(Place place) {
		Activity activity = null;

		if (place instanceof MainPlace) {
			activity = injector.getMainActivity();
			((MainActivity) activity).setPlace((MainPlace) place);
		} else if (place instanceof MenuPlace) {
			activity = injector.getMenuActivity();
			((MenuActivity) activity).setPlace((MenuPlace) place);
		} else if (place instanceof TopPlace) {
			activity = injector.getTopActivity();
			((TopActivity) activity).setPlace((TopPlace) place);
		}

		return activity;
	}

}
