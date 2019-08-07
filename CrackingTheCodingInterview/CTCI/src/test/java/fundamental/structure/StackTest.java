package fundamental.structure;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import fundamental.structure.Stack;

public class StackTest {
	@Nested
	class FunctionTests {
		Stack<Integer> stack = new Stack<Integer>();
		
		@Test
		public void pushOneTest() {
			int data = 1;
			stack.push(data);
			
			int expected = 1;
			
			assertEquals(expected, stack.peek());
		}
		
		@Test
		public void pushTwoTest() {
			int data = 1;
			stack.push(data);
			data = 2;
			stack.push(data);
			
			int expected = 2;
			
			assertEquals(expected, stack.peek());
		}
		
		@Test
		public void popOneTest() {
			int data = 1;
			stack.push(data);
			stack.pop();
			
			Integer expected = stack.sentinel;
			
			assertEquals(expected, stack.peek());
		}
		
		@Test
		public void popTwoTest() {
			int data = 1;
			stack.push(data);
			data = 2;
			stack.push(data);
			stack.pop();
			stack.pop();
			
			Integer expected = stack.sentinel;
			
			assertEquals(expected, stack.peek());
		}
		
		@Test
		public void emptyTest() {
			boolean expected = true;
			
			assertEquals(expected, stack.isEmpty());
		}
		
		@Test
		public void notEmptyTest() {
			int data = 1;
			stack.push(data);
			
			boolean expected = false;
			
			assertEquals(expected, stack.isEmpty());
		}
	}
}
