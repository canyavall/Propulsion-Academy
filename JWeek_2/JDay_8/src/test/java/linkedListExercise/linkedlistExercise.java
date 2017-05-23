package linkedListExercise;

import static org.junit.Assert.*;

import org.junit.Test;

import stackExercise.Stack;

public class linkedlistExercise {
	
	private LinkedList<String> linked = new LinkedList<>();
	
	
	@Test
	public void testingExercise (){
		linked.add("Batman");
		linked.add("Deadpool");
		
		//Test getLast
		assertEquals("Deadpool", linked.getLast());
		linked.add("Spiderman");
		
		//Test size
		assertEquals(3, linked.size());
		
		//test getLast is correct
		assertEquals("Spiderman", linked.getLast());
		
		//test toString
		assertEquals("Batman, Deadpool, Spiderman", linked.toString());
		
		//Test contains
		assertTrue(linked.contains("Spiderman"));
		
		//Test remove
		linked.add("Hulk");
		assertEquals("Batman, Deadpool, Spiderman, Hulk", linked.toString());
		assertEquals("Batman", linked.remove());
		assertEquals("Deadpool, Spiderman, Hulk", linked.toString());
		
		//Test add to front
		linked.addToFront("Batman");
		assertEquals("Batman, Deadpool, Spiderman, Hulk", linked.toString());

	}
}
