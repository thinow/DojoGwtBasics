package dojo.gwt.client.screen.top;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

import dojo.gwt.client.place.TopPlace;
import dojo.gwt.client.screen.top.TopView.Presenter;

public class TopActivity extends AbstractActivity implements Presenter {

	@SuppressWarnings("unused")
	private TopPlace place;

	@Inject
	private TopView view;

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		view.setPresenter(this);
		panel.setWidget(view);
	}

	public void setPlace(TopPlace place) {
		this.place = place;
	}

}
