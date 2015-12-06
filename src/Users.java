import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Users {
	/** The name of the MySQL account to use */
	private final String userName = "admin";

	/** The password for the MySQL account */
	private final String password = "warehouse";

	/** The name of the computer running the database on it */
	private final String serverName = "warehouse.cd2f0yi9ywlu.us-west-2.rds.amazonaws.com";

	/** The port of the MySQL server (default is 3306) */
	private final int portNumber = 3306;

	/** The name of the database */
	private final String dbName = "Warehouse";
	
	/** The connection to the database */
	private Connection conn = null;
	
	/*
	public static void main(String[] args)
	{
		Users u = new Users();
		//u.addUser(u.getNextUserID(), "test", "elephants");
		//u.resetPassword(2, "new");
		System.out.println(u.getUsernameByID(1));
		//u.deleteUser(1);
		u.close();
	}
	*/
	
	
	/**
	 * Orders Constructor
	 */
	public Users()
	{
		this.run();
	}
	
	/**
	 * Generate a new database connection
	 * 
	 * @throws SQLException if connection unsuccessful
	 */
	public Connection getConnection() throws SQLException {
		conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName);		
		connectionProps.put("password", this.password);
	
		conn = DriverManager.getConnection("jdbc:mysql://"
				+ this.serverName + ":" + this.portNumber + "/" + this.dbName,
				connectionProps);

		return conn;
	}

	/**
	 * Run a SQL command that doesn't return anything (CREATE/INSERT/UPDATE/DELETE/DROP/etc.)
	 * 
	 * @throws SQLException if unsuccessful
	 */
	public boolean executeUpdate(Connection conn, String command) throws SQLException {
		if(command.contains(";") || command.contains("DROP TABLE"))
	    	throw new SQLException();
	    Statement stmt = null;
	    try {
	        stmt = conn.createStatement();
	        stmt.executeUpdate(command); 
	        return true;
	    } finally {
	        if (stmt != null) { stmt.close(); }
	    }
	}
	
	
	/**
	 * Connect to MySQL database.
	 */
	public void run() {
		// Connect to MySQL
		try {
			conn = this.getConnection();
			System.out.println("Connected to database");
		} catch (SQLException e) {
			System.out.println("[ERROR: Could not connect to the database.]");
			e.printStackTrace();
			return;
		}
	}
	
	/**
	 * Add a User to the Users table
	 * 
	 * @param ID
	 * @param username
	 * @param password
	 */
	public void addUser(int ID, String username, String password)
	{
		// Insert the table
		try {
		    String insertString = "INSERT INTO Users(idUsers, Username, Password) VALUES (" 
		+ ID + ", '" + username + "', '" + password + "')";
		    //System.out.println(insertString);
			this.executeUpdate(conn, insertString);
			System.out.println("Insert successful");
	    } catch (SQLException e) {
			System.out.println("[ERROR: Could not insert to the table.]");
			e.printStackTrace();
			return;
		}
	}
	
	/**
	 * Delete a User from the Users table by a given ID number
	 * 
	 * @param ID - User ID
	 */
	public void deleteUser(int ID)
	{
		try {
		    String deleteString = "DELETE FROM Users WHERE idUsers=" + ID;
			//System.out.println(deleteString);
			this.executeUpdate(conn, deleteString);
			System.out.println("Users delete successful");
	    } catch (SQLException e) {
			System.out.println("[ERROR: Could not delete from the table]");
			e.printStackTrace();
			return;
		}
	}
	
	/**
	 * Check if a user login is valid 
	 * 
	 * @return boolean
	 */
	public boolean checkUserCredentials(String username, String password)
	{
		Statement stmt = null;
		ResultSet rs = null;
		try {
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery("SELECT * FROM Users");
			rs.first();
			while(!rs.isAfterLast())
			{
				if (rs.getString(2).equals(username) && rs.getString(3).equals(password)) {
					return true;
				}
				rs.next();
			} 
			return false;
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
			return false;
	}
	
	public void resetPassword(int ID, String newPassword)
	{
		try {
		    String newPasswordString = "UPDATE Users SET Password='" + newPassword + "' WHERE idUsers=" + ID;
		    //System.out.println(newPasswordString);
			this.executeUpdate(conn, newPasswordString);
			System.out.println("Update password successful");
	    } catch (SQLException e) {
			System.out.println("[ERROR: Could not update password.]");
			e.printStackTrace();
			return;
		}
	}

	public void close()
	{
		try
		{
			conn.close();
			System.out.println("Connection close successful");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Get username for a given User ID
	 * 
	 * @param ID
	 * @return String
	 */
	public String getUsernameByID(int ID)
	{
		String username = "";
		Statement stmt = null;
		ResultSet rs = null;
		try {
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery("SELECT Username FROM Users WHERE idUsers=" + ID);
	        rs.first();
			
	        username = rs.getString(1);
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		return username;
	}
	
	/**
	 * Returns the next User ID
	 * 
	 * @return int - next User ID (i.e. if the current highest User ID is 3, returns 4)
	 */
	public int getNextUserID()
	{
		int next = -1;
		Statement stmt = null;
		ResultSet rs = null;
		try {
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery("SELECT MAX(idUsers) FROM Users");
	        rs.first();
	        next = rs.getInt(1);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		return next + 1;
	}
}
