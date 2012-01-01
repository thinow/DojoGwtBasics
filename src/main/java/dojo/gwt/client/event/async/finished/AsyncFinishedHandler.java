package dojo.gwt.client.event.async.finished;

import com.google.gwt.event.shared.EventHandler;

public interface AsyncFinishedHandler extends EventHandler {

	/**
	 * Comportement déclenché lorsqu'un traitement asynchrone a été terminé.
	 */
	void onAsynchronousTreatmentFinished();

}
