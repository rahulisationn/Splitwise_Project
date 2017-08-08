package com.alacriti.splitwise.app.splitwise.delegate;

import java.sql.Connection;
import java.sql.SQLException;

import com.alacriti.splitwise.app.splitwise.datasource.MySqlDataSource;

public class BaseDelgate {

	static private Connection connection;

	public static void setConnection(Connection _connection) {

		connection = _connection;
	}

	public Connection getConnection() {

		return connection;
	}

	protected static void endDBTransaction(Connection connection) {
		try {
			connection.commit();

		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
			}
		} catch (Exception e) {
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
			}
		}

	}

	protected static void endDBTransaction(Connection connection,
			boolean isRollback) {

		if (isRollback) {
			try {
				connection.rollback();
			} catch (SQLException e) {
			}

			finally {
				try {
					if (connection != null)
						connection.close();
				} catch (SQLException e) {
				}
			}
		} else {
			endDBTransaction(connection);
		}

	}

	protected static Connection startDBTransaction() {
		Connection conn = null;
		try {
			if (conn == null || conn.isClosed())
				
				conn = MySqlDataSource.getInstance().getConnection();

			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;

	}
}
