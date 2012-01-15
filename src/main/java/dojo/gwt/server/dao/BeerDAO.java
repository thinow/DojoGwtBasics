package dojo.gwt.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dojo.gwt.server.dao.base.BaseDAO;
import dojo.gwt.server.dao.object.BeerDataObject;

public class BeerDAO extends BaseDAO {

	public BeerDataObject getBeer(Long id) throws Exception {
		Connection connection = getConnection();

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT *");
		sql.append(" FROM beer");
		sql.append(" WHERE id = ?");
		String query = sql.toString();

		PreparedStatement statement = connection.prepareStatement(query);
		statement.setLong(1, id);

		ResultSet result = statement.executeQuery();

		if (!atLeastOneRowIn(result)) {
			throw new IllegalStateException("Aucune bière trouvée pour " + id);
		}

		return mapBeerDataObjectFrom(result);
	}

	public List<BeerDataObject> getBestBeers(int count) throws Exception {
		Connection connection = getConnection();

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT TOP ? *");
		sql.append(" FROM beer");
		sql.append(" ORDER BY grade DESC");
		String query = sql.toString();

		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, count);

		ResultSet result = statement.executeQuery();

		List<BeerDataObject> beers = new ArrayList<BeerDataObject>(count);
		while (result.next()) {
			beers.add(mapBeerDataObjectFrom(result));
		}

		return beers;
	}

	public List<BeerDataObject> getStrongestBeers(int count) throws Exception {
		Connection connection = getConnection();

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT TOP ? *");
		sql.append(" FROM beer");
		sql.append(" ORDER BY grade DESC");
		String query = sql.toString();

		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, count);

		ResultSet result = statement.executeQuery();

		List<BeerDataObject> beers = new ArrayList<BeerDataObject>(count);
		while (result.next()) {
			beers.add(mapBeerDataObjectFrom(result));
		}

		return beers;
	}

	public void addBeer(BeerDataObject beer) throws Exception {
		Connection connection = getConnection();

		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO beer");
		sql.append(" (label, description, grade, alcohol, brewery, country)");
		sql.append(" VALUES (?, ?, ?, ?, ?, ?)");
		String query = sql.toString();

		int paramIndex = 1;
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(paramIndex++, beer.getLabel());
		statement.setString(paramIndex++, beer.getDescription());
		statement.setDouble(paramIndex++, beer.getGrade());
		statement.setDouble(paramIndex++, beer.getAlcohol());
		statement.setString(paramIndex++, beer.getBrewery());
		statement.setString(paramIndex++, beer.getCountry());

		statement.executeUpdate();
		ResultSet generatedKeys = statement.getGeneratedKeys();

		if (!atLeastOneRowIn(generatedKeys)) {
			throw new IllegalStateException("Erreur lors de la récupération de"
					+ " l'identifiant créé.");
		}

		beer.setId(generatedKeys.getLong(1));
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
