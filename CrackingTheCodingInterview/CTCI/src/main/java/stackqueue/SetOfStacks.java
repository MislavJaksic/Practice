package stackqueue;

import java.lang.reflect.Array;

import fundamental.data_structure.Stack;

public class SetOfStacks<T> {
	public T sentinel = null;
	
	private Stack<T>[] stacks;
	
	private int set_size;
	private int threshold;
	
	
	
	public SetOfStacks(Class<T> class_type, int set_size, int threshold) {
		if (set_size < 1) {
			set_size = 1;
		}
		if (threshold < 1) {
			threshold = 1;
		}
		this.set_size = set_size;
		this.threshold = threshold;
		
		@SuppressWarnings("unchecked")
        final Stack<T>[] stacks = (Stack<T>[]) Array.newInstance(class_type, set_size);
		this.stacks = stacks;
		for (int i = 0; i < this.set_size; i++) {
			this.stacks[i] = new Stack<T>();
		}
		
		
	}
	
	
	
	public void push(T data) {
		int i = 0;
		while (!(stacks[i].size() < this.threshold) && (i < (this.set_size - 1))) {
			i++;
		}
		
		Stack<T> stack = stacks[i];
		stack.push(data);
	}
	
	public T pop() {
		int i = this.set_size - 1;
		while (stacks[i].isEmpty() && (i > 0)) {
			i--;
		}
		
		Stack<T> stack = this.stacks[i];
		return stack.pop();
	}
	
	public T peek() {
		int i = this.set_size - 1;
		while (stacks[i].isEmpty() && (i > 0)) {
			i--;
		}
		
		Stack<T> stack = this.stacks[i];
		return stack.peek();
	}
	
	
	
	public boolean isEmpty() {
		boolean isEmpty = true;
		for (Stack<T> stack : stacks) {
			if (!stack.isEmpty()) {
				isEmpty = false;
				break;
			}
		}
		
		return isEmpty;
	}
}
