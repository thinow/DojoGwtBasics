package dojo.gwt.shared.rpc.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import dojo.gwt.shared.rpc.object.BeerReference;

@RemoteServiceRelativePath("beer")
public interface BeerService extends RemoteService {

	/**
	 * Récupère les meilleurs bières.
	 */
	BeerReference[] getTopBeers(Integer count) throws Exception;

}
