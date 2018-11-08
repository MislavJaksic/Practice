package mjaksic.java_maven.list;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mjaksic.java_maven.list.List;
import mjaksic.java_maven.list.ListNode;

class ListTest {

	@Test
	void CreateListWithOneNode() {
		ListNode node = new ListNode("one");
		List list = new List(node);
		
		String exprected_result = List.head_sentinel + "->one->" + List.tail_sentinel;
		assertEquals(exprected_result, list.toString());
	}
	
	@Test
	void AddNodesNode() {
		ListNode node = new ListNode("one");
		List list = new List(node);
		node = new ListNode("two");
		list.AddNode(node);
		node = new ListNode("three");
		list.AddNode(node);
		
		String exprected_result = List.head_sentinel + "->one->two->three->" + List.tail_sentinel;
		assertEquals(exprected_result, list.toString());
	}
	
	@Test
	void CreateListWithNull() {
		List list = new List(null);
		
		String exprected_result = List.head_sentinel + "->" + List.tail_sentinel;
		assertEquals(exprected_result, list.toString());
	}
	
	@Test
	void InsertOneNode() {
		List list = new List(null);
		ListNode node = new ListNode("one");
		list.InsertNodeAtIndex(node, 0);
		
		String exprected_result = List.head_sentinel + "->one->" + List.tail_sentinel;
		assertEquals(exprected_result, list.toString());
	}
	
	@Test
	void InsertTwoNode() {
		List list = new List(null);
		ListNode one = new ListNode("one");
		list.InsertNodeAtIndex(one, 0);
		ListNode two = new ListNode("two");
		list.InsertNodeAtIndex(two, 1);
		
		String exprected_result = List.head_sentinel + "->one->two->" + List.tail_sentinel;
		assertEquals(exprected_result, list.toString());
	}

}
