package fundamental.structure.list;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ListOperatorTest {
	@Nested
	class GetLastNodeTests {
		@Test
		public void getLastNullNodeTest() {
			ListNode node = null;

			ListNode expected = null;

			assertEquals(expected, ListOperator.getLastNode(node));
		}

		@Test
		public void getLastOneNodeTest() {
			ListNode node = new ListNode(0);

			ListNode expected = new ListNode(0);

			assertEquals(expected, ListOperator.getLastNode(node));
		}

		@Test
		public void getLastTwoNodesTest() {
			ListNode node = new ListNode(0);
			node.next = new ListNode(1);

			ListNode expected = new ListNode(1);

			assertEquals(expected, ListOperator.getLastNode(node));
		}
	}

	@Nested
	class GetSecondToLastNodeTests {
		@Test
		public void getSecondToLastNullNodeTest() {
			ListNode node = null;

			ListNode expected = null;

			assertEquals(expected, ListOperator.getSecondToLastNode(node));
		}

		@Test
		public void getSecondToLastOneNodeTest() {
			ListNode node = new ListNode(0);

			ListNode expected = new ListNode(0);

			assertEquals(expected, ListOperator.getSecondToLastNode(node));
		}

		@Test
		public void getSecondToLastThreeNodesTest() {
			ListNode node = new ListNode(0);
			node.next = new ListNode(1);
			node.next.next = new ListNode(2);

			ListNode expected = new ListNode(1);

			assertEquals(expected, ListOperator.getSecondToLastNode(node));
		}
	}

	@Nested
	class AppendTests {
		@Test
		public void appendToNullTest() {
			ListNode node = null;
			ListNode result = ListOperator.append(node, 0);

			ListNode expected = new ListNode(0);

			assertEquals(expected, ListOperator.getLastNode(result));
		}

		@Test
		public void appendToNonNullTest() {
			ListNode node = new ListNode(0);
			ListNode result = ListOperator.append(node, 1);

			ListNode expected = new ListNode(1);

			assertEquals(expected, ListOperator.getLastNode(result));
		}
	}
}
