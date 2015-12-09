import static org.junit.Assert.*;

import org.junit.Test;


public class OrderTest {

	@Test
	public void checkStoreID() {
		Order o = new Order("8675309", "No comment");
		assertEquals(o.getStoreID(), "8675309");	}
	
	@Test
	public void checkOrderID() {
		Order o = new Order();
		assertEquals(o.getOrderID(), 0);
	}
}
