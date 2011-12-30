package dojo.gwt.shared.rpc.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import dojo.gwt.shared.rpc.object.MovieReference;

@RemoteServiceRelativePath("movie")
public interface MovieService extends RemoteService {

	/**
	 * Récupère les meilleurs films.
	 */
	MovieReference[] getTopMovies(Integer count);

}
