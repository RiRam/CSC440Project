import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.ArrayList;


/**
 * Inventory class
 * 
 * @author Erica Ram
 */

public class Inventory {
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
	private static Connection conn = null;
	
	/*
	public static void main(String[] args) 
	{
		Inventory inv = new Inventory();
		inv.addItem(6, "Orange desk", "An orange desk.", 1, 2, "F");
		inv.updateNameByID(6, "Orange computer desk");
		inv.updateDescriptionByID(6, "An orange computer desk.");
		inv.updateAvailableByID(6, 11);
		inv.updatePickedByID(6, 4);
		inv.updateLocationByID(6, "Z");
		inv.deleteItem(6);
		System.out.println("Item #1: " + inv.getNameByID(1) + "\nDescription: " + inv.getDescriptionByID(1) + "\nAvailable: " 
				+ inv.getAvailableByID(1) + "\nPicked: " + inv.getPickedByID(1) + "\nLocation: " + inv.getLocationByID(1));;
		inv.close();
	}
	*/
	
	/**
	 * Inventory Constructor
	 */
	public Inventory()
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
	 * Add an Item to the Inventory table
	 * 
	 * @param ID - Item ID
	 * @param name - Item Name
	 * @param description - Item Description
	 * @param available - Available Count of Item
	 * @param picked - Picked Count of Item
	 * @param loc - Item Location
	 */
	public void addItem(int ID, String name, String description, int available, int picked, String loc)
	{
		// Insert the table
		try {
		    String insertString = "INSERT INTO Inventory(ItemID, ItemName, ItemDescription, AvailableCount, PickedCount, Location) VALUES (" 
		+ ID + ", '" + name + "', '" + description + "', " + available + ", " + picked + ", '" + loc + "');";
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
	 * Delete an Item from the Inventory table by a given ID number
	 * 
	 * @param ID - Item ID
	 */
	public void deleteItem(int ID)
	{
		try {
		    String deleteString = "DELETE FROM Inventory WHERE ItemID=" + ID + ";";
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
	 * Update the name of an Item by a given ID number
	 * 
	 * @param ID - Item ID
	 * @param newName - new name to assign to Item
	 */
	public void updateNameByID(int ID, String newName)
	{
		try {
		    String newNameString = "UPDATE Inventory SET ItemName='" + newName + "' WHERE ItemID=" + ID + ";";
		    System.out.println(newNameString);
			this.executeUpdate(conn, newNameString);
			System.out.println("Update name successful");
	    } catch (SQLException e) {
			System.out.println("[ERROR: Could not update name.]");
			e.printStackTrace();
			return;
		}
	}
	
	/**
	 * Update the description of an Item by a given ID number
	 * 
	 * @param ID - Item ID
	 * @param newDescription - new description to assign to Item
	 */
	public void updateDescriptionByID(int ID, String newDescription)
	{
		try {
		    String newDescriptionString = "UPDATE Inventory SET ItemDescription='" + newDescription + "' WHERE ItemID=" + ID + ";";
		    System.out.println(newDescriptionString);
			this.executeUpdate(conn, newDescriptionString);
			System.out.println("Update description successful");
	    } catch (SQLException e) {
			System.out.println("[ERROR: Could not update description.]");
			e.printStackTrace();
			return;
		}
	}
	
	/**
	 * Update the available count of an Item by a given ID number
	 * 
	 * @param ID - Item ID
	 * @param newAvailable - new available count to assign to Item
	 */
	public void updateAvailableByID(int ID, int newAvailable)
	{
		try {
		    String newAvailableString = "UPDATE Inventory SET AvailableCount=" + newAvailable + " WHERE ItemID=" + ID + ";";
		    System.out.println(newAvailableString);
			this.executeUpdate(conn, newAvailableString);
			System.out.println("Update available successful");
	    } catch (SQLException e) {
			System.out.println("[ERROR: Could not update available.]");
			e.printStackTrace();
			return;
		}
	}
	
	/**
	 * Update the picked count of an Item by a given ID number
	 * 
	 * @param ID - Item ID
	 * @param newPicked - new picked count to assign to Item
	 */
	public void updatePickedByID(int ID, int newPicked)
	{
		try {
		    String newPickedString = "UPDATE Inventory SET PickedCount=" + newPicked + " WHERE ItemID=" + ID + ";";
		    System.out.println(newPickedString);
			this.executeUpdate(conn, newPickedString);
			System.out.println("Update picked successful");
	    } catch (SQLException e) {
			System.out.println("[ERROR: Could not update picked.]");
			e.printStackTrace();
			return;
		}
	}
	
	/**
	 * Update the location of an Item by a given ID number
	 * 
	 * @param ID - Item ID
	 * @param newLoc - new location to assign to Item
	 */
	public void updateLocationByID(int ID, String newLoc)
	{
		try {
		    String newLocString = "UPDATE Inventory SET Location='" + newLoc + "' WHERE ItemID=" + ID + ";";
		    System.out.println(newLocString);
			this.executeUpdate(conn, newLocString);
			System.out.println("Update picked successful");
	    } catch (SQLException e) {
			System.out.println("[ERROR: Could not update picked.]");
			e.printStackTrace();
			return;
		}
	}
	
	
	
	/**
	 * Return the name of an Item by a given ID number
	 * 
	 * @param ID - Item ID
	 * @return String - Item Name
	 */
	public String getNameByID(int ID)
	{
		String name = "";
		Statement stmt = null;
		ResultSet rs = null;
		try {
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery("SELECT ItemID, ItemName FROM Inventory");
			
			rs.first();
			while(!rs.isAfterLast())
			{
				if(rs.getInt(1) == ID)
					name = rs.getString(2);
			
				rs.next();
			}
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		if(name.equals(""))
			return "[ERROR: Name not found.]";
		else
			return name;
	}
	
	/**
	 * Return the description of an Item by a given ID number
	 * 
	 * @param ID - Item ID
	 * @return String - Item Description
	 */
	public String getDescriptionByID(int ID)
	{
		String description = "";
		Statement stmt = null;
		ResultSet rs = null;
		try {
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery("SELECT ItemID, ItemDescription FROM Inventory");
			
			rs.first();
			while(!rs.isAfterLast())
			{
				if(rs.getInt(1) == ID)
					description = rs.getString(2);
			
				rs.next();
			}
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		if(description.equals(""))
			return "[ERROR: Description not found.]";
		else
			return description;
	}
	
	/**
	 * Return the available count of an Item by a given ID number
	 * 
	 * @param ID - Item ID
	 * @return int - Available Count
	 */
	public int getAvailableByID(int ID)
	{
		int available = -1;
		Statement stmt = null;
		ResultSet rs = null;
		try {
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery("SELECT ItemID, AvailableCount FROM Inventory");
	        
			rs.first();
			while(!rs.isAfterLast())
			{
				if(rs.getInt(1) == ID)
					available = rs.getInt(2);
			
				rs.next();
			}
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		return available;
	}
	
	/**
	 * Return the picked count of an Item by a given ID number
	 * 
	 * @param ID - Item ID
	 * @return int - Picked Count
	 */
	public int getPickedByID(int ID)
	{
		int picked = -1;
		Statement stmt = null;
		ResultSet rs = null;
		try {
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery("SELECT ItemID, PickedCount FROM Inventory");
	        
			rs.first();
			while(!rs.isAfterLast())
			{
				if(rs.getInt(1) == ID)
					picked = rs.getInt(2);
			
				rs.next();
			}
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		return picked;
	}
	
	/**
	 * Return the location of an Item by a given ID number
	 * 
	 * @param ID - Item ID
	 * @return String - Location
	 */
	public String getLocationByID(int ID)
	{
		String loc = "";
		Statement stmt = null;
		ResultSet rs = null;
		try {
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery("SELECT ItemID, Location FROM Inventory");
			
			rs.first();
			while(!rs.isAfterLast())
			{
				if(rs.getInt(1) == ID)
					loc = rs.getString(2);
			
				rs.next();
			}
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		if(loc.equals(""))
			return "[ERROR: Location not found.]";
		else
			return loc;
	}
	
	/**
	 * Closes the database connection
	 */
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
	 * Gets Item from the database by a given ID number
	 * @param ID - Item ID
	 * @return Item - Item
	 */
	public Item getItem(int ID)
	{
		Item newItem = new Item();
		Statement stmt = null;
		ResultSet rs = null;
		try {
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery("SELECT * FROM Inventory WHERE ItemID=" + ID);
		rs.first();	
	        newItem = new Item(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6));
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		return newItem;
		
		//return new Item(ID, getNameByID(ID), getDescriptionByID(ID), getAvailableByID(ID), getPickedByID(ID), getLocationByID(ID));
	}
	
	/**
	 * Return all items present in the table
	 * 
	 * @return ArrayList<Item>
	 */
	public ArrayList<Item> getAllItems()
	{
		ArrayList<Item> all = new ArrayList<Item>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery("SELECT * FROM Inventory");
			
			rs.first();
			while(!rs.isAfterLast())
			{
				all.add(new Item(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6)));
			
				rs.next();
			}
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
			return all;
	}
	
	
	/**
	 * Returns the next Item ID
	 * 
	 * @return int - next Item ID (i.e. if the current highest Item ID is 3, returns 4)
	 */
	public int getNextItemID()
	{
		int next = -1;
		Statement stmt = null;
		ResultSet rs = null;
		try {
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery("SELECT MAX(ItemID) FROM Inventory");
	        rs.first();
	        next = rs.getInt(1);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		
		return next + 1;
	}
	
	
}
	
