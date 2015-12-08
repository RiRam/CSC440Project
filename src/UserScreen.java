import java.util.Scanner;
import java.io.Console;

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
		UsScrn.exit();
//		System.out.println("Thank you for using the program.");
		
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
			return 3;
		} else {
			System.out.println("Invalid Option.");
			return 0;
		}
	}
	public void Login() {
		UserScreen UsSc = new UserScreen();
		boolean programRun = false;
		String decision = "";
		
		do {
			Scanner io = new Scanner (System.in);
			System.out.println("Please enter your username: ");
			String username = io.nextLine();
		
			System.out.println("Please enter your password: ");
			String password = io.nextLine();
			
			if (UsSc.credentialsValid(username, password)) {
//				System.out.println("Are we here");
				//int type = 3;//Integer.parseInt(Usr.getTypeByCredentials(username,password));
				MenuManager.run();
				programRun = true;
			} else {
				System.out.println("Invalid credentials. Would you like to try again? (Y/N)");
				decision = io.nextLine();
			}

		} while (decision.equalsIgnoreCase("Y") || programRun == false);
		
	}
	
	public boolean credentialsValid (String username, String password) {
		return Usr.checkUserCredentials(username, password);
	}
	
	public void createAccount() {
		// Prompt User to create account
		String username;
		Scanner io = new Scanner(System.in);
		System.out.println("Are you sure that you would like to create a new account? (Y/N)");
		String decision = io.nextLine();
		if (decision.equalsIgnoreCase("Y")) {
			
			do {
				System.out.println("Enter new username");
				username = io.nextLine();
			
				System.out.println("Enter new password: (Remember to write down your password!)");
				String password = io.nextLine();
			
				if (!Usr.checkUsername(username)) {
					int userID = Usr.getNextUserID();
					User newUser = new User(password, userID, username, 1);
					if (newUser.getUsername(userID) != "") {
						System.out.println("New User succesfully created.");
						System.out.println("Username: " + newUser.getUsername(userID));
						break;
					}
				} else {
					System.out.println("That Username has already been taken. Please try a different username. ");
					System.out.println("Would you like to try again? (Y/N)");
					decision = io.nextLine();
				}
			} while (decision.equalsIgnoreCase("Y"));
			
		}
	}
	
	public void exit() {
		System.out.println("Thank you for using the program.");
		System.exit(0);
	}
}
