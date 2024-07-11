package genericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

/**
 * This class consists of generic or reusable methods related to database
 */
public class DatabaseUtility {
	
	Connection connections;
	Statement statements;
	
	/**
	 * This method will use to connect with the database
	 * @param URL
	 * @param username
	 * @param password
	 * @throws SQLException
	 */
	public void connectToDatabase(String URL, String username, String password) throws SQLException
	{
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		connections = DriverManager.getConnection(URL, username, password);
		statements = connections.createStatement();
	}
	
	/**
	 * This method will use to execute query
	 * @param query
	 * @return resultQuery
	 * @throws SQLException
	 */
	public ResultSet executeQuery(String query) throws SQLException
	{
		ResultSet resultQuery = statements.executeQuery(query);
		return resultQuery;
	}
	
	/**
	 * This method will use to update and execute that update
	 * @param query
	 * @return resultUpdate
	 * @throws SQLException
	 */
	public int executeUpdate(String query) throws SQLException
	{
		int resultUpdate = statements.executeUpdate(query);
		return resultUpdate;
	}
	
	/**
	 * This method is use to close the statement and connection
	 * @throws SQLException
	 */
	public void closeTheConnectionAndStatement() throws SQLException
	{
		if(statements != null)
		{
			statements.close();
		}
		
		if(connections != null)
		{
			connections.close();
		}
	}
}
