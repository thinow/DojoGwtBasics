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
		Long expectedBeerID = Long.valueOf(1);

		// when
		BeerDataObject beer = dao.getBeer(expectedBeerID);

		// then
		assertThat(beer).isNotNull();
		assertThat(beer.getId()).isEqualTo(expectedBeerID.toString());
		assertThat(beer.getLabel()).isEqualTo("Duvel");
	}

	@Test
	public void betterGradedBeers() throws Exception {
		// given
		int expectedCount = 2;

		// when
		List<BeerDataObject> beers = dao.getBestBeers(expectedCount);

		// then
		assertThat(beers).isNotNull().hasSize(expectedCount);

		BeerDataObject firstBeer = beers.get(0);
		BeerDataObject secondBeer = beers.get(1);

		assertThat(firstBeer).isNotNull();
		assertThat(secondBeer).isNotNull();
		assertThat(firstBeer.getGrade()).isGreaterThanOrEqualTo(
				secondBeer.getGrade());
	}
}
