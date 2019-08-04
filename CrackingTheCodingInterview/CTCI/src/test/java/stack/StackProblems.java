package stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import fundamental.data_structure.Stack;
import stackqueue.QueueViaStacks;
import stackqueue.SetOfStacks;
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
	
	@Nested
	class SetOfStacksTests {
		SetOfStacks stack = new SetOfStacks(3, 1);
		
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
			
			int expected = Stack.sentinel;
			
			assertEquals(expected, stack.peek());
		}
		
		@Test
		public void popTwoTest() {
			int data = 1;
			stack.push(data);
			data = 2;
			stack.push(data);
			stack.pop();
			
			int expected = 1;
			
			assertEquals(expected, stack.peek());
		}
		
		@Test
		public void overflowTest() {
			int data = 1;
			stack.push(data);
			data = 2;
			stack.push(data);
			data = 3;
			stack.push(data);
			data = 4;
			stack.push(data);
			
			int expected = 4;
			
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
	
	@Nested
	class QueueViaStacksTests {
		QueueViaStacks queue = new QueueViaStacks();
		
		@Test
		public void manyPopTest() {
			int data = 1;
			queue.add(data);
			data = 2;
			queue.add(data);
			
			int expected = 1;
			
			assertEquals(expected, queue.remove());
		}
		
		@Test
		public void manyPeekTest() {
			int data = 1;
			queue.add(data);
			data = 2;
			queue.add(data);
			data = 3;
			queue.add(data);
			data = 4;
			queue.add(data);
			
			int expected = 1;
			
			assertEquals(expected, queue.peek());
		}
		
		@Test
		public void emptyTest() {
			boolean expected = true;
			
			assertEquals(expected, queue.isEmpty());
		}
		
		@Test
		public void notEmptyTest() {
			int data = 1;
			queue.add(data);
			
			boolean expected = false;
			
			assertEquals(expected, queue.isEmpty());
		}
	}
}
