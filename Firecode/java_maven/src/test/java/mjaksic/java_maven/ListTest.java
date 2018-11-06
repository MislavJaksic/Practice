package mjaksic.java_maven;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mjaksic.java_maven.helpers.List;
import mjaksic.java_maven.helpers.ListNode;

class ListTest {

	@Test
	void CreateListWithOneNode() {
		ListNode node = new ListNode("one");
		List list = new List(node);
		String exprected_result = "head->one->END OF LIST";
		assertEquals(exprected_result, list.toString());
	}
	
	@Test
	void AddNodesNode() {
		ListNode node = new ListNode("one");
		List list = new List(node);
		node = new ListNode("two");
		list.Add(node);
		node = new ListNode("three");
		list.Add(node);
		String exprected_result = "head->one->two->three->END OF LIST";
		assertEquals(exprected_result, list.toString());
	}
	
	@Test
	void CreateListWithNull() {
		ListNode node = null;
		List list = new List(node);
		String exprected_result = "head->END OF LIST";
		assertEquals(exprected_result, list.toString());
	}

}
