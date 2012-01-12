package dojo.gwt.client.screen.add;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class AddViewImpl extends Composite implements AddView {

	interface Binder extends UiBinder<Widget, AddViewImpl> {
	}

	@SuppressWarnings("unused")
	private Presenter presenter;

	public AddViewImpl() {
		Binder uiBinder = GWT.create(Binder.class);
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}
}
