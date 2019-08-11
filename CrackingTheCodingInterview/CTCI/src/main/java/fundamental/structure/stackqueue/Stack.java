package fundamental.structure.stackqueue;

import list.Node;

public class Stack<T> {
	public T sentinel = null;
	
	private int size;
	
	private Node<T> head;
	
	
	
	public Stack() {
		this.size = 0;
		this.head = null;
	}
	
	
	
	public void push(T data) {
		Node<T> new_node = new Node<T>(data);
				
		if (!this.isEmpty()) {
			new_node.next = this.head;
		}
		
		this.size++;
		
		this.head = new_node;
	}
	
	public T pop() {
		T value = this.sentinel;
		
		if (!this.isEmpty()) {
			value = head.data;
			this.head = head.next;
		}
		
		this.size--;
		
		return value;
	}
	
	public T peek() {
		T value = this.sentinel;
		
		if (!this.isEmpty()) {
			value = this.head.data;
		}
		
		return value;
	}
	
	
	
	public boolean isEmpty() {
		return (this.head == null);
	}
	
	public int size() {
		return this.size;
	}
}
