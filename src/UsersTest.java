import static org.junit.Assert.*;

import org.junit.Test;

public class UsersTest {

	@Test
	public void testCheckUsername() {
		Users u = new Users();
		assertFalse(u.checkUsername("blah"));
	}
	
	@Test
	public void testCheckUserCredentials() {
		Users u = new Users();
		assertFalse(u.checkUserCredentials("not", "indb"));
	}

	@Test
	public void testGetUserTypeByID() {
		Users u = new Users();
		assertEquals(u.getUserTypeByID(1), 1);
	}
	
	@Test
	public void testGetUsernameByID() {
		Users u = new Users();
		assertEquals(u.getUsernameByID(1), "me");
	}
}
