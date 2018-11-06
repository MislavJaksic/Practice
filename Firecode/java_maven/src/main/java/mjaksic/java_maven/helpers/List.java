package mjaksic.java_maven.helpers;

import java.lang.Exception;

public class List {
	private ListNode head;
	private int length;
	private int last_index;

	public List(ListNode node) {
		this.CreateHead();
		if (this.IsNull(node)) {
			this.length = 0;
			this.last_index = -1;
		} else {
			this.head.next = node;
			this.length = 1;
			this.last_index = 0;
		}
	}
	
	private void CreateHead() {
		this.head = new ListNode("head");
	}

	
	
	public void Add(ListNode node) {
		if (!this.IsNull(node)) {
			ListNode tail = this.GetLastNode();
			tail.next = node;
			this.IncreaseCounters();
		}
	}
	
	private ListNode GetLastNode() {
		ListNode current = this.head;
		while (current.next != null) {
			current = current.next;
		}
		return current;
	}
	/*

	public void Delete(int index) {
		this.IntNullCheck(index);

		if (this.IsIndexInRange(index)) {
			if (this.last_index == 0) {
				this.DeleteOnlyNode();
			} else if (index == 0) {
				this.head = head.next.next;
			} else {
				ListNode penultimate_node = this.GetNode(index - 1);
				penultimate_node.next = penultimate_node.next.next;
			}
		}
		this.DecreaseCounters();
	}

	private void DeleteOnlyNode() {
		this.head = null;
	}

	private ListNode GetNode(int index) {
		if (this.IsIndexInRange(index)) {
			ListNode current = this.head;
			int counter = 1;
			while (counter < index) {
				current = current.next;
				counter++;
			}
			return current;
		}
		return null;
	}

	private boolean IsIndexInRange(int index) {
		if ((index < 0) || (index > this.last_index)) {
			return false;
		}
		return true;
	}
	*/
	
	
	
	private void IncreaseCounters() {
		this.length++;
		this.last_index++;
	}

	private void DecreaseCounters() {
		this.length--;
		this.last_index--;
	}
	
	private boolean IsEmpty() {
		if (this.head.next == null) {
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		ListNode current = this.head;
		
		builder.append(current.string);
		builder.append("->");
		while (current.next != null) {
			current = current.next;
			builder.append(current.string);
			builder.append("->");
		} 
		builder.append("END OF LIST");
		
		return builder.toString();
	}
	
	
	
	private void NodeNullCheck(ListNode node) {
		if (this.IsNull(node)) {
			this.ThrowException("Node is a NULL");
		}
	}

	private void IntNullCheck(int integer) {
		if (this.IsNull(integer)) {
			this.ThrowException("Int is a NULL");
		}
	}

	private <T> boolean IsNull(T data) {
		if (data == null) {
			return true;
		}
		return false;
	}

	private void ThrowException(String string) {
		try {
			throw new Exception(string);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
