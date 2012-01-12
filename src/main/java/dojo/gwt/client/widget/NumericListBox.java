package dojo.gwt.client.widget;

import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.ListBox;

/**
 * {@link ListBox} destinée à lister des valeurs {@link Double}.
 */
public class NumericListBox extends ListBox implements HasValue<Double> {

	@Override
	public HandlerRegistration addValueChangeHandler(
			ValueChangeHandler<Double> handler) {
		return null;
	}

	public void addItem(String item, Double value) {
		super.addItem(item, String.valueOf(value));
	}

	@Override
	public Double getValue() {
		return Double.parseDouble(getValue(getSelectedIndex()));
	}

	@Override
	public void setValue(Double value) {
		setValue(value, true);
	}

	@Override
	public void setValue(Double value, boolean fireEvents) {
		String stringValue = String.valueOf(value);

		for (int itemIndex = 0; itemIndex < getItemCount(); itemIndex++) {
			if (stringValue.equals(getValue(itemIndex))) {
				setSelectedIndex(itemIndex);
				return;
			}
		}
	}

}
