package fundamental.structure.stackqueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class QueueTest {
	@Nested
	class FunctionTests {
		Queue<Integer> queue = new Queue<Integer>();

		@Test
		public void pushOneTest() {
			int data = 1;
			queue.add(data);

			int expected = 1;

			assertEquals(expected, queue.peek());
		}

		@Test
		public void pushTwoTest() {
			int data = 1;
			queue.add(data);
			data = 2;
			queue.add(data);

			int expected = 1;

			assertEquals(expected, queue.peek());
		}

		@Test
		public void popOneTest() {
			int data = 1;
			queue.add(data);
			queue.remove();

			Integer expected = queue.sentinel;

			assertEquals(expected, queue.peek());
		}

		@Test
		public void popTwoTest() {
			int data = 1;
			queue.add(data);
			data = 2;
			queue.add(data);
			queue.remove();
			queue.remove();

			Integer expected = queue.sentinel;

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
