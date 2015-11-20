
import java.util.ArrayList;

public class Picklist {
	
	private boolean isPicked;
	private ArrayList<Item> itemsToPick = new ArrayList<Item>();
	
	public Picklist(boolean picked)
	{
		isPicked = picked;
	}
	
	public boolean getStatus()
	{
		return isPicked;
	}
	
	public void setStatus(boolean picked)
	{
		isPicked = picked;
	
	}
}

