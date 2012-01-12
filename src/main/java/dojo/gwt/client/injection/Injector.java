package dojo.gwt.client.injection;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

import dojo.gwt.client.screen.add.AddActivity;
import dojo.gwt.client.screen.menu.MenuActivity;
import dojo.gwt.client.screen.top.TopActivity;

/**
 * Gestionnaire des instances injectées.
 */
@GinModules(InjectorBinder.class)
public interface Injector extends Ginjector {

	ClientFactory getClientFactory();

	MenuActivity getMenuActivity();

	TopActivity getTopActivity();

	AddActivity getAddActivity();

}
