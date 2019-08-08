package fundamental.structure.list;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import fundamental.structure.list.ListNode;
import fundamental.structure.list.ListOperator;

public class ListOperatorTest {
	@Nested
	class GetLastNodeTests {
		@Test
		public void TestGetLastNullNode() {
			ListNode node = null;
			
			ListNode expected = null;

			assertEquals(expected, ListOperator.getLastNode(node));
		}
		
		@Test
		public void TestGetLastOneNode() {
			ListNode node = new ListNode(0);
			
			ListNode expected = new ListNode(0);

			assertEquals(expected, ListOperator.getLastNode(node));
		}
		
		@Test
		public void TestGetLastTwoNodes() {
			ListNode node = new ListNode(0);
			node.next = new ListNode(1);
			
			ListNode expected = new ListNode(1);

			assertEquals(expected, ListOperator.getLastNode(node));
		}
	}
	
	@Nested
	class GetSecondToLastNodeTests {
		@Test
		public void TestGetSecondToLastNullNode() {
			ListNode node = null;
			
			ListNode expected = null;

			assertEquals(expected, ListOperator.getSecondToLastNode(node));
		}
		
		@Test
		public void TestGetSecondToLastOneNode() {
			ListNode node = new ListNode(0);
			
			ListNode expected = new ListNode(0);

			assertEquals(expected, ListOperator.getSecondToLastNode(node));
		}
		
		@Test
		public void TestGetSecondToLastThreeNodes() {
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
		public void TestAppendToNull() {
			ListNode node = null;
			ListNode result = ListOperator.append(node, 0);
			
			ListNode expected = new ListNode(0);

			assertEquals(expected, ListOperator.getLastNode(result));
		}
		
		@Test
		public void TestAppendToNonNull() {
			ListNode node = new ListNode(0);
			ListNode result = ListOperator.append(node, 1);
			
			ListNode expected = new ListNode(1);

			assertEquals(expected, ListOperator.getLastNode(result));
		}
	}
}
