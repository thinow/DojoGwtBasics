package dojo.gwt.client.screen.menu;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.PushButton;

public class MenuViewImpl extends FlowPanel implements MenuView {

	public MenuViewImpl() {
		add(new PushButton("Top 10 des films"));
		add(new PushButton("Rechercher un film"));
	}

}
