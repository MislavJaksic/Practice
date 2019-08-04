package stackqueue;

import fundamental.data_structure.Stack;

public class QueueViaStacks {
	private Stack new_stack;
	private Stack old_stack;
	
	
	
	public QueueViaStacks() {
		this.new_stack = new Stack();
		this.old_stack = new Stack();
	}
	
	public void add(int data) {
		this.new_stack.push(data);
	}
	
	public int remove() {
		if (this.old_stack.isEmpty()) {
			this.transfer();
		}
		
		return this.old_stack.pop();
	}
	
	public int peek() {
		if (this.old_stack.isEmpty()) {
			this.transfer();
		}
		
		return this.old_stack.peek();
	}
	
	public boolean isEmpty() {
		return (this.new_stack.isEmpty() && this.old_stack.isEmpty());
	}
	
	
	
	private void transfer() {
		while (!this.new_stack.isEmpty()) {
			this.old_stack.push(this.new_stack.pop());
		}
	}
}
