package fundamental.data_structure;

public class Stack {
	private int capacity;
	private int[] array;
	
	private int head;
	
	
	
	public Stack(int capacity) {
		this.capacity = capacity;
		this.array = new int[this.capacity];
		
		this.head = 0;
	}
	
	
	
	public void push(int data) {
		if (!this.isFull()) {
			this.array[this.head] = data;
			this.head++;
		}
	}
	
	public int pop() {
		if (!this.isEmpty()) {
			this.head--;
			return this.array[this.head];
		}
		return 0;
	}
	
	
	
	public boolean isFull() {
		if (this.head == capacity) {
			return true;
		}
		return false;
	}
	
	public boolean isEmpty() {
		if (this.head == 0) {
			return true;
		}
		return false;
	}
}
