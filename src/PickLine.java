import java.util.ArrayList;

/**
 * PickLine Class
 * 
 * @author Erica Ram
 */
public class PickLine {
	private Item item = new Item();
	private int quantity;
	private String status;
	private static Inventory inv;
	
	
	public static void main(String[] args)
	{
		Orders ord = new Orders();
		ArrayList<PickLine> arr = new ArrayList<PickLine>();
		System.out.println("Generating PickLines...");
		arr = ord.generatePickLines();
		for(PickLine p : arr)
		{
			System.out.println(p.getItem().getItemName() + " quant: " + p.getQuantity());
		}
	}
	
	/**
	 * PickLine Constructor
	 * @param i
	 * @param quant
	 */
	public PickLine(int ID, int quant, String s)
	{
		inv = new Inventory();
		item = inv.getItem(ID);
		inv.close();
		quantity = quant;
		status = s;
	}
	
	/**
	 * Returns the Item of the PickLine
	 * 
	 * @return Item
	 */
	public Item getItem()
	{
		return item;
	}
	
	/**
	 * Returns the quantity of the PickLine
	 * 
	 * @return int
	 */
	public int getQuantity()
	{
		return quantity;
	}
	
	/**
	 * Returns the status of the PickLine
	 * 
	 * @return String - will either be "To Be Picked" or "Picked"
	 */
	public String getStatus()
	{
		return status;
	}
	
	public void addToQuantity(int more)
	{
		quantity += more;
	}
	
	/**
	 * Update status to be "To Be Picked"
	 */
	public void setStatusToBePicked()
	{
		status = "To Be Picked";
	}
	
	/**
	 * Update status to be "Picking"
	 */
	public void setStatusPicking()
	{
		status = "Picking";
	}
	
	/**
	 * Update status to "Picked"
	 */
	public void setStatusPicked()
	{
		status = "Picked";
	}
	
}
