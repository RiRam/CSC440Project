
public class User {
	Users Usr = new Users();
	private String password;
	private String username;
	private int ID;
	private int type;

	public User (String newPassword, int newID, String newUsername, int userType)	{
		this.password = newPassword;
		this.username = newUsername;
		this.ID = newID;
		this.type = userType;
		
		Usr.addUser (this.ID, this.username,  this.password, userType);
	}
	
	public String getUsername(int ID)
	{
		return Usr.getUsernameByID(this.ID);
	}
	public int getType() {
		return this.type;
	}
	
	
}
	