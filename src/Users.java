import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
		u.addUser(u.getNextUserID(), "test", "elephants", 2);
		//u.resetPassword(2, "new");
		System.out.println(u.getUserTypeByID(1));
		//u.deleteUser(1);
		u.close();
	}
	*/
	
	
	/**
	 * Users Constructor
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
	 * @param type
	 */
	public void addUser(int ID, String username, String password, int type)
	{
		// Insert the table
		try {
		    String insertString = "INSERT INTO Users(idUsers, Username, Password, UserType) VALUES (" 
		+ ID + ", '" + username + "', '" + password + "', " + type + ")";
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
	 * @return boolean - Depending on if both credentials were found
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
				if ((rs.getString(2).equals(username)) && (rs.getString(3).equals(password))) {
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
	
	/**
	 * Get user by credentials
	 * 
	 * @return String - the user type
	 */
	public String getTypeByCredentials(String username, String password)
	{
		Statement stmt = null;
		ResultSet rs = null;
		try {
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery("SELECT * FROM Users");
			rs.first();
			while(!rs.isAfterLast())
			{				
				if ((rs.getString(2).equals(username)) && (rs.getString(3).equals(password))) {
					//System.out.println();
					return rs.getString(4);
				}
				rs.next();
			} 
			return "";
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
			return "";
	}
	
	/**
	 * Check if a username is already in the system
	 * 
	 * @return boolean - Depending if the username was found 
	 */
	public boolean checkUsername(String username)
	{
		Statement stmt = null;
		ResultSet rs = null;
		try {
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery("SELECT * FROM Users");
			rs.first();
			while(!rs.isAfterLast())
			{
				if (rs.getString(2).equals(username)) {
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
	
	/**
	 * Reset password 
	 * 
	 * @param ID
	 * @param newPassword
	 */
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
	
	/**
	 * Change user type (1 thru 3)
	 * 
	 * @param ID
	 * @param int
	 */
	public void updateUserType(int ID, int newType)
	{
		try {
		    String newTypeString = "UPDATE Users SET UserType='" + newType + "' WHERE idUsers=" + ID;
			this.executeUpdate(conn, newTypeString);
			System.out.println("Update user type successful");
	    } catch (SQLException e) {
			System.out.println("[ERROR: Could not update user type.]");
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
	 * Get user type for a given User ID
	 * 
	 * @param ID
	 * @return String
	 */
	public int getUserTypeByID(int ID)
	{
		int userType = -1;
		Statement stmt = null;
		ResultSet rs = null;
		try {
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery("SELECT UserType FROM Users WHERE idUsers=" + ID);
	        rs.first();
			
	        userType = rs.getInt(1);
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		return userType;
	}
	
	/**
	 * Return all items present in the table
	 * 
	 * @return ArrayList<Item>
	 */
	public String getUserInfo()
	{
		//ArrayList<User> all = new ArrayList<User>();
		String output = "";
		Statement stmt = null;
		ResultSet rs = null;
		try {

	        stmt = conn.createStatement();
	        rs = stmt.executeQuery("SELECT * FROM Users");
			
			rs.first();
			while(!rs.isAfterLast())
			{
				//all.add(new Item(
				output += "ID: " + rs.getInt(1) + "\n Username: " + rs.getString(2) + "\n Password: " + rs.getString(3) + "\n Type: " + rs.getInt(4) + "\n";
//				System.out.println(output);
				rs.next();
			}
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
			return output;
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
