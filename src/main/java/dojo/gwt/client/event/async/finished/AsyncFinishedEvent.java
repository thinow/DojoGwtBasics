package dojo.gwt.client.event.async.finished;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Evénement désignant un traitement asynchrone venant d'être terminé.
 */
public class AsyncFinishedEvent extends GwtEvent<AsyncFinishedHandler> {

	public static final Type<AsyncFinishedHandler> TYPE = new Type<AsyncFinishedHandler>();

	@Override
	public Type<AsyncFinishedHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(AsyncFinishedHandler handler) {
		handler.onAsynchronousTreatmentFinished();
	}

}