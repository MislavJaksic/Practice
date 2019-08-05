package list;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class ListProblems {
	public static boolean compareLists(Node<Integer> one, Node<Integer> two) {
		if (one == null) {
			if (two == null) {
				return true;
			} else {
				return false;
			}
		} else if (two == null) {
			return false;
		}
		
		Node<Integer> current_one = one;
		Node<Integer> current_two = two;
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
	
	public static String listToString(Node<Integer> head) {
		StringBuilder builder = new StringBuilder();
		
		Node<Integer> current = head;
		while (current != null) {
			builder.append("->");
			builder.append(current.data);
			current = current.next;
		}
		
		builder.append("->");
		builder.append("null");
		
		return builder.toString();
	}
	
	public static Node<Integer> removeDuplicates(Node<Integer> head) {
		Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		if (head == null) {
			return head;
		}
		map.put(head.data, true);
		
		Node<Integer> current = head.next;
		Node<Integer> previous = head;
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
	
	public static Node<Integer> kthToLast(Node<Integer> head, int k) {
		Node<Integer> back = head;
		Node<Integer> front = head;
		
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
	
	public static Node<Integer> deleteMiddle(Node<Integer> node) {
		if (node == null || node.next == null) {
			return node;
		}
		
		node.data = node.next.data;
		node.next = node.next.next;
		
		return node;
	}
	public static Node<Integer> partition(Node<Integer> head, int x) {
		Node<Integer> big_finder = head;
		Node<Integer> forward = head;
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
	
	public static Node<Integer> sumReverse(Node<Integer> one, Node<Integer> two) {
		if (one == null) {
			return two;
		} else if (two == null) {
			return one;
		}
		
		int sum = one.data + two.data;
		int overflow = sum / 10;
		Node<Integer> head = new Node<Integer>(sum % 10);
		Node<Integer> last = head;
		one = one.next;
		two = two.next;
		while (one != null && two != null) {
			sum = one.data + two.data + overflow;
			overflow = sum / 10;
			last.next = new Node<Integer>(sum % 10);
			last = last.next;
			one = one.next;
			two = two.next;
		}
		
		while (one != null) {
			sum = one.data + overflow;
			overflow = sum / 10;
			last.next = new Node<Integer>(sum % 10);
			last = last.next;
			one = one.next;
		}
		
		while (two != null) {
			sum = two.data + overflow;
			overflow = sum / 10;
			last.next = new Node<Integer>(sum % 10);
			last = last.next;
			two = two.next;
		}
		
		if (overflow > 0) {
			last.next = new Node<Integer>(overflow);
		}
		
		return head;
	}
	
	public static Node<Integer> reverse(Node<Integer> head) {
		if (head == null) {
			return head;
		}
		
		Node<Integer> new_head = head;
		head = head.next;
		new_head.next = null;
		Node<Integer> sentinel;
		while (head != null) {
			sentinel = head;
			head = head.next;
			sentinel.next = new_head;
			new_head = sentinel;
		}
		
		return new_head;
	}
	
	public static boolean isPalindrome(Node<Integer> head) {
		ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
		Node<Integer> first = head;
		Node<Integer> second = head;
		while (first != null) {
			first = first.next;
			if (first != null) {
				first = first.next;
				stack.push(second.data);
				second = second.next;
			} else {
				second = second.next;
			}
		}
		
		while (second != null) {
			if (stack.pop() != second.data) {
				return false;
			}
			second = second.next;
		}
		
		return true;
	}
	
	public static Node<Integer> intersection(Node<Integer> one, Node<Integer> two) {
		int count_one = 0;
		int count_two = 0;
		Node<Integer> sentinel = one;
		while (sentinel != null) {
			sentinel = sentinel.next;
			count_one++;
		}
		sentinel = two;
		while (sentinel != null) {
			sentinel = sentinel.next;
			count_two++;
		}
		
		int diff = count_one - count_two;
		if (diff > 0) {
			for (int i = 0; i < diff; i++) {
				one = one.next;
			}
		} else if (diff < 0) {
			for (int i = 0; i > diff; i--) {
				two = two.next;
			}
		}
		
		while (one != null && two != null) {
			if (one == two) {
				return one;
			}
			one = one.next;
			two = two.next;
		}
		
		return null;
	}
	
	public static Node<Integer> detectLoop(Node<Integer> head) {
		Node<Integer> fast = head;
		Node<Integer> slow = head;
		while (fast != null) {
			fast = fast.next;
			if (fast != null) {
				fast = fast.next;
				slow = slow.next;
			}
			if (fast == slow) {
				break;
			}
		}
		
		if (fast == null) {
			return null;
		}
		fast = head;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return fast;
	}
}
