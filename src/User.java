
public class User {
	
	private String password;
	private String username;
	private int ID;

	public User (String newPassword, int newID, String newUsername)
	{
		this.password = newPassword;
		this.username = newUsername;
		this.ID = newID;
		
		Users.addUser (this.ID, this.username,  this.password)
	}
	
	public void getUsername(int ID)
	{
		return Users.getUsernameByID(this.ID)
	}
	
	
}
	