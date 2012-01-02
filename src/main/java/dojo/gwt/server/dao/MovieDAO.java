package dojo.gwt.server.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.h2.jdbcx.JdbcConnectionPool;

import dojo.gwt.shared.rpc.object.MovieReference;

public class MovieDAO {

	public MovieDAO() {
		createDatabasePool();
	}

	public MovieReference getMovie(String id) throws Exception {
		Connection connection = connect();

		try {

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT id, label");
			sql.append(" FROM movie");
			sql.append(" WHERE id = ?");
			String query = sql.toString();

			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, id);

			ResultSet result = statement.executeQuery();

			if (!atLeastOneRowIn(result)) {
				throw new IllegalStateException("Aucun film trouvé pour " + id);
			}

			MovieReference movie = new MovieReference();
			movie.setId(result.getString("id"));
			movie.setLabel(result.getString("label"));

			return movie;

		} finally {
			close(connection);
		}
	}

	private boolean atLeastOneRowIn(ResultSet result) throws SQLException {
		return result.next();
	}

	/* ********************************************************************** */
	/* ********************************************************************** */
	/* ********************************************************************** */

	private static final Logger LOGGER = Logger.getAnonymousLogger();

	private static final String DB_NAME = "movie";
	private static final String DB_LOGIN = "sa";
	private static final String DB_PASSWORD = "";

	private static final String INIT_SQL_SCRIPT_FILENAME = "src/main/resources/dojo/gwt/data/script.sql";

	private JdbcConnectionPool pool;

	private void createDatabasePool() {
		pool = JdbcConnectionPool.create(getPoolUrl(), DB_LOGIN, DB_PASSWORD);
	}

	private String getPoolUrl() {
		StringBuilder url = new StringBuilder();
		url.append("jdbc:h2:mem:");
		url.append(DB_NAME);
		url.append(";");
		url.append("INIT=RUNSCRIPT FROM '");
		url.append(INIT_SQL_SCRIPT_FILENAME);
		url.append("'");

		return url.toString();
	}

	private Connection connect() throws SQLException {
		return pool.getConnection();
	}

	private void close(Connection connection) {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "Erreur lors de la déconnexion", e);
		}
	}

}
