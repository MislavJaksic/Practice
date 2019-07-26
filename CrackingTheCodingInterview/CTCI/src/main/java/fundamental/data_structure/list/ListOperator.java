package fundamental.data_structure.list;

public class ListOperator {
	public static ListNode Append(ListNode node, int data) {
		ListNode new_node = new ListNode(data);

		ListNode last_node = ListOperator.GetLastNode(node);
		if (last_node != null) {
			last_node.next = new_node;
			return node;
		}
		return new_node;
	}
	
	public static ListNode GetLastNode(ListNode node) {
		if (node == null) {
			return node;
		}
		
		while (node.next != null) {
			node = node.next;
		}
		return node;
	}
	
	public static ListNode GetSecondToLastNode(ListNode node) {
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
	
	public static void Print(ListNode node) {
		while (node != null) {
			System.out.println(node.data);
			node = node.next;
		}
	}
}
