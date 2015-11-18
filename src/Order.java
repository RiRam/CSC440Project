
/**
 * The Order class for the IKEA warehouse program.
 * The Order class connects to both the orderDB and the orderScreen. 
 * 
 * @author Glenn Gibbons
 * @version 11-18-15
 */
public class Order
{
    private String storeID, comment;
    private int orderID;
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
    }
    
    /**
	 * Default Order constructor. Takes no parameters.
	 */
    public Order(){
    	storeID = "";
        orderID = 0;
        comment = "";
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
	 * storeID setter
	 * Changes the order's info in the database.
	 * 
	 * @param storeID - ID of the store the order comes from
	 */
    public void setStoreID(String newStoreID){
    	orderDB = new Orders();
    	orderDB.getOrder(this.orderID).storeID = newStoreID;
    	orderDB.close();
    }
    
    /**
	 * comment setter
	 * Changes the order's info in the database.
	 * 
	 * @param comment - Comment (optional)
	 */
    public void setComment(String newComment){
    	orderDB = new Orders();
    	orderDB.getOrder(this.orderID).comment = newComment;
    	orderDB.close();
    }
    
    /**
	 * orderID setter
	 * Changes the order's info in the database.
	 * 
	 * @param orderID - The order's unique ID number.
	 */
    public void setOrderID(int newOrderID){
    	orderDB = new Orders();
    	orderDB.getOrder(this.orderID).orderID = newOrderID;
    	orderDB.close();
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
    public int addOrder(){
    	//Open database connection
    	orderDB = new Orders();
    	//Automatically assign next available orderID
    	this.orderID = orderDB.getNextOrderID();
    	//Add this order to the database
        orderDB.addOrder(this.orderID, this.storeID, this.comment);
        
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
	 */
    public Order searchOrder(int searchID){
    	//Open database connection
    	orderDB = new Orders();
    	//Find the order with a matching ID in the database
        Order tempOrder = orderDB.getOrder(searchID);
        
        //Close database connection
        orderDB.close();
        
        //Return the order grabbed from the database
        return tempOrder;
    }
}
