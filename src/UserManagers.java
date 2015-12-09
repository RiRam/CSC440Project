import java.util.Scanner;

public class UserManagers extends User {
	private Users Usr = new Users();
	public UserManagers(String newPassword, String newUsername, int userType) {
		super(newPassword, newUsername, userType);
		// TODO Auto-generated constructor stub
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

	void displayInventoryMenu() {
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
				InventoryScreen.displayItemList();
			} else if (input == 2) {
				InventoryScreen.displayitem();
			} else if (input == 3) {
				InventoryScreen.displayEditItem();
			} else if (input == 4) 
				InventoryScreen.addItem();
		} while (input != 5);
		System.out.println("Thank you for using the program.");
	}
	
	void displayPickListMenu() {
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
	
	void displaySystemSettings() {
		
		Scanner scan = new Scanner(System.in);
		int input = 0;
		System.out.println("System Settings. ");
		do {
			System.out.println("Enter a command to continue:\n"
					+ " 1: View Users\n"
					+ " 2: Edit User Permissions\n"
					+ " 3: Exit\n");
			input = scan.nextInt();
		
			if (input == 1) {
				UserInfo();
			} else if (input == 2) {
				updatePermissions();
			} else if (input == 3) {
				System.out.println("Exiting settings.");
			} else  
				System.out.println("Invalid option.");
		} while (input != 3);
		
	}
	public void UserInfo() {
		System.out.println(Usr.getUserInfo());
	}
	public void updatePermissions() {

		Scanner io = new Scanner(System.in);
		Scanner decisionIO = new Scanner(System.in);
		System.out.println("Enter the ID of the user you would like to change.");
		int userID = io.nextInt();
		int userPermissions = Usr.getUserTypeByID(userID);
		String userName = Usr.getUsernameByID(userID);
		System.out.println ("The user: " + userName + " currently has permissions of type: " + userPermissions + "\n"
				+ "Are you sure you would like to change the user's permissions? (Y/N)");
		String decision = decisionIO.nextLine();
		if (decision.equalsIgnoreCase("Y")) {
			updatePermissionValue (userID);
		} else {
			System.out.println("Returning to menu.");
		}
	}
	public void updatePermissionValue (int userID) {
		Scanner io = new Scanner(System.in);
		int newType = 0;
		do {
			
			System.out.println("Please enter the user's new permissions value: (1,2,3)");
			newType = io.nextInt();
			if (newType >= 1 && newType <= 3) {
				System.out.println("Setting new permissions...");
				Usr.updateUserType(userID, newType);
			} else {
				System.out.println("Invalid permission. Please enter a valid permission.");
			}
		} while (newType < 1 && newType > 3);
	}
}
