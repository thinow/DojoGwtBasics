package dojo.gwt.server;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import dojo.gwt.server.dao.BeerDAO;
import dojo.gwt.server.dao.object.BeerDataObject;
import dojo.gwt.shared.rpc.object.BeerReference;
import dojo.gwt.shared.rpc.service.BeerService;

public class BeerServiceImpl extends RemoteServiceServlet implements
		BeerService {

	private static final long serialVersionUID = 4685407513958591487L;

	private BeerDAO movieDAO = new BeerDAO();

	@Override
	public BeerReference[] getTopMovies(Integer count) throws Exception {
		List<BeerDataObject> movies = movieDAO.getBestMovies(count);

		return moviesReferencesOf(movies);
	}

	private BeerReference[] moviesReferencesOf(List<BeerDataObject> movies) {
		int size = movies.size();
		List<BeerReference> references = new ArrayList<BeerReference>(size);
		for (BeerDataObject movie : movies) {
			references.add(movieReferenceOf(movie));
		}

		return references.toArray(new BeerReference[size]);
	}

	private BeerReference movieReferenceOf(BeerDataObject movie) {
		BeerReference reference = new BeerReference();
		reference.setId(movie.getId());
		reference.setLabel(movie.getLabel());

		return reference;
	}

}
