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
	public void getOneSpecificBeer() throws Exception {
		// given
		String expectedBeerID = "1";

		// when
		BeerDataObject beer = dao.getBeer(expectedBeerID);

		// then
		assertThat(beer).isNotNull();
		assertThat(beer.getId()).isEqualTo(expectedBeerID);
		assertThat(beer.getLabel()).isEqualTo("Une bière");
		assertThat(beer.getDescription()).isEqualTo("C'est une bonne bière...");
		assertThat(beer.getGrade()).isEqualTo(0.75);
	}

	@Test
	public void betterGradedBeers() throws Exception {
		// given
		int expectedCount = 2;

		// when
		List<BeerDataObject> beers = dao.getBestBeers(expectedCount);

		// then
		assertThat(beers).isNotNull().hasSize(expectedCount);

		assertThat(beers.get(0)).isNotNull();
		assertThat(beers.get(0).getId()).isEqualTo("3");

		assertThat(beers.get(1)).isNotNull();
		assertThat(beers.get(1).getId()).isEqualTo("2");
	}
}
