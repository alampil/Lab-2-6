package providersSql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import interfaces.IGenericProviderSql;

public class GenericProviderSql<T> implements IGenericProviderSql<T> {
	private static Connection connection;
	private GenericProviderSql<T> instance;

	public GenericProviderSql() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/airports";
			connection = DriverManager.getConnection(url, "root", "12345");
		} catch (ClassNotFoundException ex) {
			throw new Exception(ex);
		} catch (SQLException sqlEx) {
			throw new Exception(sqlEx);
		}
	}

	public synchronized GenericProviderSql<T> getInstance() throws Exception {
		if (instance == null) {
			instance = new GenericProviderSql<T>();
		}
		return instance;
	}

	private String genereteCommandText(String procedureName, Object[] sqlParametres) {
		StringBuilder command = new StringBuilder(procedureName);
		command.append("(");
		for (int i = 0; i < sqlParametres.length; i++) {
			if (sqlParametres[i].getClass().equals(String.class)) {
				sqlParametres[i] = ((String) sqlParametres[i]).replace("'", "'");
			}
			if (i == 0) {
				command.append(sqlParametres[i] == null ? "null" : "'" + sqlParametres[i] + "'");
			} else {
				command.append(sqlParametres[i] == null ? "null" : ",'" + sqlParametres[i] + "'");
			}
		}
		command.append(");");
		return command.toString();
	}

	@Override
	public void execute(String procedureName, Object[] sqlParametres) throws SQLException {
		String command = genereteCommandText(procedureName, sqlParametres);
		PreparedStatement stm = null;
		try {
			stm = connection.prepareStatement(command);
			stm.execute();
		} finally {
			if (stm != null) {
				stm.close();
			}
		}

	}

	@Override
	public ResultSet getList(String procedureName, Object[] sqlParametres) throws SQLException {
		String command = genereteCommandText(procedureName, sqlParametres);
		PreparedStatement stm = null;
		stm = connection.prepareStatement(command);
		return stm.executeQuery();
	}

}

