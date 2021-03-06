package dojo.gwt.client.place.mapper;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.Place;

import dojo.gwt.client.injection.Injector;
import dojo.gwt.client.place.AddPlace;
import dojo.gwt.client.place.MenuPlace;
import dojo.gwt.client.place.TopPlace;
import dojo.gwt.client.screen.add.AddActivity;
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

		if (place instanceof MenuPlace) {
			activity = injector.getMenuActivity();
			((MenuActivity) activity).setPlace((MenuPlace) place);
		} else if (place instanceof TopPlace) {
			activity = injector.getTopActivity();
			((TopActivity) activity).setPlace((TopPlace) place);
		} else if (place instanceof AddPlace) {
			activity = injector.getAddActivity();
			((AddActivity) activity).setPlace((AddPlace) place);
		}

		return activity;
	}

}
