package dojo.gwt.client.widget;

import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.ListBox;

/**
 * {@link ListBox} destinée à lister des valeurs {@link String}.
 */
public class StringListBox extends ListBox implements HasValue<String> {

	@Override
	public HandlerRegistration addValueChangeHandler(
			ValueChangeHandler<String> handler) {
		return null;
	}

	@Override
	public String getValue() {
		return getValue(getSelectedIndex());
	}

	@Override
	public void setValue(String value) {
		setValue(value, true);
	}

	@Override
	public void setValue(String value, boolean fireEvents) {
		for (int itemIndex = 0; itemIndex < getItemCount(); itemIndex++) {
			if (value.equals(getValue(itemIndex))) {
				setSelectedIndex(itemIndex);
				return;
			}
		}
	}

}
