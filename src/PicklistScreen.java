import java.util.Scanner;
import java.util.ArrayList;

public class PicklistScreen {
	static Picklist pickList = new Picklist();
	static ArrayList<PickLine> pickListArray = pickList.getPickLines();	
	public static void main (String []args) {
		run();
	}
	
	public static void run() {
	
		// Welcome the User
		int decision = 0;
		
		do {
		System.out.println("Welcome to the Picklist Screen Interface\n"
				+ "Enter a command to continue\n"
				+ "1: View Picklist\n"
				+ "2: Pick All \n"
				+ "3: Pick Item\n"
				+ "4: Exit\n");
		decision = PicklistScreen.computeDecision();
		} while (decision != 4);
		System.out.println("Thank you for using the program.");
	}
	public static int computeDecision() {
		Scanner io = new Scanner(System.in);
		int input = io.nextInt(); 
		
		if (input == 1) {
			viewPickLines();
			return 1;
		} else if (input == 2) {
			pickAllItems();
			return 2;
		} else if (input == 3) {
			pickItem();
			return 3;
		} else if (input == 4) {
			return 4;
		} else {
			System.out.println("Invalid Option.");
			return 0;
		}
	}
	public static void viewPickLines() {
		//System.out.println(pickList.toString());
		if (pickListArray.size() == 0) {
			System.out.println("\nThere are no items to be picked.\n");
		} else {
		for(int i = 0; i < pickListArray.size(); i++)
		{
			System.out.println(pickListArray.get(i).getItem().getItemName());
		}
		}
	}
	public static void pickItem () {
		Scanner inputIO = new Scanner (System.in);
		Scanner io = new Scanner (System.in);
		System.out.println("Please enter the ID of the item you would like to pick: ");
		int itemID = inputIO.nextInt();
		
		System.out.println("Are you sure you would like to pick this item? (Y/N)");
		String decision = io.nextLine();
		if (decision.equalsIgnoreCase("Y")) {
			pickList.pickByID(itemID);
			System.out.println("Item has been picked.");
		}
	}
	public static void pickAllItems() {
		Scanner io = new Scanner(System.in);
		System.out.println("Are you sure you would like to pick all items? (Y/N)");
		String decision = io.nextLine();
		if (decision.equalsIgnoreCase("Y")) {
			System.out.println("Picking items.");
			pickList.pickAll();
		}
	}
}