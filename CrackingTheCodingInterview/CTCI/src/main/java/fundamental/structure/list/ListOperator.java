package fundamental.structure.list;

public class ListOperator {
	public static ListNode append(ListNode node, int data) {
		ListNode new_node = new ListNode(data);

		ListNode last_node = ListOperator.getLastNode(node);
		if (last_node != null) {
			last_node.next = new_node;
			return node;
		}
		return new_node;
	}
	
	public static ListNode getLastNode(ListNode node) {
		if (node == null) {
			return node;
		}
		
		while (node.next != null) {
			node = node.next;
		}
		return node;
	}
	
	public static ListNode getSecondToLastNode(ListNode node) {
		if (node == null) {
			return node;
		} else if (node.next == null) {
			return node;
		}
		
		while (node.next.next != null) {
			node = node.next;
		}
		return node;
	}
	
	public static void print(ListNode node) {
		while (node != null) {
			System.out.println(node.data);
			node = node.next;
		}
	}
}
