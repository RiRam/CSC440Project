import static org.junit.Assert.*;

import org.junit.Test;

public class InventoryTest {

	@Test
	public void test() {
		Inventory inv = new Inventory();
		assertEquals(inv.getNameByID(1), "Red Chair");
	}

}
