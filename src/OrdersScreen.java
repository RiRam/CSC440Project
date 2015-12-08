import java.util.*;
import java.util.ArrayList;

/**
 * The Order class for the IKEA warehouse program.
 * The Order class connects to both Order and OrderLine. 
 * 
 * @author Arielle Tabuteau
 */

public class OrdersScreen {

	public static void main(String[] args) {
		run();
//		Scanner keyb = new Scanner(System.in);
//		int input;
//		
//		System.out.println("Welcome to the Order Screen Interface. ");
//		
//		do {
//			System.out.println("Enter a command to continue:\n"
//				+ " 1: Enter a New Order\n"
//				+ " 2: Look Up an Existing Order\n"
//				+ " 3: Exit\n");
//			input = keyb.nextInt();
//			
//			if (input == 1) {
//				addOrder();
//			} 
//			
//			else if (input == 2) {
//				searchOrder();
//			} 
//			} while (input != 3);
//			System.out.println("Thank you for using the program.");
	}
	public static void run() {
		Scanner keyb = new Scanner(System.in);
		int input; // answer to menu question
		
		System.out.println("Welcome to the Order Screen Interface. ");
		
		do { //loop to print menu till user is done
			System.out.println("Enter a command to continue:\n"
				+ " 1: Enter a New Order\n"
				+ " 2: Look Up an Existing Order\n"
				+ " 3: Exit\n");
			input = keyb.nextInt(); //answer to menu question
			
			if (input == 1) {
				addOrder(); //method to add order
			} 
			
			else if (input == 2) {
				searchOrder(); //method to search order
			} 
			} while (input != 3); //exit if done
			System.out.println("Thank you for using the program.");
			
			keyb.close();
	}
	
	//method to add order
	public static void addOrder() {
		Scanner keyb = new Scanner(System.in);
		ArrayList<OrderLine> list = new ArrayList<OrderLine>(); //arraylist for item id and quantity
		int cont = 1; //tracks if continuing to add items or not
		String storeId; //store id value
		String message; //comment 
		int orderId = 0; //order id default value
		int itemId = 0, quantity = 0; // item id and quantity default values
		String orderLineStatus = ""; // order line status default
		OrderLine newLine = new OrderLine(itemId, quantity, orderLineStatus); //orderline object prep
		
		System.out.println("Enter the Store Id: "); //get value for store id
		storeId = keyb.nextLine();
		
		System.out.println("Enter your comment: "); //get value for message
		message = keyb.nextLine();
		
		Order storeN = new Order(storeId, message); // making order object with needed things 
		
		//do while to add items and quantities
		do {
			System.out.println("Enter the Item Id: "); //get value for item id
			itemId = keyb.nextInt();
			System.out.println("Enter the Quantity: "); // get value for quantity
			quantity = keyb.nextInt();
			
			newLine = storeN.addOrderLine(itemId, quantity); //using order object
			
			list.add(newLine); // adding newLine to array list
			
			System.out.println();
			System.out.println("Would you like to add another item? Enter 1 for yes and 0 for no."); // add new items?
			cont = keyb.nextInt(); // get cont value
			if (cont != 1){ //is cont value not 1
				System.out.println("Yes was not selected. Setting choice to 0."); //tell user whats going on
				cont = 0; //set cont
			}
        } while (cont != 0); // keep doing while cont is not 0
		//End trying
		
		orderId = storeN.addOrder(); //finally add order to database
		
		//print to display values to user
		System.out.println("Order Id: " + orderId); 
		System.out.println();
		System.out.println("Entered information:");
		System.out.println("Store Id: " + storeId);
		System.out.println("Comment: " + message);
		System.out.println();
		
		System.out.println("Items Ordered:");
		for (OrderLine OrderLine: list) { //for each loop to print values to users
			System.out.println("Item Id: " + OrderLine.getLineItemID() + " " + "Entered Quantity: " 
					+ OrderLine.getQuantity() + " " + "Status: " + OrderLine.getOrderLineStatus());
		}
		
		System.out.println();
		
		keyb.close();
    }
	
	//method to search order
	public static void searchOrder(){
		Scanner keyb = new Scanner(System.in);
		Order storeN = new Order();
		Order storeQ = new Order();
		String storeId = "";
		String message = "";
		int orderId;
		
		System.out.println("Enter the Order Id: ");
		orderId = keyb.nextInt();
		
		storeQ = storeN.searchOrder(orderId);
		orderId = storeQ.getOrderID();
		storeId = storeQ.getStoreID();
		message = storeQ.getComment();
		
		System.out.println("Entered information:");
		System.out.println("Order Id: " + orderId);
		System.out.println("Store Id: " + storeId);
		System.out.println("Comment: " + message);
		
		keyb.close();
	}

}
