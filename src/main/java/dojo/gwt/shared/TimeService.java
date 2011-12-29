package dojo.gwt.shared;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * Service de test permettant de récupérer l'heure sur le serveur.
 */
@RemoteServiceRelativePath("time")
public interface TimeService extends RemoteService {

	/**
	 * Récupère la date et l'heure du serveur.
	 */
	java.util.Date getTime();

}
