
/**
 * The Order class for the IKEA warehouse program.
 * The Order class connects to both the orderDB and the orderScreen. 
 * 
 * @author Glenn Gibbons
 * @version 11-07-15
 */
public class Order
{
    String storeID, comment;
    int orderID;
	Orders orderDB;

    //Constructor
    //An order takes a storeID, which is a String that can have letters and/or numbers;
    //  An orderID, which can be only numbers (for the sake of easy incrementing);
    //  And a comment, which is a String input by the user.
    public Order(int orderID, String storeID, String comment){
    	this.storeID = storeID;
        this.orderID = orderID;
        this.comment = comment;
        this.orderDB = new Orders();
    }
    
    public Order(){
    	storeID = null;
        orderID = 0;
        comment = null;
        orderDB = new Orders();
    }

    //addOrder method
    //Adds an order to the database.
    //Is meant to be used by the orderScreen so that a user can input info.
    //Returns the orderID of the newly-created order.
    public int addOrder(String tempStoreID, String tempComment){
 	int newID = orderDB.getNextOrderID()+1;
        orderDB.addOrder(newID, tempStoreID, tempComment);
        return newID;
        //Do error handling in later versions
    }
    
    //getOrder method
    //Returns an order that matches the ID
    public Order getOrder(int tempID){
        return orderDB.getOrder(tempID);
    }
}
