package dojo.gwt.client.event.async.started;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Evénement désignant un traitement asynchrone venant de commencer.
 */
public class AsyncStartedEvent extends GwtEvent<AsyncStartedHandler> {

	private static final Type<AsyncStartedHandler> TYPE = new Type<AsyncStartedHandler>();

	@Override
	public Type<AsyncStartedHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(AsyncStartedHandler handler) {
		handler.onAsynchronousTreatmentStarted();
	}

}