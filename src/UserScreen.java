import java.util.Scanner;

public class UserScreen {
	
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
		decision = UsScrn.computeDecision();
		} while (decision != 3);
		System.out.println("Thank you for using the program.");
		
	}
	private int computeDecision() {
		Scanner io = new Scanner(System.in);
		int input = io.nextInt(); 
		if (input == 1) {
			
			return 1;
		} else if (input == 2) {
			
			return 2;
		} else if (input == 3) {
			
			return 3;
		} else {
			System.out.println("Invalid Option.");
			return 0;
		}
	}
}
