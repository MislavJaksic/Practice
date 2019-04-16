package lists;

import java.util.HashMap;
import java.util.Map;

public class ListProblems {
	public static boolean compareLists(Node one, Node two) {
		if (one == null) {
			if (two == null) {
				return true;
			} else {
				return false;
			}
		} else if (two == null) {
			return false;
		}
		
		Node current_one = one;
		Node current_two = two;
		while (current_one != null && current_two != null) {
			if (current_one.data != current_two.data) {
				return false;
			}
			current_one = current_one.next;
			current_two = current_two.next;
		}
		
		if (current_one == current_two) {
			return true;
		}
		
		return false;
	}
	
	public static String listToString(Node head) {
		StringBuilder builder = new StringBuilder();
		
		Node current = head;
		while (current != null) {
			builder.append("->");
			builder.append(current.data);
			current = current.next;
		}
		
		builder.append("->");
		builder.append("null");
		
		return builder.toString();
	}
	
	public static Node removeDuplicates(Node head) {
		Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		if (head == null) {
			return head;
		}
		map.put(head.data, true);
		
		Node current = head.next;
		Node previous = head;
		while (current != null) {
			Integer number = current.data;
			if (map.get(number) == null) {
				map.put(number, true);
				previous = previous.next;
			} else {
				previous.next = current.next;
			}
			current = current.next;
		}
		
		return head;
	}
	
	public static Node kthToLast(Node head, int k) {
		Node back = head;
		Node front = head;
		
		for (int i = 0; i < k + 1; i++) {
			if (front == null) {
				return front;
			}
			front = front.next;
		}
		
		while (front != null) {
			back = back.next;
			front = front.next;
		}
		
		return back;
	}
	
	public static Node deleteMiddle(Node node) {
		if (node == null || node.next == null) {
			return node;
		}
		
		node.data = node.next.data;
		node.next = node.next.next;
		
		return node;
	}
	public static Node partition(Node head, int x) {
		Node big_finder = head;
		Node forward = head;
		int sentinel;
		while (forward != null) {
			if (forward.data < x) {
				sentinel = big_finder.data;
				big_finder.data = forward.data;
				forward.data = sentinel;
			}
			if (big_finder.data < x) {
				big_finder = big_finder.next;
			}
			forward = forward.next;
		}
		
		return head;
	}
	
	public static Node sumReverse(Node one, Node two) {
		if (one == null) {
			return two;
		} else if (two == null) {
			return one;
		}
		
		int sum = one.data + two.data;
		int overflow = sum / 10;
		Node head = new Node(sum % 10);
		Node last = head;
		one = one.next;
		two = two.next;
		while (one != null && two != null) {
			sum = one.data + two.data + overflow;
			overflow = sum / 10;
			last.next = new Node(sum % 10);
			last = last.next;
			one = one.next;
			two = two.next;
		}
		
		while (one != null) {
			sum = one.data + overflow;
			overflow = sum / 10;
			last.next = new Node(sum % 10);
			last = last.next;
			one = one.next;
		}
		
		while (two != null) {
			sum = two.data + overflow;
			overflow = sum / 10;
			last.next = new Node(sum % 10);
			last = last.next;
			two = two.next;
		}
		
		if (overflow > 0) {
			last.next = new Node(overflow);
		}
		
		return head;
	}
	
	public static Node reverse(Node head) {
		if (head == null) {
			return head;
		}
		
		Node new_head = head;
		head = head.next;
		new_head.next = null;
		Node sentinel;
		while (head != null) {
			sentinel = head;
			head = head.next;
			sentinel.next = new_head;
			new_head = sentinel;
		}
		
		return new_head;
	}
	
//	public static boolean IsPalindrome(Node head) {
//		if (head == null || head.next == null) {
//			return true;
//		}
//		
//		Node current = head;
//		ArrayList<Integer> array = new ArrayList<Integer>();
//		while (current != null) {
//			array.add(current.data);
//			current = current.next;
//		}
//		
//		int length = array.size();
//		int first = length / 2 - 1;
//		int second = length / 2 + 1;
//		if (length % 2 == 0) {
//			second--;
//		}
//		
//		while (first > -1) {
//			if (array.get(first) != array.get(second)) {
//				return false;
//			}
//			first--;
//			second++;
//		}
//		
//		return true;
//	}
}
