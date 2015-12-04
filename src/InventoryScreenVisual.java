import java.applet.Applet;
import java.util.ArrayList;
import java.util.Scanner;

//  InventoryScreen class
//  
//  @author Donald Hanson II
// 

public class InventoryScreenVisual extends Applet{
	Inventory inv = new Inventory();
	String output = "";

	public static void main(String[] args) 
	{
		InventoryScreen InSc = new InventoryScreen();
		System.out.println();
		run(InSc);
		System.out.println(setOutput);
		if (setOutput instanceof String) {
			System.out.println(Yes.);
		}
	}
	
	//  Creates a new item based on a string given by the 
	//  create item method in the class
	 
	public static void run(InventoryScreen IvScreen) {
		Scanner scan = new Scanner(System.in);
		int input = 0;
		System.out.println(Welcome to the Inventory Screen Interface. );
		do {
		System.out.println(Enter a command to continuen
			+  1 View Inventory Itemsn
			+  2 View Itemn
			+  3 Edit Itemn
			+  4 Exitn);
		input = scan.nextInt();
		
		if (input == 1) {
			IvScreen.displayItemList();
		} else if (input == 2) {
			int inputItem;
			System.out.println(Enter the ID of the item you would like to view );
			inputItem = scan.nextInt();
			IvScreen.displayitem(inputItem);
		} else if (input == 3)
			IvScreen.displayEditItem();
		} while (input != 4);
		System.out.println(Thank you for using the program.);
	}
	
	public void createItem(String itemInfo) {
//		 Parse information
//		 Send to itemInfoClass
//		 Call displayItemList to display the new page
//		displayItemList();
	}
	
	public void updateItem(String itemIDString, String infoEdit) {
		
		
		String desc, name, loc;
		int avail, picked;
		
		int itemID = Integer.parseInt(itemIDString);
		Item currentItem = Inventory.getItem(itemID);
		
		String[] infoLines = infoEdit.split(System.getProperty(line.separator));
		name = infoLines[0];
		desc = infoLines[1];
		loc = infoLines[2];
		avail = Integer.parseInt(infoLines[3]);
		picked = Integer.parseInt(infoLines[4]);
		
		
		inv.updateNameByID(itemID, name);
		inv.updateDescriptionByID(itemID, desc);
		inv.updateLocationByID(itemID, loc);
		inv.updateAvailableByID(itemID, avail);
		inv.updatePickedByID(itemID, picked);
		 Parse Information
		 Send to the Item class to edit
		displayItemList();
	}
	
	public void displayEditItem() {
		Inventory inv = new Inventory();
		Scanner scan = new Scanner (System.in);
		System.out.println(Enter the ID of the item you would like to edit );
		int inputItem = scan.nextInt();
		ArrayListItem itemList = new ArrayListItem();
		itemList = inv.getAllItems();
		Item currentItem = itemList.get(inputItem - 1);
		int currentItemID = currentItem.getItemID();
		System.out.println(Name  + currentItem.getItemName() + nDescription  + currentItem.getDescription() + nItems Available  + currentItem.getAvailableCount() + nLocation  + currentItem.getLocation() + nItems Picked  + currentItem.getPickedCount());
		System.out.println(Are you sure you would like to make changes to this item (YN));
		Scanner de = new Scanner (System.in);
		String decision = de.nextLine();
		
		if (decision.equals(Y)) {
			Scanner io = new Scanner (System.in);
			Scanner io_val = new Scanner (System.in);
			System.out.println(Enter all fields in the order they appear, separated by a new line (Enter). To exclude an 
					+ item from being edited, place a dash (-) in place of a the new text.);
			System.out.println(New Name );
			String newName = io.nextLine();
			
			System.out.println(New Description );
			String newDescription = io.nextLine();
			
			System.out.println(New Availability );
			int newAvail = io.nextInt();
			
			System.out.println(New Location );
			String newLocation = io_val.nextLine();
			
			System.out.println(Amount picked );
			int newPicked = io_val.nextInt();
			
			Update information 
			inv.updateNameByID(currentItemID, newName);
			inv.updateDescriptionByID(currentItemID, newDescription);
			inv.updateAvailableByID(currentItemID, newAvail);
			inv.updateLocationByID(currentItemID, newLocation);
			inv.updatePickedByID(currentItemID, newPicked);
		} else {
			System.out.println(No changes will be made.n);
		}
		System.out.println(ID  + currentItem.getItemID() + nName  + currentItem.getItemName() + nDescription  + currentItem.getDescription() + nItems Available  + currentItem.getAvailableCount() + nLocation  + currentItem.getLocation() + nItems Picked  + currentItem.getPickedCount());

		
		
		
		output = "<div id='popup' class='item_popup' +
			<h1> class="close_button" onClick="removeItem()</h1> +
         	"<h1>" + inv.getNameByID(itemID) + "</h1>" +
         	"<h5>Enter information in the following order, seperated by line Name, Description, Location, Availability, Picked location </h5>" +
        	textarea rows="4" cols="50" id='value'textarea + 
        	input type=button value=submit onclick=updateItem()  +
        	div;

	
				+ p Available  + Item.getAvailableByID(itemID) + p
				+ p Picked  + Item.getPickedByID(itemID) + p
				+ p Location   + Item.getLocationByID(itemID) + p			
				+ div;
		
		return output;
	}
	
	  Displays a list of item objects
	 
	public void displayItemList() {
		 Import items from itemList class
		String[] itemList = {Red Chair,Black Stool,Coffee Table};
		ArrayListItem itemList = inv.getAllItems();
		ArrayListItem itemList = new ArrayListItem();
		itemList = inv.getAllItems();
		for (Item i  itemList) {
			System.out.println(ID  + i.getItemID() +  Name  + i.getItemName() +  Description  + i.getDescription() + n );
		}
		int count = 0;
		for (String i  itemList)
			output += li class=item id= + count +  onClick=viewItem(this.id)h1 + i + h1li;
			count++;
		
		for (Item i  itemList) {
			output += li class=item id= + count +  onClick=viewItem(this.id)h1 + 2 + h1li;
		}
		return output;
	}
	
	public String displayitem(int itemIDString) {
		 String itemIDString
		Inventory inv = new Inventory();
		Get item based on ID
		int itemID = itemIDString;Integer.parseInt(itemIDString);
		System.out.println(itemID);
		Item currentItem = inv.getItem(itemID);
		String itemInfo = Item;
		
		output = div id=popup class=item_popup  +
				 h1 class=close_button onClick=removeItem()xh1 
				+h1 + inv.getNameByID(itemID) + h1 
				+h2 + inv.getDescriptionByID(itemID) + h2
				+button type=button onClick=viewEditItem()Edit Itembutton;
	
				+ p Available  + Item.getAvailableByID(itemID) + p
				+ p Picked  + Item.getPickedByID(itemID) + p
				+ p Location   + Item.getLocationByID(itemID) + p			
				+ div;
		
		return output;
	}

	public void displayitem(int itemIDString) {
		int itemID = itemIDString;Integer.parseInt(itemIDString);
		System.out.println(itemID);
		Item thisItem = inv.getItem(itemID);
		ArrayListItem itemList = new ArrayListItem();
		itemList = inv.getAllItems();
		Item thisItem = itemList.get(itemID - 1);
		System.out.println(ID  + thisItem.getItemID() + nName  + thisItem.getItemName() + nDescription  + thisItem.getDescription() + nItems Available  + thisItem.getAvailableCount() + nLocation  + thisItem.getLocation() + nItems Picked  + thisItem.getPickedCount());
	}
}
