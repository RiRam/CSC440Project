import java.util.Scanner;

public class UserStores extends User {
	/*
	 * Local constructor: For Local tasks 
	 */
	public UserStores(String newPassword, String newUsername, int userType) {
		super(newPassword, newUsername, userType);
		// TODO Auto-generated constructor stub
	}
	/*
	 * Database constructor: For adding users to DB
	 */
	public UserStores(String newPassword, int newID, String newUsername, int userType) {
		super(newPassword, newID, newUsername,userType);
	}

	void displayInventoryMenu () {
		Scanner scan = new Scanner(System.in);
		int input = 0;
		System.out.println("Welcome to the Inventory Screen Interface. ");
		do {
			
			System.out.println("Enter a command to continue:\n"
					+ " 1: View Inventory Items\n"
					+ " 2: View Item\n"
					+ " 3: Exit\n");
			input = scan.nextInt();
		
			if (input == 1) {
				InventoryScreen.displayItemList();
			} else if (input == 2) {
				InventoryScreen.displayitem();
			} 
		} while (input != 3);
		System.out.println("Thank you for using the program.");
	}
	
	void displayOrdersMenu() {
		Scanner keyb = new Scanner(System.in);
		int input; // answer to menu question
		
		System.out.println("Welcome to the Order Screen Interface. ");
		
		do { //loop to print menu till user is done
			System.out.println("Enter a command to continue:\n"
				+ " 1: Enter a New Order\n"
				+ " 2: Look Up an Existing Order\n"
				+ " 3: Edit an Existing Order\n"
				+ " 4: Exit\n");
			input = keyb.nextInt(); //answer to menu question
			
			if (input == 1) {
				OrdersScreen.addOrder(); //method to add order
			} 
			
			else if (input == 2) {
				OrdersScreen.searchOrder(); //method to search order
			}
			else if (input ==3) {
				OrdersScreen.editOrder(); //edit existing orders
			}
			} while (input != 4); //exit if done
			System.out.println("Thank you for using the program.");
	}
	void displayPickListMenu() {
		System.out.println("\nYou do not have permission to access these features. Please contact your administrator for access.\n");
	}
	void displaySystemSettings() {
		System.out.println("\nYou do not have permission to access these features. Please contact your administrator for access.\n");
	}
}
