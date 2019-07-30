package fundamental.data_structure;

import list.Node;

public class Queue {
	public static int sentinel = 0;

	public Node head;
	public Node tail;

	
	
	public Queue() {
		this.head = null;
		this.tail = null;
	}

	
	
	public void add(int data) {
		Node new_node = new Node(data);

		if (this.isEmpty()) {
			this.head = new_node;
			this.tail = new_node;
		} else {
			this.tail.next = new_node;
			this.tail = this.tail.next;
			
		}
	}

	public int remove() {
		int value = Queue.sentinel;

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

	public int peek() {
		int value = Queue.sentinel;

		if (!this.isEmpty()) {
			value = this.head.data;
		}

		return value;
	}

	public boolean isEmpty() {
		return (this.head == null);
	}
}
