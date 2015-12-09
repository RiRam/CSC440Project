import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.ArrayList;


/**
 * Orders class
 * 
 * @author Erica Ram
 */

public class Orders {
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
		Orders ord = new Orders();
		ArrayList<OrderLine> lines = new ArrayList<OrderLine>();
		lines.add(new OrderLine(2, 4, "To Be Picked"));
		lines.add(new OrderLine(3, 1, "To Be Picked"));
		lines.add(new OrderLine(4, 8, "To Be Picked"));
		lines.add(new OrderLine(2, 2, "To Be Picked"));
		ord.addOrder(ord.getNextOrderID(), "17", "test comment", "To Be Picked", lines);
		//ord.deleteOrder(6);
		ord.close();
	}
	*/
	
	
	/**
	 * Orders Constructor
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
	 * Add an Order to the Orders table
	 * 
	 * @param ID - Order ID
	 * @param storeID - Store ID
	 * @param comment - Comment
	 */
	public void addOrder(int ID, String storeID, String comment, String status, ArrayList<OrderLine> arr)
	{
		// Insert the table
		try {
		    String insertString = "INSERT INTO Orders(OrderID, StoreID, Comment, Status) VALUES (" 
		+ ID + ", '" + storeID + "', '" + comment + "', '" + status + "')";
		    //System.out.println(insertString);
			this.executeUpdate(conn, insertString);
			System.out.println("Insert successful");
			for(OrderLine a : arr)
			{
				insertString = "INSERT INTO OrderLines(idOrderLines, OrderID, LineItem, Quantity, Status) VALUES (" 
						+ this.getNextOrderLineID()  + ", '" + ID + "', '" + a.getLineItemID() + "', '" 
						+ a.getQuantity() + "', '" + a.getOrderLineStatus() + "')";
				this.executeUpdate(conn, insertString);
				System.out.println("Insert successful");
			}
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
		    String deleteString = "DELETE FROM OrderLines WHERE OrderID=" + ID;
			//System.out.println(deleteString);
			this.executeUpdate(conn, deleteString);
			System.out.println("OrderLines delete successful");
		    
		    deleteString = "DELETE FROM Orders WHERE OrderID=" + ID;
		    System.out.println(deleteString);
			this.executeUpdate(conn, deleteString);
			System.out.println("Delete successful");
			
	    } catch (SQLException e) {
			System.out.println("[ERROR: Could not delete to the table]");
			e.printStackTrace();
			return;
		}
	}
	
	/**
	 * Update the StoreID of an Order by a given ID number
	 * 
	 * @param ID - Order ID
	 * @param newStoreID - new Store ID to assign to Order
	 */
	public void updateStoreIDByID(int ID, String newStoreID)
	{
		try {
		    String newStoreIDString = "UPDATE Orders SET StoreID='" + newStoreID + "' WHERE OrderID=" + ID;
		    //System.out.println(newStoreIDString);
			this.executeUpdate(conn, newStoreIDString);
			System.out.println("Update Store ID successful");
	    } catch (SQLException e) {
			System.out.println("[ERROR: Could not update Store ID.]");
			e.printStackTrace();
			return;
		}
	}
	
	/**
	 * Update the Comment of an Order by a given ID number
	 * 
	 * @param ID - Order ID
	 * @param newComment - new Comment to assign to Order
	 */
	public void updateCommentByID(int ID, String newComment)
	{
		try {
		    String newCommentString = "UPDATE Orders SET Comment='" + newComment + "' WHERE OrderID=" + ID;
		    //System.out.println(newCommentString);
			this.executeUpdate(conn, newCommentString);
			System.out.println("Update Comment successful");
	    } catch (SQLException e) {
			System.out.println("[ERROR: Could not update Comment.]");
			e.printStackTrace();
			return;
		}
	}
	
	/**
	 * Update the Status of an Order by a given ID number
	 * 
	 * @param ID - Order ID
	 * @param newStatus - new Comment to assign to Order
	 */
	public void updateStatusByID(int ID, String newStatus)
	{
		try {
		    String newStatusString = "UPDATE Orders SET Status='" + newStatus + "' WHERE OrderID=" + ID;
		    //System.out.println(newStatusString);
			this.executeUpdate(conn, newStatusString);
			System.out.println("Update Status successful");
	    } catch (SQLException e) {
			System.out.println("[ERROR: Could not update Status.]");
			e.printStackTrace();
			return;
		}
	}
	
	/**
	 * Update the Status of an OrderLine by a given ID number
	 * 
	 * @param ID - OrderLine ID
	 * @param newStatus - new Comment to assign to OrderLine
	 */
	public void updateOrderLineStatusByID(int ID, String newStatus)
	{
		try {
		    String newStatusString = "UPDATE OrderLines SET Status='" + newStatus + "' WHERE idOrderLines=" + ID;
		    //System.out.println(newStatusString);
			this.executeUpdate(conn, newStatusString);
			System.out.println("Update Status successful");
	    } catch (SQLException e) {
			System.out.println("[ERROR: Could not update Status.]");
			e.printStackTrace();
			return;
		}
	}
	
	/**
	 * Update the Status of an OrderLine by a given Item ID number
	 * 
	 * @param ID - Item ID
	 * @param newStatus - new Comment to assign to OrderLine
	 */
	public void updateOrderLineStatusByItemID(int ID, String newStatus)
	{
		try {
		    String newStatusString = "UPDATE OrderLines SET Status='" + newStatus + "' WHERE LineItem=" + ID;
		    //System.out.println(newStatusString);
			this.executeUpdate(conn, newStatusString);
			System.out.println("Update Status successful");
	    } catch (SQLException e) {
			System.out.println("[ERROR: Could not update Status.]");
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
			
	        o = new Order(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), this.getOrderLines(rs.getInt(1)));
			
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
	
	/**
	 * Returns the next OrderLine ID
	 * 
	 * @return int - next OrderLine ID (i.e. if the current highest OrderLine ID is 3, returns 4)
	 */
	public int getNextOrderLineID()
	{
		int next = -1;
		Statement stmt = null;
		ResultSet rs = null;
		try {
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery("SELECT MAX(idOrderLines) FROM OrderLines");
	        rs.first();
	        next = rs.getInt(1);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		return next + 1;
	}
	
	/**
	 * Returns ArrayList of Order Lines 
	 * 
	 * @param ID
	 * @return ArrayList<OrderLine>
	 */
	public ArrayList<OrderLine> getOrderLines(int ID)
	{
		ArrayList<OrderLine> arr = new ArrayList<OrderLine>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery("SELECT * FROM OrderLines WHERE OrderID=" + ID);
	        rs.first();
	        while(!rs.isAfterLast())
			{
	        	arr.add(new OrderLine(rs.getInt(3), rs.getInt(4), rs.getString(5)));
	        	rs.next();
			}
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		return arr;
	}
	
	/**
	 * Generate PickLines
	 * 
	 * @return ArrayList<PickLine>
	 */
	public ArrayList<PickLine> generatePickLines()
	{
		ArrayList<PickLine> arr = new ArrayList<PickLine>();
		ArrayList<Integer> picking = new ArrayList<Integer>();
		boolean alreadyInArr = false;
		Statement stmt = null;
		ResultSet rs = null;
		
		System.out.println("Generating PickLines...");
		
		try {
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery("SELECT * FROM OrderLines WHERE Status='To Be Picked'");
	        
	        System.out.println("SQL query...");
	        
	        rs.first();
	        
	        if(!rs.isBeforeFirst())
	        	throw new IllegalStateException();
	        
	        System.out.println("Commencing while loop...");
	        
    		while(!rs.isAfterLast())
			{
    			System.out.println("First for loop");
    			for(int i = 0; i < arr.size(); i++)
    			{
    				System.out.println("First for loop i = " + i);
    				if(arr.get(i).getItem().getItemID() == rs.getInt(3))
    				{
    					arr.get(i).addToQuantity(rs.getInt(3));
    					alreadyInArr = true;
    					break;
    				}
    			}
    			
    			System.out.println("Checking if in picklist already");
    			if(!alreadyInArr)
    			{
    				System.out.println("Adding pickline to the picklist");
					arr.add(new PickLine(rs.getInt(3), rs.getInt(4), rs.getString(5)));
    			}
    			
    			System.out.println("Already in picklist, adding quantity");
    			picking.add(rs.getInt(1));
    			alreadyInArr = false;
				rs.next();
			}
    		for(Integer i : picking)
    		{
    			this.updateOrderLineStatusByID(i, "Picking");
    			System.out.println("Setting " + i + " to picking");
    		}
		} catch (IllegalStateException exc) {
			System.out.println("No orderlines are marked 'To Be Picked'");
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
		return arr;
		
	}
}
	