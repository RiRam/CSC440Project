import java.util.Scanner;

public class UserWorkers extends User{
	public UserWorkers(String newPassword, String newUsername, int userType) {
		super(newPassword, newUsername, userType);
	}

	void displayInventoryMenu() {
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
				InventoryScreen.displayItemList();
			} else if (input == 2) {
				InventoryScreen.displayitem();
			} else if (input == 3) {
				InventoryScreen.displayEditItem();
			} 
		} while (input != 4);
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
				+ " 4: Delete an Order\n"
				+ " 5: Exit\n");
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
			else if (input == 4) {
				OrdersScreen.deleteOrder(); //delete an order
			}
			} while (input != 5); //exit if done
			System.out.println("Thank you for using the program.");
	}
	
	void displaySystemSettings() {
		System.out.println("\nYou do not have permission to access these features. Please contact your administrator for access.\n");
	}
}
