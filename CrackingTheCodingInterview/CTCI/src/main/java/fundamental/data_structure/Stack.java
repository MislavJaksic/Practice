package fundamental.data_structure;

import list.Node;

public class Stack {
	public static int sentinel = 0;
	
	private Node head;
	
	
	
	public Stack() {
		this.head = null;
	}
	
	
	
	public void push(int data) {
		Node new_node = new Node(data);
				
		if (!this.isEmpty()) {
			new_node.next = this.head;
		}
		
		this.head = new_node;
	}
	
	public int pop() {
		int value = Stack.sentinel;
		
		if (!this.isEmpty()) {
			value = head.data;
			this.head = head.next;
		}
		
		return value;
	}
	
	public int peek() {
		int value = Stack.sentinel;
		
		if (!this.isEmpty()) {
			value = this.head.data;
		}
		
		return value;
	}
	
	
	
	public boolean isEmpty() {
		return (this.head == null);
	}
}
