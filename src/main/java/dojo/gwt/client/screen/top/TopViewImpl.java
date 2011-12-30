package dojo.gwt.client.screen.top;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.Widget;

public class TopViewImpl extends Composite implements TopView {

	private static Binder uiBinder = GWT.create(Binder.class);

	interface Binder extends UiBinder<Widget, TopViewImpl> {
	}

	@SuppressWarnings("unused")
	private Presenter presenter;

	@UiField
	FlowPanel listPanel;

	public TopViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void clearList() {
		listPanel.clear();
	}

	@Override
	public void addMovie(String label, ClickHandler handler) {
		PushButton button = new PushButton();
		button.setText(label);
		button.addClickHandler(handler);

		listPanel.add(button);
	}

}
