/**
 * The OrderLine class for the IKEA warehouse program.
 * An Order consists of one or more OrderLines.
 * 
 * @author Glenn Gibbons
 * @version 11-20-15
 */
public class OrderLine {
	
	private int lineItemID, quantity;
	private String orderLineStatus;
	
	/*
	 * OrderLine constructor. An OrderLine consists of a single item, represented by
	 *  its ID, and	a quantity.
	 * 
	 * @param lineItemID - The itemID of the item being ordered
	 * @param quantity - The quantity of the item being ordered
	 * @param orderLineStatus - The To Be Picked/Picking/Picked status
	 */
	public OrderLine(int lineItemID, int quantity, String orderLineStatus){
		this.lineItemID = lineItemID;
		this.quantity = quantity;
		this.orderLineStatus = orderLineStatus;
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
	 * @return lineItemID - The itemID of the item being ordered
	 */
	public int getLineItemID(){
		return this.lineItemID;
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
	 * orderLineStatus getter
	 * 
	 * @return orderLineStatus - The To Be Picked/Picking/Picked status
	 */
	public String getOrderLineStatus(){
		return this.orderLineStatus;
	}
	
	/*
	 * lineItemID setter
	 * @param lineItemID - The itemID of the item being ordered
	 */
	public void setLineItemID(int lineItemID){
		this.lineItemID = lineItemID;
	}
	
	/*
	 * quantity setter
	 * @param quantity - The quantity of the item being ordered
	 */
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}
	
	/*
	 * orderLineStatus setter
	 * 
	 * @param orderLineStatus - The To Be Picked/Picking/Picked status
	 */
	public void setOrderLineStatus(String orderLineStatus){
		this.orderLineStatus = orderLineStatus;
	}
}
