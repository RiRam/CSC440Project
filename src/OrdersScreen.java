import java.util.*;

/**
 * The Order class for the IKEA warehouse program.
 * The Order class connects to both the orderDB and the orderScreen. 
 * 
 * @author Arielle Tabuteau
 */

public class OrdersScreen {

	public static void main(String[] args) {
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
				System.out.println("Sorry this feature is unavailable at this time.");
			} 
			} while (input != 3);
			System.out.println("Thank you for using the program.");
	}
	
	public static void addOrder() {
		Scanner keyb = new Scanner(System.in); 
		//Order storeN;
		String storeId;
		String message;
		int orderId = 0;
		
		System.out.println("Enter the Store Id: ");
		storeId = keyb.nextLine();
		
		System.out.println("Enter your comment: ");
		message = keyb.nextLine();
		
		Order storeN = new Order (orderId, storeId, message);
		
		orderId = storeN.addOrder();
		
		System.out.println("Entered information:");
		System.out.println("Order Id: " + orderId);
		System.out.println("Store Id: " + storeId);
		System.out.println("Comment: " + message);
    }
	
	public static void searchOrder(){
		/*Scanner keyb = new Scanner(System.in); 
		String storeId = "";
		String message = "";
		int orderId;
		
		System.out.println("Enter the Order Id: ");
		orderId = keyb.nextInt();
		
		Order storeN = new Order (orderId, storeId, message);
		
		orderId = storeN.getOrder(orderId);
		
		System.out.println("Entered information:");
		System.out.println("Order Id: " + orderId);
		System.out.println("Store Id: " + storeId);
		System.out.println("Comment: " + message);*/
	}

}
