
public class User {
	
	private String password;
	private String username;
	private int ID;

	public User (String newPassword, int newID, String newUsername)
	{
		this.password = newPassword;
		this.username = newUsername;
		this.ID = newID;
		
		Users usr = new Users();
		
	usr.addUser (this.ID, this.username,  this.password)
	}
	
	public String getUsername(int ID)
	{
		Users usr1 = new Users();
		return usr1.getUsernameByID(this.ID)
	}
	
	
}
	