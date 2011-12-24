package dojo.gwt.client.injection;

import com.google.gwt.inject.client.Ginjector;

import dojo.gwt.client.screen.main.MainView;

/**
 * Gestionnaire des instances injectées.
 */
public interface Injector extends Ginjector {

	MainView getMainView();

}
