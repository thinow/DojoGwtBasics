package dojo.gwt.client.injection;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

import dojo.gwt.client.screen.menu.MenuView;
import dojo.gwt.client.screen.menu.MenuViewImpl;
import dojo.gwt.client.screen.top.TopView;
import dojo.gwt.client.screen.top.TopViewImpl;

public class InjectorBinder extends AbstractGinModule {

	@Override
	protected void configure() {
		bind(ClientFactory.class).in(Singleton.class);
		bind(MenuView.class).to(MenuViewImpl.class);
		bind(TopView.class).to(TopViewImpl.class);
	}

}
