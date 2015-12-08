import java.util.*;

/**
 * The Order class for the IKEA warehouse program.
 * The Order class connects to both the orderDB and the orderScreen. 
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
		int input;
		
		System.out.println("Welcome to the Order Screen Interface. ");
		
		do {
			System.out.println("Enter a command to continue:\n"
				+ " 1: Enter a New Order\n"
				+ " 2: Look Up an Existing Order\n"
				+ " 3: Exit\n");
			input = keyb.nextInt();
			
			if (input == 1) {
				addOrder();
			} 
			
			else if (input == 2) {
				searchOrder();
			} 
			} while (input != 3);
			System.out.println("Thank you for using the program.");
	}
	
	public static void addOrder() {
		Scanner keyb = new Scanner(System.in); 
		String storeId;
		String message;
		int orderId = 0;
		
		System.out.println("Enter the Store Id: ");
		storeId = keyb.nextLine();
		
		System.out.println("Enter your comment: ");
		message = keyb.nextLine();
		
		Order storeN = new Order(storeId, message);
		
		orderId = storeN.addOrder();
		
		System.out.println("Entered information:");
		System.out.println("Order Id: " + orderId);
		System.out.println("Store Id: " + storeId);
		System.out.println("Comment: " + message);
    }
	
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
	}

}
