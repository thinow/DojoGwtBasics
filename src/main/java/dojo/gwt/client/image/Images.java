package dojo.gwt.client.image;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

/**
 * Banque d'images destinées aux design de la webapp.
 */
public interface Images extends ClientBundle {

	@Source("spinner.gif")
	ImageResource getSpinner();

}
