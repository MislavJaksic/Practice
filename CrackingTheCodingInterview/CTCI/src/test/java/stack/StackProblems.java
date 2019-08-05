package stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import fundamental.data_structure.Stack;
import stackqueue.QueueViaStacks;
import stackqueue.SetOfStacks;
import stackqueue.SortStack;
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
		SetOfStacks<Integer> stack = new SetOfStacks<Integer>(Integer.class, 3, 1);
		
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
		QueueViaStacks<Integer> queue = new QueueViaStacks<Integer>();
		
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
	
	@Nested
	class SortStackTests {
		SortStack sorter = new SortStack();
		Stack<Integer> stack = new Stack<Integer>();
		
		@BeforeEach
		public void addData() {
			int data = 3;
			stack.push(data);
			data = 2;
			stack.push(data);
			data = 7;
			stack.push(data);
			data = 1;
			stack.push(data);
			data = 5;
			stack.push(data);
		}
		
		@Test
		public void popMaxTest() {
			int data = sorter.popMax(stack);
			
			int expected = 7;
			
			assertEquals(expected, data);
		}
		
		@Test
		public void peekAfterPopMaxTest() {
			sorter.popMax(stack);
			
			int expected = 5;
			
			assertEquals(expected, stack.peek());
		}
		
		@Test
		public void sortTest() {
			Stack<Integer> sorted_stack = sorter.sortAscending(stack);
			Stack<Integer> expected = new Stack<Integer>();
			int data = 7;
			expected.push(data);
			data = 5;
			expected.push(data);
			data = 3;
			expected.push(data);
			data = 2;
			expected.push(data);
			data = 1;
			expected.push(data);
			
			while ((!sorted_stack.isEmpty()) && (!stack.isEmpty())) {
				assertEquals(expected.pop(), sorted_stack.pop());
			}
		}
	}
}
