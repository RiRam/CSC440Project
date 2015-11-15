/**
 * Item class
 * 
 * @author Ryan Cangelosi & Erica Ram
 */

public class Item 
{
	private int ID;
	
	private int availableCount;
	
	private String description;
	
	private String name;
	
	private int pickedCount;
	
	private String location;
	
	/**
	 * Item Constructor
	 * 
	 * @param newID
	 * @param newAvailableCount
	 * @param newDescription
	 * @param newName
	 * @param newPickedCount
	 * @param newLocation
	 */
	public Item (int newID, String newName, String newDescription, int newAvailableCount, int newPickedCount, String newLocation)
	{
		ID = newID;
		availableCount = newAvailableCount;
		description = newDescription;
		name = newName;
		pickedCount = newPickedCount;
		location = newLocation;
	}
	
	/**
	 * Empty Item Constructor
	 */
	public Item()
	{
		ID = -1;
		availableCount = -1;
		description = "N/A";
		name = "N/A";
		pickedCount = -1;
		location = "N/A";
	}
	
	/**
	 * Get Item ID
	 * 
	 * @return int - Item ID
	 */
	public int getItemID()
	{	return ID;	}
	
	/**
	 * Get Available Count
	 * 
	 * @return int - Available Count
	 */
	public int getAvailableCount()
	{	return availableCount;	}
	
	/**
	 * Get Description
	 * 
	 * @return String - Item Description
	 */
	public String getDescription()
	{	return description;	}
	
	/**
	 * Get Item Name
	 * 
	 * @return String - Item Name
	 */
	public String getItemName()
	{	return name;	}
	
	/**
	 * Get Picked Count
	 * 
	 * @return int - Picked Count
	 */
	public int getPickedCount()
	{	return pickedCount;	}
	
	/**
	 * Get Location
	 * 
	 * @return String - location
	 */
	public String getLocation()
	{	return location;	}
	
	/**
	 * Set Item Name
	 * 
	 * @param newName - new name for the Item
	 */
	 public void setNewName(String newName)
	 {
		 this.newName = newName;
	 }
	
	
	/**
	 * Set Item Description
	 * 
	 * @param newDescription - new description for the Item
	 */
	  public void setNewDescription( String newDescription)
	 {
		 this.newDescription = newDescription;
	 }
	
	
	/**
	 * Set Available Count
	 * 
	 * @param newAvailable - new available count for the Item
	 */
	 public void setNewAvailable( String newAvailable)
	 {
		 this.newAvailable = newAvailable;
	 }
	
	
	/**
	 * Set Picked Count
	 * 
	 * @param newPicked - new picked count for the Item
	 */
	  public void setNewPicked( String newPicked)
	 {
		 this.newPicked = newPicked;
	 }
	
	
	/**
	 * Set Location
	 * 
	 * @param newLoc - new location for the Item
	 */
	  public void setNewLoc( String newLoc)
	 {
		 this.newLoc = newLoc;
	 }
	
	
}