package stackqueue;

import fundamental.structure.Stack;

public class QueueViaStacks<T> {
	private Stack<T> new_stack;
	private Stack<T> old_stack;
	
	
	
	public QueueViaStacks() {
		this.new_stack = new Stack<T>();
		this.old_stack = new Stack<T>();
	}
	
	public void add(T data) {
		this.new_stack.push(data);
	}
	
	public T remove() {
		if (this.old_stack.isEmpty()) {
			this.transfer();
		}
		
		return this.old_stack.pop();
	}
	
	public T peek() {
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
