package strategyPatternExercise;

import static org.junit.Assert.*;

import org.junit.Test;

import stackExercise.Stack;

public class stackExercise {
	
	private Stack<String> stack = new Stack<>();
	
	
	@Test
	public void testingExercise (){
		stack.push("Batman");
		stack.push("Deadpool");
		stack.push("Spiderman");
		assertEquals(3, stack.size());
		assertEquals("Spiderman", stack.peek());
		assertEquals("Spiderman, Deadpool, Batman", stack.toString());
		assertTrue(stack.contains("Spiderman"));
		stack.flip();
		System.out.println(stack.toString());
	}
}
