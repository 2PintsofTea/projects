package dev.subbotted.mysql.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dev.subbotted.mysql.database.struct.DatabaseResult;

public class Database {
	
	private Connection connection;
	
	/**
	 * Creates a new Database connection
	 * 
	 * This is a class used to create a database connection, execute queries and manage returning the results
	 * from the query to the calling function. <strong>This is for SQL databases only</strong>
	 * 
	 * @param String 	host			Host to connect to
	 * @param int 		port			Port to connect to host on
	 * @param String 	databaseName	Name of the database to use
	 * @param String 	username		Username for the database
	 * @param String 	password		Password for the database
	 * 
	 * @throws ClassNotFoundException 	Throws ClassNotFound exception if the MySQL JBDC driver was not found.
	 * @throws SQLException 			Throws SQLException if the database connection could not be established.
	 */
	public Database(String host, int port, String databaseName, String username, String password) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		this.connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + databaseName, username, password);
	}
	
	/**
	 * Executes a query to the database and returns a result
	 * 
	 * Intended for SELECT and other data collecting queries.
	 * 
	 * @param String 	query			The query to execute
	 * @return DatabaseResult			The result returned from the query
	 * @throws SQLException				An SQL exception occurred
	 */
	public DatabaseResult getResultSet(String query) throws SQLException {
		Statement statement = this.connection.createStatement();
		ResultSet results = statement.executeQuery(query);
		DatabaseResult result = new DatabaseResult(results);
		statement.close();
		results.close();
		return result;
	}
	
	/**
	 * Executes a query to the database and returns whether it was successful or not.
	 * 
	 * Intended for UPDATE, INSERT and other data manipulation queries.
	 * 
	 * @param String 	query			The query to execute
	 * @return Boolean	success			Did the request succeed?
	 * @throws SQLException				An SQL exception occurred
	 */
	public boolean execute(String query) throws SQLException {
		Statement statement = this.connection.createStatement();
		boolean success = statement.execute(query);
		statement.close();
		return success;
	}
	
}
