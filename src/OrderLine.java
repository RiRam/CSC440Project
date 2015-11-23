/**
 * The OrderLine class for the IKEA warehouse program.
 * An Order consists of one or more OrderLines.
 * 
 * @author Glenn Gibbons
 * @version 11-20-15
 */
public class OrderLine {
	
	private Item lineItem;
	private int quantity;
	
	/*
	 * OrderLine constructor. An OrderLine consists of a single item and
	 * 	a quantity.
	 * 
	 * @param lineItem - The item being ordered
	 * @param quantity - The quantity of the item being ordered
	 */
	public OrderLine(Item lineItem, int quantity){
		this.lineItem = lineItem;
		this.quantity = quantity;
	}
	
	/*
	 * Empty constructor. Sets all values to null or 0.
	 */
	public OrderLine(){
		this.quantity = 0;
	}
	
    //-----------------------------------------//
    //-----------GET AND SET METHODS-----------//
    //-----------------------------------------//
	
	/*
	 * lineItem getter
	 *
	 * @return lineItem - The item being ordered
	 */
	public Item getLineItem(){
		return this.lineItem;
	}
	
	/*
	 * quantity getter
	 * 
	 * @return quantity - The quantity of the item being ordered
	 */
	public int getQuantity(){
		return this.quantity;
	}
	
	/*
	 * lineItem setter
	 * @param lineItem - The item being ordered
	 */
	public void setLineItem(Item lineItem){
		this.lineItem = lineItem;
	}
	
	/*
	 * quantity setter
	 * @param quantity - The quantity of the item being ordered
	 */
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}
}
