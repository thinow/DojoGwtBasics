package dojo.gwt.client.screen.main;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class MainActivity extends AbstractActivity {

	private MainView view;

	public void start(AcceptsOneWidget widget, EventBus eventBus) {
		view = new MainView();
		widget.setWidget(view);
	}

}
