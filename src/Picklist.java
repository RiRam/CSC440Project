
import java.util.ArrayList;
/*
 * By Ryan C
 */
public class Picklist {
	
	private boolean isPicked;
	private ArrayList<PickLine> itemsToPick  = new ArrayList<PickLine>();
	
	/**
	 * In the Array list, update the status of the pick line w/ item ID = ID to be "picked"
	 * @param ID
	 */
	public void pickByID(int ID) 
	{
		System.out.println(ID);
		for (int i = 0; i < itemsToPick.size(); i++)
		{
			PickLine currentLine = itemsToPick.get(i);
			if (currentLine.getItem().getItemID() == ID) 
			{
				
				currentLine.setStatusPicked();
			}
			
			else if (itemsToPick.get(i)  == null)
			{
				System.out.println("Item is not here");
			}
		}
	}
	
	
	
	/**
	 * Pick all of the items in the picklist and set it to picked
	 */
	public void pickAll()
	{
		for (int i = 0; i < itemsToPick.size(); i++)
		{
			PickLine currentLine = itemsToPick.get(i);
			currentLine.setStatusPicked();
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

