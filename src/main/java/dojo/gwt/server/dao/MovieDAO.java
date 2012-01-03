package dojo.gwt.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dojo.gwt.server.dao.base.BaseDAO;
import dojo.gwt.server.dao.object.MovieDataObject;

public class MovieDAO extends BaseDAO {

	public MovieDataObject getMovie(String id) throws Exception {
		Connection connection = getConnection();

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id, label, description, grade");
		sql.append(" FROM movie");
		sql.append(" WHERE id = ?");
		String query = sql.toString();

		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, id);

		ResultSet result = statement.executeQuery();

		if (!atLeastOneRowIn(result)) {
			throw new IllegalStateException("Aucun film trouvé pour " + id);
		}

		return mapMovieDataObjectFrom(result);
	}

	public List<MovieDataObject> getBestMovies(int count) throws Exception {
		Connection connection = getConnection();

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT TOP ? id, label, description, grade");
		sql.append(" FROM movie");
		sql.append(" ORDER BY grade DESC");
		String query = sql.toString();

		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, count);

		ResultSet result = statement.executeQuery();

		List<MovieDataObject> movies = new ArrayList<MovieDataObject>(count);
		while (result.next()) {
			movies.add(mapMovieDataObjectFrom(result));
		}

		return movies;
	}

	private boolean atLeastOneRowIn(ResultSet result) throws SQLException {
		return result.next();
	}

	private MovieDataObject mapMovieDataObjectFrom(ResultSet result)
			throws SQLException {

		MovieDataObject movie = new MovieDataObject();
		movie.setId(result.getString("id"));
		movie.setLabel(result.getString("label"));
		movie.setDescription(result.getString("description"));
		movie.setGrade(result.getDouble("grade"));

		return movie;
	}

}
