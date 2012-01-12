package dojo.gwt.client.util;

import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.TextBox;

public final class TextBoxNumericAdapter implements HasValue<Double> {

	private TextBox textBox;

	private TextBoxNumericAdapter(TextBox textBox) {
		this.textBox = textBox;
	}

	public static TextBoxNumericAdapter from(TextBox textBox) {
		return new TextBoxNumericAdapter(textBox);
	}

	@Override
	public HandlerRegistration addValueChangeHandler(
			ValueChangeHandler<Double> handler) {
		return null;
	}

	@Override
	public void fireEvent(GwtEvent<?> event) {

	}

	@Override
	public Double getValue() {
		try {
			return Double.parseDouble(textBox.getValue());
		} catch (NumberFormatException e) {
			return 0.0;
		}
	}

	@Override
	public void setValue(Double value) {
		setValue(value, true);
	}

	@Override
	public void setValue(Double value, boolean fireEvents) {
		textBox.setValue(String.valueOf(value));
	}

}
