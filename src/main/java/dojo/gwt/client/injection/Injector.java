package dojo.gwt.client.injection;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

import dojo.gwt.client.ClientFactory;
import dojo.gwt.client.screen.main.MainActivity;

/**
 * Gestionnaire des instances injectées.
 */
@GinModules(InjectorBinder.class)
public interface Injector extends Ginjector {

	ClientFactory getClientFactory();

	MainActivity getMainActivity();

}
