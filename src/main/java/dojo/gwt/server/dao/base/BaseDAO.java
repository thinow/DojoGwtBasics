package dojo.gwt.server.dao.base;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.io.IOUtils;

public class BaseDAO {
	private static final String DB_URL = "jdbc:h2:mem:beer";

	private static final String DB_LOGIN = "sa";
	private static final String DB_PASS = "";

	private static final String INIT_SCRIPT_FILENAME = "dojo/gwt/data/script.sql";

	private static boolean initializedDatabase = false;

	private Connection connection;

	protected Connection getConnection() {
		if (!isDatabaseConnected()) {
			connect();
		}

		return connection;
	}

	private boolean isDatabaseConnected() {
		return connection != null;
	}

	private void connect() {
		try {

			Class.forName("org.h2.Driver");
			connection = DriverManager.getConnection(DB_URL, DB_LOGIN, DB_PASS);

			launchInitDatabaseScript();

		} catch (Exception e) {
			throw new IllegalStateException("Erreur lors de la connexion", e);
		}
	}

	private void launchInitDatabaseScript() throws SQLException, IOException {
		if (isDatabaseAlreadyInitialized()) {
			return;
		}

		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream query = loader.getResourceAsStream(INIT_SCRIPT_FILENAME);
		connection.prepareCall(IOUtils.toString(query)).execute();

		confirmDatabaseInitialisation();
	}

	private void confirmDatabaseInitialisation() {
		initializedDatabase = true;
	}

	private boolean isDatabaseAlreadyInitialized() {
		return initializedDatabase;
	}
}
