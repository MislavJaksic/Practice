package fundamental.data_structure;

import list.Node;

public class Queue<T> {
	public T sentinel = null;
	
	public Node<T> head;
	public Node<T> tail;

	
	
	public Queue() {
		this.head = null;
		this.tail = null;
	}

	
	
	public void add(T data) {
		Node<T> new_node = new Node<T>(data);

		if (this.isEmpty()) {
			this.head = new_node;
			this.tail = new_node;
		} else {
			this.tail.next = new_node;
			this.tail = this.tail.next;
			
		}
	}

	public T remove() {
		T value = this.sentinel;

		if (!this.isEmpty()) {
			if (this.head.next == null) {
				value = this.head.data;
				this.head = null;
				this.tail = null;
			} else {
				value = this.head.data;
				this.head = this.head.next;
			}
		}

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
}
