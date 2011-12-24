package dojo.gwt.client.injection;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

import dojo.gwt.client.screen.main.MainView;

public class InjectorBinder extends AbstractGinModule {

	@Override
	protected void configure() {
		bind(MainView.class).in(Singleton.class);
	}

}
