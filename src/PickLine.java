/**
 * PickLine Class
 * 
 * @author Erica Ram
 */
public class PickLine {
	Item item = new Item();
	int quantity;
	String status;
	
	/**
	 * PickLine Constructor
	 * @param i
	 * @param quant
	 */
	public PickLine(Item i, int quant)
	{
		item = i;
		quantity = quant;
		status = "To Be Picked";
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
	
	/**
	 * Update status to be "To Be Picked"
	 */
	public void setStatusToBePicked()
	{
		status = "To Be Picked";
	}
	
	/**
	 * Update status to "Picked"
	 */
	public void setStatusPicked()
	{
		status = "Picked";
	}
	
}
