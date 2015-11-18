import java.util.ArrayList;
import java.util.Scanner;
/**
 * InventoryScreen class
 * 
 * @author Donald Hanson II
 */
//extends Applet
public class InventoryScreen {
	Inventory inv = new Inventory();
	String output = "";

	public static void main(String[] args) 
	{
		InventoryScreen InSc = new InventoryScreen();
		System.out.println("");
		run(InSc);
	}

	public static void run(InventoryScreen IvScreen) {
		Scanner scan = new Scanner(System.in);
		int input = 0;
		System.out.println("Welcome to the Inventory Screen Interface. ");
		do {
		System.out.println("Enter a command to continue:\n"
			+ " 1: View Inventory Items\n"
			+ " 2: View Item\n"
			+ " 3: Edit Item\n"
			+ " 4: Exit\n");
		input = scan.nextInt();
		
		if (input == 1) {
			IvScreen.displayItemList();
		} else if (input == 2) {
			int inputItem;
			System.out.println("Enter the ID of the item you would like to view: ");
			inputItem = scan.nextInt();
			IvScreen.displayitem(inputItem);
		} else if (input == 3)
			IvScreen.displayEditItem();
		} while (input != 4);
		System.out.println("Thank you for using the program.");
	}
	
	public void createItem(String itemInfo) {
		// Parse information
		// Send to itemInfoClass
		// Call displayItemList to display the new page
		displayItemList();
	}
	
	public void displayEditItem() {
///		Inventory inv = new Inventory();
		Scanner scan = new Scanner (System.in);
		System.out.println("Enter the ID of the item you would like to edit: ");
		int inputItem = scan.nextInt();
		ArrayList<Item> itemList = new ArrayList<Item>();
		itemList = inv.getAllItems();
		Item currentItem = itemList.get(inputItem - 1);
		int currentItemID = currentItem.getItemID();
		System.out.println("Name: " + currentItem.getItemName() + "\nDescription: " + currentItem.getDescription() + "\nItems Available: " + currentItem.getAvailableCount() + "\nLocation: " + currentItem.getLocation() + "\nItems Picked: " + currentItem.getPickedCount());
		System.out.println("Are you sure you would like to make changes to this item? (Y/N)");
		Scanner de = new Scanner (System.in);
		String decision = de.nextLine();
		
		if (decision.equals("Y")) {
			Scanner io = new Scanner (System.in);
			Scanner io_val = new Scanner (System.in);
			System.out.println("Enter all fields in the order they appear, separated by a new line (Enter). To exclude an "
					+ "item from being edited, place a dash (-) in place of a the new text.");
			System.out.println("New Name: ");
			String newName = io.nextLine();
			
			System.out.println("New Description: ");
			String newDescription = io.nextLine();
			
			System.out.println("New Availability: ");
			int newAvail = io.nextInt();
			
			System.out.println("New Location: ");
			String newLocation = io_val.nextLine();
			
			System.out.println("Amount picked: ");
			int newPicked = io_val.nextInt();
			
			//Update information 
			inv.updateNameByID(currentItemID, newName);
			inv.updateDescriptionByID(currentItemID, newDescription);
			inv.updateAvailableByID(currentItemID, newAvail);
			inv.updateLocationByID(currentItemID, newLocation);
			inv.updatePickedByID(currentItemID, newPicked);
		} else {
			System.out.println("No changes will be made.\n");
		}
	}
	/*
	 * Displays a list of item objects
	 */
	public void displayItemList() {
		ArrayList<Item> itemList = new ArrayList<Item>();
		itemList = inv.getAllItems();
		for (Item i : itemList) {
			System.out.println("ID: " + i.getItemID() + " Name: " + i.getItemName() + " Description: " + i.getDescription() + "\n" );
		}

	}
	public void displayitem(int itemIDString) {
		int itemID = itemIDString;//Integer.parseInt(itemIDString);
		ArrayList<Item> itemList = new ArrayList<Item>();
		itemList = inv.getAllItems();
		Item thisItem = itemList.get(itemID - 1);
		System.out.println("ID: " + thisItem.getItemID() + "\nName: " + thisItem.getItemName() + "\nDescription: " + thisItem.getDescription() + "\nItems Available: " + thisItem.getAvailableCount() + "\nLocation: " + thisItem.getLocation() + "\nItems Picked: " + thisItem.getPickedCount());
	}
}
