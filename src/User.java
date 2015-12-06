
public class User {
	Users Usr = new Users();
	private String password;
	private String username;
	private int ID;

	public User (String newPassword, int newID, String newUsername)
	{
		this.password = newPassword;
		this.username = newUsername;
		this.ID = newID;
		
		Usr.addUser (this.ID, this.username,  this.password);
	}
	
	public String getUsername(int ID)
	{
		return Usr.getUsernameByID(this.ID);
	}
	
	
}
	