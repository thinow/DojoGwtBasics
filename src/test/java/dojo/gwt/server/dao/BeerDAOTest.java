package dojo.gwt.server.dao;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dojo.gwt.server.dao.object.BeerDataObject;

public class BeerDAOTest {

	private static final String BEER_COUNTRY = "BEER-COUNTRY";
	private static final String BEER_BREWERY = "BEER-BREWERY";
	private static final double BEER_ALCOHOL = 8.2;
	private static final double BEER_GRADE = 5.12;
	private static final String BEER_DESCRIPTION = "BEER-DESC";
	private static final String BEER_LABEL = "BEER-LABEL";
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
	public void gradestBeers() throws Exception {
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

	@Test
	public void addBeers() throws Exception {
		// given
		BeerDataObject beer = new BeerDataObject();
		beer.setLabel(BEER_LABEL);
		beer.setDescription(BEER_DESCRIPTION);
		beer.setGrade(BEER_GRADE);
		beer.setAlcohol(BEER_ALCOHOL);
		beer.setBrewery(BEER_BREWERY);
		beer.setCountry(BEER_COUNTRY);

		// when
		dao.addBeer(beer);

		// then
		assertThat(beer.getId()).isNotNull().isNotEmpty();
	}
}
