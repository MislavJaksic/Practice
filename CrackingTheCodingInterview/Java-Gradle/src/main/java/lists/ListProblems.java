package lists;

import java.util.ArrayList;
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
	
//	public static Node Partition(Node head, int data) {
//		if (head == null) {
//			return null;
//		}
//		
//		Node high = head;
//		Node low = head;
//		int sentinel;
//		while (low != null) {
//			if (high.data > low.data) {
//				sentinel = high.data;
//				high.data = low.data;
//				low.data = sentinel;
//			}
//			
//			if (high.data < data) {
//				high = high.next;
//			}
//			
//			low = low.next;
//		}
//		
//		return head;
//	}
//	
//	public static Node Sum(Node one, Node two) {
//		if (one == null) {
//			if (two == null) {
//				return null;
//			} else {
//				return two;
//			}
//		} else if (two == null) {
//			return one;
//		}
//		
//		int sum = one.data + two.data;
//		int overflow = sum / 10;
//		Node head = new Node(sum % 10);
//		Node last = head;
//		one = one.next;
//		two = two.next;
//		while (one != null && two != null) {
//			sum = one.data + two.data + overflow;
//			overflow = sum / 10;
//			last.next = new Node(sum % 10);
//			last = last.next;
//			one = one.next;
//			two = two.next;
//		}
//		
//		while (one != null) {
//			sum = one.data + overflow;
//			overflow = sum / 10;
//			last.next = new Node(sum % 10);
//			last = last.next;
//			one = one.next;
//		}
//		
//		while (two != null) {
//			sum = two.data + overflow;
//			overflow = sum / 10;
//			last.next = new Node(sum % 10);
//			last = last.next;
//			two = two.next;
//		}
//		
//		if (overflow > 0) {
//			last.next = new Node(overflow);
//		}
//		
//		return head;
//	}
//	
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
