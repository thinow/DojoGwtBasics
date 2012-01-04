package dojo.gwt.server.dao;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dojo.gwt.server.dao.object.BeerDataObject;

public class BeerDAOTest {

	private BeerDAO dao;

	@Before
	public void setUp() throws Exception {
		dao = new BeerDAO();
	}

	@Test
	public void getOneSpecificMovie() throws Exception {
		// given
		String expectedMovieID = "1";

		// when
		BeerDataObject movie = dao.getMovie(expectedMovieID);

		// then
		assertThat(movie).isNotNull();
		assertThat(movie.getId()).isEqualTo(expectedMovieID);
		assertThat(movie.getLabel()).isEqualTo("Mon film");
		assertThat(movie.getDescription()).isEqualTo("C'est un beau film...");
		assertThat(movie.getGrade()).isEqualTo(0.75);
	}

	@Test
	public void betterGradedMovies() throws Exception {
		// given
		int expectedCount = 2;

		// when
		List<BeerDataObject> movies = dao.getBestMovies(expectedCount);

		// then
		assertThat(movies).isNotNull().hasSize(expectedCount);

		assertThat(movies.get(0)).isNotNull();
		assertThat(movies.get(0).getId()).isEqualTo("3");

		assertThat(movies.get(1)).isNotNull();
		assertThat(movies.get(1).getId()).isEqualTo("2");
	}
}
