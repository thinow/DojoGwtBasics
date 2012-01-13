package dojo.gwt.client.screen.add;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import dojo.gwt.client.util.TextBoxNumericAdapter;
import dojo.gwt.client.widget.NumericListBox;
import dojo.gwt.client.widget.StringListBox;

public class AddViewImpl extends Composite implements AddView {

	interface Binder extends UiBinder<Widget, AddViewImpl> {
	}

	private Presenter presenter;

	@UiField
	TextBox label;

	@UiField
	TextArea description;

	@UiField
	TextBox alcohol;

	@UiField
	TextBox brewery;

	@UiField
	StringListBox country;

	@UiField
	NumericListBox grade;

	public AddViewImpl() {
		Binder uiBinder = GWT.create(Binder.class);
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void bindOnPresenter(Presenter presenter) {
		this.presenter = presenter;

		fillCountryList();
		fillGradeList();
	}

	private void fillCountryList() {
		for (String value : presenter.getAvailableCountries()) {
			country.addItem(value, value);
		}
	}

	private void fillGradeList() {
		NumberFormat formatter = NumberFormat.getFormat("0.00");
		for (Double value : presenter.getAvailableGrades()) {
			grade.addItem(formatter.format(value * 100) + "%", value);
		}
	}

	@Override
	public HasValue<String> getLabel() {
		return label;
	}

	@Override
	public HasValue<String> getDescription() {
		return description;
	}

	@Override
	public HasValue<Double> getGrade() {
		return grade;
	}

	@Override
	public HasValue<Double> getAlcohol() {
		return TextBoxNumericAdapter.from(alcohol);
	}

	@Override
	public HasValue<String> getBrewery() {
		return brewery;
	}

	@Override
	public HasValue<String> getCountry() {
		return country;
	}

	@UiHandler("saveButton")
	void onSaveButtonClicked(ClickEvent event) {
		presenter.onSaveButtonClicked();
	}

}
