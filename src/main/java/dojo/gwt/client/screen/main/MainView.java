package dojo.gwt.client.screen.main;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;

public class MainView extends FlowPanel {

	public MainView() {
		Label label = new Label("MainActivity !");
		add(label);
	}

	public void setWord(String word) {
		add(new Label(word));
	}

}
