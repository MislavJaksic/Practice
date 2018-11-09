package mjaksic.java_maven.list;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mjaksic.java_maven.list.List;
import mjaksic.java_maven.list.ListNode;

class ListTest {

	@Test
	public List CreateListWithNull() {
		List list = new List(null);
		
		String exprected_result = List.head_sentinel + "->" + List.tail_sentinel;
		assertEquals(exprected_result, list.toString());
		return list;
	}
	
	@Test
	public List CreateListWithOneNode() {
		ListNode node = new ListNode("one");
		List list = new List(node);
		
		String exprected_result = List.head_sentinel + "->one->" + List.tail_sentinel;
		assertEquals(exprected_result, list.toString());
		return list;
	}
	
	
	
	@Test
	public void AddNodesNode() {
		List list = this.CreateListWithOneNode();
		ListNode node = new ListNode("two");
		list.AddNode(node);
		node = new ListNode("three");
		list.AddNode(node);
		
		String exprected_result = List.head_sentinel + "->one->two->three->" + List.tail_sentinel;
		assertEquals(exprected_result, list.toString());
	}
	
	@Test
	public void InsertNodes() {
		List list = this.CreateListWithNull();
		ListNode node = new ListNode("one");
		list.InsertNodeAtIndex(node, 0);
		ListNode two = new ListNode("two");
		list.InsertNodeAtIndex(two, 1);
		
		String exprected_result = List.head_sentinel + "->one->two->" + List.tail_sentinel;
		assertEquals(exprected_result, list.toString());
	}
	
	
	
}
