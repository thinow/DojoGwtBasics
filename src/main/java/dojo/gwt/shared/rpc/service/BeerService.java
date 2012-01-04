package dojo.gwt.shared.rpc.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import dojo.gwt.shared.rpc.object.BeerReference;

@RemoteServiceRelativePath("movie")
public interface BeerService extends RemoteService {

	/**
	 * Récupère les meilleurs films.
	 */
	BeerReference[] getTopMovies(Integer count) throws Exception;

}
