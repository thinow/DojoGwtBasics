package dojo.gwt.client.screen.add;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

import dojo.gwt.client.place.AddPlace;
import dojo.gwt.client.screen.add.AddView.Presenter;

public class AddActivity extends AbstractActivity implements Presenter {

	@Inject
	private AddView view;

	@SuppressWarnings("unused")
	private AddPlace place;

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view.setPresenter(this);

		panel.setWidget(view);
	}

	public void setPlace(AddPlace place) {
		this.place = place;
	}

}
