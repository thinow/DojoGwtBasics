package dojo.gwt.client.injection;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

import dojo.gwt.client.ClientFactory;
import dojo.gwt.client.screen.main.MainView;

public class InjectorBinder extends AbstractGinModule {

	@Override
	protected void configure() {
		bindAsSingleton(ClientFactory.class, MainView.class);
	}

	private void bindAsSingleton(Class<?>... classes) {
		for (Class<?> clazz : classes) {
			bind(clazz).in(Singleton.class);
		}
	}

}
