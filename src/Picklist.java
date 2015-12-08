
import java.util.ArrayList;
/*
 * By Ryan C
 */
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
		for (int i = 0; i < itemsToPick.size(); i++)
		{
			if (i == ID) {
				Item currentItem = itemsToPick.get(i);
				currentItem.setStatus();
				//break; ?
				
		}
			else if (itemsToPick.get(i)  == null) {
				System.out.println("Item is not here");
			}
		}
	}
	
	
	
	/**
	 * 1. update all status of "picking" to "picked"
	 * 2. update all order lines w/ status "picking" to "picked"
	 */
	public void pickAll()
	{
		for (int i = 0; i < itemsToPick.size(); i++)
		{
	
		
			Item currentItem = itemsToPick.get(i);
			
			//call the pickline's method status "setStatusPicked" so that i
			//i is now picked
			
			currentItem.setStatusToPicked();
		}
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

