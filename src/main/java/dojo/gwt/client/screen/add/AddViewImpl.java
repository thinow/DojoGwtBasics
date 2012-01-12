package dojo.gwt.client.screen.add;

import java.util.Arrays;
import java.util.List;

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

	private static final double GRADE_MAX = 1.0;
	private static final double GRADE_INTERVAL = 0.0025;

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

		fillCountryList();
		fillGradesList();
	}

	private void fillCountryList() {
		List<String> values = Arrays.asList("France", "Belgique", "Allemagne");

		for (String value : values) {
			country.addItem(value, value);
		}
	}

	private void fillGradesList() {
		NumberFormat formatter = NumberFormat.getFormat("0.00");

		for (double value = 0.0; value <= GRADE_MAX; value += GRADE_INTERVAL) {
			grade.addItem(formatter.format(value * 100) + "%", value);
		}
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
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
