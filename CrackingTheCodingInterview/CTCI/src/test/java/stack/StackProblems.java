package stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import stackqueue.StackMin;

public class StackProblems {
	@Nested
	class StackMinTests {
		StackMin stack = new StackMin();
		
		@Test
		public void minZeroTest() {
			int expected = StackMin.sentinel;
			
			assertEquals(expected, stack.min());
		}
		
		@Test
		public void minOneTest() {
			int data = 1;
			stack.push(data);
			
			int expected = 1;
			
			assertEquals(expected, stack.min());
		}
		
		@Test
		public void minTwoTest() {
			int data = 1;
			stack.push(data);
			data = 2;
			stack.push(data);
			
			int expected = 1;
			
			assertEquals(expected, stack.min());
		}
		
		@Test
		public void minThreeTest() {
			int data = 1;
			stack.push(data);
			data = 2;
			stack.push(data);
			data = 3;
			stack.push(data);
			
			int expected = 1;
			
			assertEquals(expected, stack.min());
		}
		
		@Test
		public void minThreeTopTest() {
			int data = 3;
			stack.push(data);
			data = 2;
			stack.push(data);
			data = 1;
			stack.push(data);
			
			int expected = 1;
			
			assertEquals(expected, stack.min());
		}
	}
}
