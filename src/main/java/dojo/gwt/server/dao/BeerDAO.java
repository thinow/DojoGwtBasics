package dojo.gwt.server.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dojo.gwt.server.dao.base.BaseDAO;
import dojo.gwt.server.dao.object.BeerDataObject;

public class BeerDAO extends BaseDAO {

	public BeerDataObject getBeer(Long id) throws Exception {
		String query = "SELECT * FROM beer WHERE id = ?";

		PreparedStatement statement = createStatementFrom(query);
		statement.setLong(1, id);

		ResultSet result = statement.executeQuery();
		if (!atLeastOneRowIn(result)) {
			throw new IllegalStateException("Aucune bière trouvée pour " + id);
		}

		return mapBeerDataObjectFrom(result);
	}

	public List<BeerDataObject> getBestBeers(int count) throws Exception {
		String query = "SELECT TOP ? * FROM beer ORDER BY grade DESC";

		PreparedStatement statement = createStatementFrom(query);
		statement.setInt(1, count);

		return resultsOfExecutionWith(statement);
	}

	public List<BeerDataObject> getStrongestBeers(int count) throws Exception {
		String query = "SELECT TOP ? * FROM beer ORDER BY alcohol DESC";

		PreparedStatement statement = createStatementFrom(query);
		statement.setInt(1, count);

		return resultsOfExecutionWith(statement);
	}

	public void addBeer(BeerDataObject beer) throws Exception {
		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO beer");
		query.append(" (label, description, grade, alcohol, brewery, country)");
		query.append(" VALUES (?, ?, ?, ?, ?, ?)");

		PreparedStatement statement = createStatementFrom(query.toString());

		int parameterIndex = 1;
		statement.setString(parameterIndex++, beer.getLabel());
		statement.setString(parameterIndex++, beer.getDescription());
		statement.setDouble(parameterIndex++, beer.getGrade());
		statement.setDouble(parameterIndex++, beer.getAlcohol());
		statement.setString(parameterIndex++, beer.getBrewery());
		statement.setString(parameterIndex++, beer.getCountry());

		statement.executeUpdate();
		ResultSet generatedKeys = statement.getGeneratedKeys();

		if (!atLeastOneRowIn(generatedKeys)) {
			throw new IllegalStateException("Erreur lors de la récupération de"
					+ " l'identifiant créé.");
		}

		beer.setId(generatedKeys.getLong(1));
	}

	private PreparedStatement createStatementFrom(String query)
			throws SQLException {
		return getConnection().prepareStatement(query);
	}

	private List<BeerDataObject> resultsOfExecutionWith(
			PreparedStatement statement) throws SQLException {

		ResultSet result = statement.executeQuery();

		List<BeerDataObject> beers = new ArrayList<BeerDataObject>();
		while (result.next()) {
			beers.add(mapBeerDataObjectFrom(result));
		}

		return beers;
	}

	private boolean atLeastOneRowIn(ResultSet result) throws SQLException {
		return result.next();
	}

	private BeerDataObject mapBeerDataObjectFrom(ResultSet result)
			throws SQLException {

		BeerDataObject beer = new BeerDataObject();
		beer.setId(result.getLong("id"));
		beer.setLabel(result.getString("label"));
		beer.setDescription(result.getString("description"));
		beer.setGrade(result.getDouble("grade"));
		beer.setAlcohol(result.getDouble("alcohol"));
		beer.setBrewery(result.getString("brewery"));
		beer.setCountry(result.getString("country"));

		return beer;
	}

}
