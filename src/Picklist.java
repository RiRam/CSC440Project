
import java.util.ArrayList;

public class Picklist {
	
	private boolean isPicked;
	private ArrayList<Item> itemsToPick = new ArrayList<Item>();
	
	/**
	 * In the arraylist, update the status of the pickline w/ item ID = ID to be "picked"
	 * @param ID
	 */
	public void pickByID(int ID) 
	{
		System.out.println(ID);
		// Find item in array by ID (Which was passed by parameters)
		//while (we haven't reached the end of the array)
		//for (int i = 0; i < itemsToPick.size(); i++)
		//{
		//	if (if the current item ID == ID) {
		//		Item currentItem = itemsToPick[i];
		//		int itemIndex = i;
		//		break;
		//	}
		//}
		
		//if (itemsToPick[i].getName != "") {
		//	itemsToPick[i].setStatus("picked");
		//}
		// After we find the item, then we want to set the item's picked status to picked 
		
		//itemsToPick.setStatus(ID);
	
	}
	
	/**
	 * 1. update all status of "picking" to "picked"
	 * 2. update all order lines w/ status "picking" to "picked"
	 */
	public void pickAll()
	{
		
	}
	
	
	public Picklist(boolean picked)
	{
		isPicked = picked;
	}
	
	public boolean getStatus()
	{
		return isPicked;
	}
	
	public void setStatus(boolean picked)
	{
		isPicked = picked;
	
	}
}

