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
	
	@Test
	public void testcheckUsername() {
		Users u = new Users();
		assertEquals(u.checkUsername("dhansonii"), true);
	}
	
	@Test
	public void testcheckUsernameFalse() {
		Users u = new Users();
		assertEquals(u.checkUsername("john546"), false);
	}
	
	@Test
	public void getTypeByCredentials() {
		Users u = new Users();
		assertEquals(u.checkUserCredentials("hello", "goodbye"), true);
	}
	
	@Test
	public void getTypeByCredentialsFalse() {
		Users u = new Users();
		assertEquals(u.checkUserCredentials("Hello", "goodbye"), false);
	}
}
