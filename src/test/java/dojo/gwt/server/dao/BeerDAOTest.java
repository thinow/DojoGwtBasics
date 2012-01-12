package dojo.gwt.server.dao;

import static org.fest.assertions.Assertions.assertThat;

import java.util.List;

import org.fest.assertions.Condition;
import org.junit.Before;
import org.junit.Test;

import dojo.gwt.server.dao.object.BeerDataObject;

public class BeerDAOTest {

	private static final Long DUVEL_BEER_ID = Long.valueOf(1);
	private static final String DUVEL_BEER_LABEL = "Duvel";

	private static final String NEW_BEER_COUNTRY = "BEER-COUNTRY";
	private static final String NEW_BEER_BREWERY = "BEER-BREWERY";
	private static final double NEW_BEER_ALCOHOL = 8.2;
	private static final double NEW_BEER_GRADE = 0.12;
	private static final String NEW_BEER_DESCRIPTION = "BEER-DESC";
	private static final String NEW_BEER_LABEL = "BEER-LABEL";

	private BeerDAO dao;

	@Before
	public void setUp() throws Exception {
		dao = new BeerDAO();
	}

	@Test
	public void getOneSpecificBeer() throws Exception {
		// when
		BeerDataObject beer = dao.getBeer(DUVEL_BEER_ID);

		// then
		assertThat(beer).isNotNull();
		assertThat(beer.getId()).isEqualTo(DUVEL_BEER_ID);
		assertThat(beer.getLabel()).isEqualTo(DUVEL_BEER_LABEL);
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
		BeerDataObject inputBeer = new BeerDataObject();
		inputBeer.setLabel(NEW_BEER_LABEL);
		inputBeer.setDescription(NEW_BEER_DESCRIPTION);
		inputBeer.setGrade(NEW_BEER_GRADE);
		inputBeer.setAlcohol(NEW_BEER_ALCOHOL);
		inputBeer.setBrewery(NEW_BEER_BREWERY);
		inputBeer.setCountry(NEW_BEER_COUNTRY);

		// when
		dao.addBeer(inputBeer);

		// then
		assertThat(inputBeer.getId()).isNotNull().isGreaterThan(0);

		BeerDataObject storedBeer = dao.getBeer(inputBeer.getId());
		assertThat(storedBeer).as("Same beer").is(sameAs(inputBeer));
	}

	private Condition<Object> sameAs(final BeerDataObject expectedBeer) {
		return new Condition<Object>() {
			@Override
			public boolean matches(Object value) {
				BeerDataObject beer = (BeerDataObject) value;

				return value != null
						&& expectedBeer.getId().equals(beer.getId())
						&& expectedBeer.getLabel().equals(beer.getLabel());
			}
		};
	}
}
