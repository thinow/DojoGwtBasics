package dojo.gwt.client.injection;

import com.google.gwt.inject.client.Ginjector;

import dojo.gwt.client.screen.main.MainActivity;

/**
 * Gestionnaire des instances injectées.
 */
public interface Injector extends Ginjector {

	MainActivity getMainActivity();

}
