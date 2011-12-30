package dojo.gwt.shared.rpc.object;

import java.io.Serializable;

/**
 * Référence d'un objet film. Contient uniquement un identifiant permettant
 * d'identifier un film, ainsi quelques données affichées à l'écran.
 */
public class MovieReference implements Serializable {

	private static final long serialVersionUID = -2473930217233054067L;

	private String id;
	private String label;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
