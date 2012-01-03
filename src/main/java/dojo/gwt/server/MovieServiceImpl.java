package dojo.gwt.server;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import dojo.gwt.server.dao.MovieDAO;
import dojo.gwt.server.dao.object.MovieDataObject;
import dojo.gwt.shared.rpc.object.MovieReference;
import dojo.gwt.shared.rpc.service.MovieService;

public class MovieServiceImpl extends RemoteServiceServlet implements
		MovieService {

	private static final long serialVersionUID = 4685407513958591487L;

	private MovieDAO movieDAO = new MovieDAO();

	@Override
	public MovieReference[] getTopMovies(Integer count) throws Exception {
		List<MovieDataObject> movies = movieDAO.getBestMovies(count);

		return moviesReferencesOf(movies);
	}

	private MovieReference[] moviesReferencesOf(List<MovieDataObject> movies) {
		int size = movies.size();
		List<MovieReference> references = new ArrayList<MovieReference>(size);
		for (MovieDataObject movie : movies) {
			references.add(movieReferenceOf(movie));
		}

		return references.toArray(new MovieReference[size]);
	}

	private MovieReference movieReferenceOf(MovieDataObject movie) {
		MovieReference reference = new MovieReference();
		reference.setId(movie.getId());
		reference.setLabel(movie.getLabel());

		return reference;
	}

}
