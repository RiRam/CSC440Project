
import java.util.ArrayList;
/*
 * By Ryan C
 */
public class Picklist {
	
	private boolean isPicked;
	private ArrayList<PickLine> itemsToPick;
	private Orders o;
	
	
	public static void main(String[] args)
	{
		System.out.println("Creating Picklist object");
		Picklist p = new Picklist();
		
		System.out.println("Get PickLines");
		ArrayList<PickLine> arr = p.getPickLines();
		
		System.out.println("Initial Picklist:");
		for(int i = 0; i < arr.size(); i++)
		{
			System.out.println(arr.get(i));
		}
		
		System.out.println("Picking By ID");
		p.pickByID(1);
		
		System.out.println("Picking By ID result");
		for(int i = 0; i < arr.size(); i++)
		{
			System.out.println(arr.get(i));
		}
		
		System.out.println("Picking all");
		p.pickAll();
		
		System.out.println("Picking all result");
		for(int i = 0; i < arr.size(); i++)
		{
			System.out.println(arr.get(i));
		}
	}
	
	
	public Picklist()
	{
		isPicked = false;
		o = new Orders();
		itemsToPick = o.generatePickLines();
		o.close();
	}
	
	/**
	 * In the Array list, update the status of the pick line w/ item ID = ID to be "picked"
	 * @param ID
	 */
	public void pickByID(int ID) 
	{
		o = new Orders();
		for (int i = 0; i < itemsToPick.size(); i++)
		{
			PickLine currentLine = itemsToPick.get(i);
			if (currentLine.getItem().getItemID() == ID) 
			{
				
				currentLine.setStatusPicked();
				o.updateOrderLineStatusByItemID(ID, "Picked");
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
			o.updateOrderLineStatusByItemID(itemsToPick.get(i).getItem().getItemID(), "Picked");
		}
	}
	
	public ArrayList<PickLine> getPickLines()
	{
		return itemsToPick;
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

/*
 * Console output from test:
	Creating Picklist object
	Connected to database
	Generating PickLines...
	SQL query...
	Commencing while loop...
	First for loop
	Checking if in picklist already
	Adding pickline to the picklist
	Connected to database
	Connection close successful
	Already in picklist, adding quantity
	First for loop
	First for loop i = 0
	Checking if in picklist already
	Adding pickline to the picklist
	Connected to database
	Connection close successful
	Already in picklist, adding quantity
	First for loop
	First for loop i = 0
	First for loop i = 1
	Checking if in picklist already
	Adding pickline to the picklist
	Connected to database
	Connection close successful
	Already in picklist, adding quantity
	First for loop
	First for loop i = 0
	First for loop i = 1
	Checking if in picklist already
	Already in picklist, adding quantity
	First for loop
	First for loop i = 0
	First for loop i = 1
	First for loop i = 2
	Checking if in picklist already
	Already in picklist, adding quantity
	First for loop
	First for loop i = 0
	Checking if in picklist already
	Already in picklist, adding quantity
	First for loop
	First for loop i = 0
	First for loop i = 1
	First for loop i = 2
	Checking if in picklist already
	Adding pickline to the picklist
	Connected to database
	Connection close successful
	Already in picklist, adding quantity
	First for loop
	First for loop i = 0
	First for loop i = 1
	First for loop i = 2
	First for loop i = 3
	Checking if in picklist already
	Adding pickline to the picklist
	Connected to database
	Connection close successful
	Already in picklist, adding quantity
	First for loop
	First for loop i = 0
	Checking if in picklist already
	Already in picklist, adding quantity
	First for loop
	First for loop i = 0
	First for loop i = 1
	First for loop i = 2
	Checking if in picklist already
	Already in picklist, adding quantity
	Update Status successful
	Setting 1 to picking
	Update Status successful
	Setting 2 to picking
	Update Status successful
	Setting 3 to picking
	Update Status successful
	Setting 5 to picking
	Update Status successful
	Setting 6 to picking
	Update Status successful
	Setting 7 to picking
	Update Status successful
	Setting 9 to picking
	Update Status successful
	Setting 10 to picking
	Update Status successful
	Setting 14 to picking
	Update Status successful
	Setting 15 to picking
	Connection close successful
	Get PickLines
	Initial Picklist:
	PickLine: Item: Blue Table	Quantity: 8	Status: To Be Picked
	PickLine: Item: Lamp	Quantity: 4	Status: To Be Picked
	PickLine: Item: Red Chair	Quantity: 4	Status: To Be Picked
	PickLine: Item: TV Stand	Quantity: 260	Status: To Be Picked
	PickLine: Item: Couch	Quantity: 500	Status: To Be Picked
	Picking By ID
	Connected to database
	Update Status successful
	Picking By ID result
	PickLine: Item: Blue Table	Quantity: 8	Status: To Be Picked
	PickLine: Item: Lamp	Quantity: 4	Status: To Be Picked
	PickLine: Item: Red Chair	Quantity: 4	Status: Picked
	PickLine: Item: TV Stand	Quantity: 260	Status: To Be Picked
	PickLine: Item: Couch	Quantity: 500	Status: To Be Picked
	Picking all
	Update Status successful
	Update Status successful
	Update Status successful
	Update Status successful
	Update Status successful
	Picking all result
	PickLine: Item: Blue Table	Quantity: 8	Status: Picked
	PickLine: Item: Lamp	Quantity: 4	Status: Picked
	PickLine: Item: Red Chair	Quantity: 4	Status: Picked
	PickLine: Item: TV Stand	Quantity: 260	Status: Picked
	PickLine: Item: Couch	Quantity: 500	Status: Picked
 */

