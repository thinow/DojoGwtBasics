package dojo.gwt.client.event.async.started;

import com.google.gwt.event.shared.EventHandler;

public interface AsyncStartedHandler extends EventHandler {

	/**
	 * Comportement déclenché lorsqu'un traitement asynchrone vient de
	 * commencer.
	 */
	void onAsynchronousTreatmentStarted();

}
