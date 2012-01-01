package dojo.gwt.server.dao;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import dojo.gwt.shared.rpc.object.MovieReference;

public class MovieDAOTest {

	private MovieDAO dao;

	@Before
	public void setUp() throws Exception {
		dao = new MovieDAO();
	}

	@Test
	public void getOneSpecificMovie() throws Exception {
		// given
		String expectedMovieID = "1";

		// when
		MovieReference movie = dao.getMovie(expectedMovieID);

		// then
		assertThat(movie).isNotNull();
		assertThat(movie.getId()).isEqualTo(expectedMovieID);
		assertThat(movie.getLabel()).isEqualTo("Mon film");
	}
}
