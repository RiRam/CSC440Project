import static org.junit.Assert.*;

import org.junit.Test;


public class OrderLineTest {

	@Test
	public void checkOrderLineStatus() {
		OrderLine o = new OrderLine(4, 5, "Picked");
		assertEquals(o.getOrderLineStatus(), "Picked");	}
	
	@Test
	public void checkLineItemID() {
		OrderLine o = new OrderLine();
		assertEquals(o.getLineItemID(), 0);
	}

}
