package stackqueue;

import fundamental.data_structure.Stack;

public class SetOfStacks {
	private Stack[] stacks;
	
	private int set_size;
	private int threshold;
	
	
	
	public SetOfStacks(int set_size, int threshold) {
		if (set_size < 1) {
			set_size = 1;
		}
		if (threshold < 1) {
			threshold = 1;
		}
		this.set_size = set_size;
		this.threshold = threshold;
		
		this.stacks = new Stack[this.set_size];
		for (int i = 0; i < this.set_size; i++) {
			this.stacks[i] = new Stack();
		}
		
		
	}
	
	
	
	public void push(int data) {
		int i = 0;
		while (!(stacks[i].size() < this.threshold) && (i < (this.set_size - 1))) {
			i++;
		}
		
		Stack stack = stacks[i];
		stack.push(data);
	}
	
	public int pop() {
		int i = this.set_size - 1;
		while (stacks[i].isEmpty() && (i > 0)) {
			i--;
		}
		
		Stack stack = this.stacks[i];
		return stack.pop();
	}
	
	public int peek() {
		int i = this.set_size - 1;
		while (stacks[i].isEmpty() && (i > 0)) {
			i--;
		}
		
		Stack stack = this.stacks[i];
		return stack.peek();
	}
	
	
	
	public boolean isEmpty() {
		boolean isEmpty = true;
		for (Stack stack : stacks) {
			if (!stack.isEmpty()) {
				isEmpty = false;
				break;
			}
		}
		
		return isEmpty;
	}
}
