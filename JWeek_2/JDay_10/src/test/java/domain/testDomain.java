package domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class testDomain {

	@Test
	public void testClass(){
		User user1 = new User("Dead Pool", "deadpool@gmail.com", "deadpool", "IloveHelloKitty");
//		User user2 = new User("Bruce Wayne", "batseverywhere@gmail.com", "batman", "callMeBaby");
//		User user3 = new User("Pert Parker", "aracnofobiaftw@gmail.com", "spiderman", "cleanTheCityAfterMe");
		
		Tweet tweet1 = new Tweet("I hate spiders!", user1);
		
		assertEquals("Dead Pool", user1.getFullName());
		assertEquals(user1, tweet1.getAuthor());

	}
}
