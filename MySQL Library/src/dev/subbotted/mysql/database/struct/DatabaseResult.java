package dev.subbotted.mysql.database.struct;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseResult {

	private String tableName = "null";
	
	/*
	 * The results ArrayList stores the rows
	 */
	private List<Map<String, Object>> results = new ArrayList<>();
	
	/*
	 * The columns array
	 * Stores the column titles
	 */
	private List<String> columns = new ArrayList<>();
	
	public DatabaseResult(ResultSet results) throws SQLException {
		ResultSetMetaData metaData = results.getMetaData();
		this.tableName = metaData.getTableName(1);
		int columnCount = metaData.getColumnCount(); // Get the number of columns
		
		for(int i = 1; i <= columnCount; i++) { // Iterate through the columns
			this.columns.add(metaData.getColumnLabel(i)); // Add it to our list
		}
		
		// Now get the rows
		while(results.next()) {
			HashMap<String, Object> row = new HashMap<>();
			for(String columnName : this.columns) {
				Object stored = results.getObject(columnName);
				row.put(columnName, stored);
			}
			
			this.results.add(row);
		}
	}
	
	/**
	 * Returns the results of the query in an array of HashMaps, each array item is a row, each HashMap key is a column
	 * 
	 * @return ArrayList<HashMap<String, Object>>		The results of the query
	 */
	public List<Map<String, Object>> getResult() {
		return this.results;
	}
	
	public int getRowCount() {
		return getResult().size();
	}
	
	public List<String> getColumnNames() {
		return this.columns;
	}
	
	public String getTableName() {
		return this.tableName;
	}
	
}
