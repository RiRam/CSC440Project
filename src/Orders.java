import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Properties;


/**
 * Orders class
 * 
 * @author Erica Ram
 */

public class Orders {
	/** The name of the MySQL account to use */
	private final String userName = "root";

	/** The password for the MySQL account */
	private final String password = "csc440";

	/** The name of the computer running the database on it */
	private final String serverName = "localhost";

	/** The port of the MySQL server (default is 3306) */
	private final int portNumber = 3306;

	/** The name of the database */
	private final String dbName = "Warehouse";
	
	/** The connection to the database */
	private Connection conn = null;
	
	/**
	 * Inventory Constructor
	 */
	public Orders()
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
	 * Add an Order to the Orders table
	 * 
	 * @param ID - Order ID
	 * @param storeID - Store ID
	 * @param comment - Comment
	 */
	public void addOrder(int ID, String storeID, String comment)
	{
		// Insert the table
		try {
		    String insertString = "INSERT INTO Orders(OrderID, StoreID, Comment) VALUES (" 
		+ ID + ", '" + storeID + "', '" + comment + "');";
		    System.out.println(insertString);
			this.executeUpdate(conn, insertString);
			System.out.println("Insert successful");
	    } catch (SQLException e) {
			System.out.println("[ERROR: Could not insert to the table.]");
			e.printStackTrace();
			return;
		}
	}
	
	/**
	 * Delete an Order from the Orders table by a given ID number
	 * 
	 * @param ID - Order ID
	 */
	public void deleteOrder(int ID)
	{
		try {
		    String deleteString = "DELETE FROM Orders WHERE OrderID=" + ID + ";";
		    System.out.println(deleteString);
			this.executeUpdate(conn, deleteString);
			System.out.println("Delete successful");
	    } catch (SQLException e) {
			System.out.println("[ERROR: Could not delete to the table]");
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
	 * Get an Order from the Orders table by a given ID number
	 * 
	 * @param ID - Order ID
	 * @return Order - Order
	 */
	public Order getOrder(int ID)
	{
		Order o = new Order();
		Statement stmt = null;
		ResultSet rs = null;
		try {
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery("SELECT * FROM Orders WHERE OrderID=" + ID);
	        rs.first();
			
	        o = new Order(rs.getInt(1), rs.getString(2), rs.getString(3));
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		return o;
	}
	
	/**
	 * Returns the next Order ID
	 * 
	 * @return int - next Order ID (i.e. if the current highest Order ID is 3, returns 4)
	 */
	public int getNextOrderID()
	{
		int next = -1;
		Statement stmt = null;
		ResultSet rs = null;
		try {
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery("SELECT MAX(OrderID) FROM Orders");
	        rs.first();
	        next = rs.getInt(1);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		return next + 1;
	}
}
	