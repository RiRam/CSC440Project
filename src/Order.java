import java.util.ArrayList;

/**
 * The Order class for the IKEA warehouse program.
 * The Order class connects to both the orderDB and the orderScreen. 
 * 
 * @author Glenn Gibbons
 * @version 11-18-15
 */
public class Order{
	
    private String storeID, comment, orderStatus;
    	//Status can be: "To be picked", "Picking" or "Picked"
    private int orderID;
    private ArrayList<OrderLine> orderLineList;
	private Orders orderDB;

	/**
	 * Order constructor. OrderID is assigned automatically when the order is
	 *  added to the database.
	 * 
	 * @param storeID - ID of the store the order comes from
	 * @param comment - Comment (optional)
	 */
    public Order(String storeID, String comment){
    	this.storeID = storeID;
    	this.orderID = 0;
        this.comment = comment;
        this.orderStatus = "To be picked";
        this.orderLineList = new ArrayList<OrderLine>();
    }
    
    /**
	 * Order constructor, including all parameters.
	 * 
	 * @param orderID - The order's unique ID
	 * @param storeID - ID of the store the order comes from
	 * @param comment - Comment (optional)
	 * @param orderStatus - Picked/Not picked status of order
	 * @param orderLineList - An arraylist of order lines contained in this order
	 */
    public Order(int orderID, String storeID, String comment, String orderStatus, ArrayList<OrderLine> orderLineList){
    	this.storeID = storeID;
    	this.orderID = orderID;
        this.comment = comment;
        this.orderStatus = orderStatus;
        this.orderLineList = orderLineList;
    }
    
    /**
	 * Default Order constructor. Takes no parameters.
	 */
    public Order(){
    	storeID = "";
        orderID = 0;
        comment = "";
        orderStatus = "";
        this.orderLineList = new ArrayList<OrderLine>();
    }

    //-----------------------------------------//
    //-----------GET AND SET METHODS-----------//
    //-----------------------------------------//

    /**
	 * storeID getter
	 * 
	 * @return storeID - ID of the store the order comes from
	 */
    public String getStoreID(){
    	return this.storeID;
    }
    
    /**
	 * comment getter
	 * 
	 * @return comment - Comment (optional)
	 */
    public String getComment(){
    	return this.comment;
    }
    
    /**
	 * orderID getter
	 * 
	 * @return orderID - The order's unique ID number.
	 */
    public int getOrderID(){
    	return this.orderID;
    }
    
    /**
	 * orderStatus getter
	 * 
	 * @return orderStatus - The order's picked/not picked status.
	 */
    public String getOrderStatus(){
    	return this.orderStatus;
    }
    
    /**
	 * orderLineList getter
	 * 
	 * @return orderLineList - An arraylist of order lines contained in this order
	 */
    public ArrayList<OrderLine> getOrderLineList(){
    	return this.orderLineList;
    }
    
    /**
	 * storeID setter
	 * 
	 * @param storeID - ID of the store the order comes from
	 */
    public void setStoreID(String newStoreID){
    	this.storeID = newStoreID;
    }
    
    /**
	 * comment getter
	 * 
	 * @param comment - Comment (optional)
	 */
    public void setComment(String newComment){
    	this.comment = newComment;
    }
    
    /**
	 * orderID setter
	 * 
	 * @param orderID - The order's unique ID number.
	 */
    public void setOrderID(int newOrderID){
    	this.orderID = newOrderID;
    }
    
    /**
	 * orderStatus setter
	 * 
	 * @param orderStatus - The order's picked/not picked status.
	 */
    public void getOrderStatus(String orderStatus){
    	this.orderStatus = orderStatus;
    }
    
    /**
	 * orderLineList setter
	 * 
	 * @param orderLineList - An arraylist of order lines contained in this order
	 */
    public void getOrderLineList(ArrayList<OrderLine> orderLineList){
    	this.orderLineList = orderLineList;
    }
    
    
    //-----------------------------------------//
    //-------------ACTUAL METHODS--------------//
    //-----------------------------------------//
    
    /**
	 * Add this order itself to the Orders database table, automatically
	 * assigning it the next available orderID
	 * 
	 * @return	orderID - The newly-assigned ID of this order
	 */
    public int addOrder() throws IllegalArgumentException{
    	//Thrown exception if non-comment fields are blank
        if(this.storeID.equals("") || this.orderLineList.isEmpty())
        	throw new IllegalArgumentException("Please do not leave fields blank.");
        
    	//Open database connection
    	orderDB = new Orders();
    	//Automatically assign next available orderID
    	this.orderID = orderDB.getNextOrderID();
    	//Add this order to the database
        orderDB.addOrder(this.orderID, this.storeID, this.comment, this.orderStatus, this.orderLineList);
        
        //Close database connection
        orderDB.close();
        
        //Return the newly-assigned orderID
        return this.orderID;
        //Do error handling in later versions
    }
    
    /**
	 * Search the Orders database for a specific order
	 * 
	 * @param searchID - OrderID you are searching for
	 * 
	 * @return tempOrder - The order that matches the ID searched for
	 * 
	 * @throws IllegalArgumentException if matching order is not found
	 */
    public Order searchOrder(int searchID) throws IllegalArgumentException{
    	//Open database connection
    	orderDB = new Orders();
    	//Find the order with a matching ID in the database
        Order tempOrder = orderDB.getOrder(searchID);
        
        //Close database connection
        orderDB.close();
 
        //Check the order returned. If it has all empty fields, then the ID
        //	searched for was not in the database.
        if(tempOrder.orderID == 0)
        	throw new IllegalArgumentException("orderID" + searchID + " not found");
        	
        //Return the order grabbed from the database
        return tempOrder;
    }
    
    /**
	 * Add a new OrderLine to this Order's orderLineList.
	 * 
	 * @param lineItemID - The itemID of the item being ordered
	 * @param quantity - The quantity of the item being ordered
	 * 
	 * @return	newLine - The newly-created orderLine
	 */
    public OrderLine addOrderLine(int lineItemID, int quantity){
    	OrderLine newLine = new OrderLine(lineItemID, quantity, "To Be Picked");
    	this.getOrderLineList().add(newLine);
    	return newLine;
    }
    }
