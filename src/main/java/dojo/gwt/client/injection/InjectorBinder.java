package dojo.gwt.client.injection;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;

public class InjectorBinder extends AbstractGinModule {

	@Override
	protected void configure() {
		bind(ClientFactory.class).in(Singleton.class);
	}

}
