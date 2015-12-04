//import java.applet.Applet;
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

	/*
	 * Main Method to run the project
	 */
	public static void main(String[] args) 
	{
		
		InventoryScreen InSc = new InventoryScreen();
		//		System.out.println("");
//		InSc.test();
		run(InSc);
		
	}
	public void test() {
		inv.addItem(6, "Bench", "Green Bench", 20, 0, "B");
	}
	/*
	 * Runs the display for the inventory interface
	 * @param IvScreen - Takes in an InventoryScreen Object
	 */
	public static void run(InventoryScreen IvScreen) {
		
		Scanner scan = new Scanner(System.in);
		int input = 0;
		System.out.println("Welcome to the Inventory Screen Interface. ");
		do {
			
			System.out.println("Enter a command to continue:\n"
					+ " 1: View Inventory Items\n"
					+ " 2: View Item\n"
					+ " 3: Edit Item\n"
					+ " 4: Add Item\n"
					+ " 5: Exit\n");
			input = scan.nextInt();
		
			if (input == 1) {
				IvScreen.displayItemList();
			} else if (input == 2) {
				IvScreen.displayitem();
			} else if (input == 3) {
				IvScreen.displayEditItem();
			} else if (input == 4) 
				IvScreen.addItem();
		} while (input != 5);
		System.out.println("Thank you for using the program.");
	}
	/*
	 * Create an item
	 * @param itemInfo - item description
	 */
//	public void createItem(String itemInfo) {
//		// Parse information
//		// Send to itemInfoClass
//		// Call displayItemList to display the new page
//		displayItemList();
//	}
	/*
	 * Allows user to edit an item
	 */
	public void displayEditItem() {
		Scanner scan = new Scanner (System.in);
		System.out.println("Enter the ID of the item you would like to edit: ");
		int inputItem = scan.nextInt();
		
		Item currentItem = inv.getItem(inputItem);//itemList.get(inputItem - 1);
		int currentItemID = currentItem.getItemID();
		System.out.println("Name: " + currentItem.getItemName() + "\nDescription: " + currentItem.getDescription() + "\nItems Available: " + currentItem.getAvailableCount() + "\nLocation: " + currentItem.getLocation() + "\nItems Picked: " + currentItem.getPickedCount());
		System.out.println("Are you sure you would like to make changes to this item? (Y/N)");
		Scanner de = new Scanner (System.in);
		String decision = de.nextLine();
		
		if (decision.equalsIgnoreCase("Y") || decision.equalsIgnoreCase("Yes")) {
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

			System.out.println("Amount picked: ");
			int newPicked = io_val.nextInt();
			
			System.out.println("New Location: ");
			String newLocation = io_val.nextLine();
			
			
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
	 * Displays a list of item objects to the screen
	 */
	public void displayItemList() {
		ArrayList<Item> itemList = new ArrayList<Item>();
		itemList = inv.getAllItems();
		for (Item i : itemList) {
			System.out.println("ID: " + i.getItemID() + " Name: " + i.getItemName() + " Description: " + i.getDescription() + "\n" );
		}
	}
	/*
	 * Displays information for a single item
	 * @param itemIDString - Item ID as a String
	 */
	public void displayitem() { 
		Scanner scan = new Scanner (System.in);
		int inputItem;
		System.out.println("Enter the ID of the item you would like to view: ");
		inputItem = scan.nextInt();
		Item thisItem = inv.getItem(inputItem);
		System.out.println(thisItem);
		
		if (thisItem.getItemID() == -1) {
			System.out.println("\nInvalid ID number entered.\n");
		} else {
			System.out.println("ID: " + thisItem.getItemID() + "\nName: " + thisItem.getItemName() + "\nDescription: " + thisItem.getDescription() + "\nItems Available: " + thisItem.getAvailableCount() + "\nLocation: " + thisItem.getLocation() + "\nItems Picked: " + thisItem.getPickedCount());
		}
	}
	/**
	 * Adds a new item to the system 
	 * @param None
	 */
	public void addItem() { 
		// String name, String description, int available, int picked, String loc
		Scanner scan = new Scanner (System.in);
		System.out.println("You are about to add a new item. Are you sure that you would like to continue? (Yes/No)");
		String userInput = scan.nextLine();
		if (userInput.equalsIgnoreCase("Y") || userInput.equalsIgnoreCase("Yes")) {
			Scanner input = new Scanner (System.in);
			
			System.out.println("Enter Name: ");
			String newName = input.nextLine();
			
			System.out.println("Enter Description: ");
			String newDescription = input.nextLine();
			
			System.out.println("Enter Availability: ");
			int newAvail = input.nextInt();
			
			int newID = inv.getNextItemID();
			inv.addItem(newID, newName, newDescription, newAvail, 0, "A");
			if (inv.getNameByID(newID) != "") {
				System.out.println("Item created sucessfully.");
			}
		} else {
			System.out.println("Returning to the main menu\n");
		}
	}
}
