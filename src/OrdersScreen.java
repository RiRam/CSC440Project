import java.util.*;

/**
 * The Order class for the IKEA warehouse program.
 * The Order class connects to both the orderDB and the orderScreen. 
 * 
 * @author Arielle Tabuteau
 */

public class OrdersScreen {

	public static void main(String[] args) {
		start(); 
		addOrder();
	}
	
	public static void start() {
		Scanner keyb = new Scanner(System.in);
		String ans;
		
		System.out.println("Would you like to create a new order?");
        ans = keyb.nextLine();
		
		if(ans.equalsIgnoreCase("yes")){
			System.out.println("Ok, starting order making process.");
		}
		else if(ans.equalsIgnoreCase("no")){
			System.out.println("Ok, closing program.");
			System.exit(0);
		}
		else {
			System.out.println("Invaild entry. Please try again.");
			System.exit(0);
		}
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
		
		orderId = storeN.addOrder(storeId, message);
		
		System.out.println("Entered information:");
		System.out.println("Order Id: " + orderId);
		System.out.println("Store Id: " + storeId);
		System.out.println("Comment: " + message);
    }

}
