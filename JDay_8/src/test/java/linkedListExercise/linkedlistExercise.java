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
		assertEquals("Deadpool", linked.peek());
		linked.add("Spiderman");
		assertEquals(3, linked.size());
		assertEquals("Spiderman", linked.peek());
		assertEquals("Batman, Deadpool, Spiderman", linked.toString());

	}
}
