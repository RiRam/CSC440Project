import java.util.Scanner;

public class UserScreen {
	Users Usr = new Users();
	public static void main(String[] args) 
	{
		UserScreen UsSc = new UserScreen();
		run(UsSc);		
	}
	/***
	 * Runs the program, prompting users to execute commands
	 * @param UsScrn
	 */
	public static void run(UserScreen UsScrn) {
		
		// Welcome the User
		int decision = 0;
		
		do {
		System.out.println("Welcome to the Software IKEA Program!\n"
				+ "Please log in, or create an account if you do not have one.\n"
				+ "1: Log In\n"
				+ "2: Create Account\n"
				+ "3: Exit\n");
		decision = computeDecision(UsScrn);
		} while (decision != 3);
		System.out.println("Thank you for using the program.");
		
	}
	private static int computeDecision(UserScreen UsScrn) {
		Scanner io = new Scanner(System.in);
		int input = io.nextInt(); 
		if (input == 1) {
			UsScrn.Login();
			return 1;
		} else if (input == 2) {
			UsScrn.createAccount();
			return 2;
		} else if (input == 3) {
			UsScrn.exit();
			return 3;
		} else {
			System.out.println("Invalid Option.");
			return 0;
		}
	}
	public void Login() {
		UserScreen UsSc = new UserScreen();
		String decision;
		
		do {
			Scanner io = new Scanner (System.in);
			System.out.println("Please enter your username: ");
			String username = io.nextLine();
		
			System.out.println("Please enter your password: ");
			String password = io.nextLine();
			if (UsSc.credentialsValid(username, password)) {
				InventoryScreen instance = new InventoryScreen();
				InventoryScreen.run(instance);
			} else {
				System.out.println("Invalid credentials. Would you like to try again? (Y/N)");
			}
			decision = io.nextLine();
		} while (decision.equalsIgnoreCase("Y"));
		
	}
	
	public boolean credentialsValid (String username, String password) {
		return Usr.checkUserCredentials(username, password);
	}
	
	public void createAccount() {
		// Prompt User to create account
		Scanner io = new Scanner(System.in);
		System.out.println("Are you sure that you would like to create a new account? (Y/N)");
		String decision = io.nextLine();
		if (decision.equalsIgnoreCase("Y")) {
			System.out.println("Enter new username");
			String username = io.nextLine();
			
			System.out.println("Enter new password");
			String password = io.nextLine();
			
			
		}
		
		
	}
	public void exit() {
		
	}
}
