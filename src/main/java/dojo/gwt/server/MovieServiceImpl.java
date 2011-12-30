package dojo.gwt.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import dojo.gwt.shared.rpc.object.MovieReference;
import dojo.gwt.shared.rpc.service.MovieService;

public class MovieServiceImpl extends RemoteServiceServlet implements
		MovieService {

	private static final long serialVersionUID = 4685407513958591487L;

	@Override
	public MovieReference[] getTopMovies(Integer count) {

		MovieReference[] movies = new MovieReference[count];
		for (int index = 0; index < count; index++) {
			MovieReference movie = new MovieReference();
			movie.setId("ID-" + index);
			movie.setLabel("Film #" + index);

			movies[index] = movie;
		}

		return movies;
	}

}
