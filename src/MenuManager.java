import java.util.Scanner;

public class MenuManager {
	public static void main (String[] args) {
//		Order newOrder = new Order();
//		Orders orderDB = new Orders();
//		newOrder = orderDB.getOrder(7);
		
		//run();
	}
	
	public static void run(User currentUser) {
		//InventoryScreen invInstance = new InventoryScreen();
		OrdersScreen ordInstance = new OrdersScreen();
		//InventoryScreen.run(instance);
		int decision = 0;
		do {
		System.out.println("Welcome to the Software IKEA program! Please select an option.\n"
				+ "1: Inventory Menu\n"
				+ "2: Orders Menu\n"
				+ "3: Picklist\n"
				+ "4: System Settings\n"
				+ "5: Log out");
		Scanner Menuio = new Scanner (System.in);
		decision = Menuio.nextInt();
		if (decision == 1) {
			currentUser.displayInventoryMenu();
			//InventoryScreen.run();
		} else if (decision == 2) {
			currentUser.displayOrdersMenu();// OrdersScreen.run();
		} else if (decision == 3) {
			currentUser.displayPickListMenu();
			//System.out.println("Feature not yet implemented.\n");
		} else if (decision == 4) {
			currentUser.displaySystemSettings();
		} else if (decision == 5) {
			System.out.println("Logging out.");
		} else {
			System.out.println("Invalid option.");
		}
		
		} while (decision != 5);
	}
}
