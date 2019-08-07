package stackqueue;

import fundamental.structure.Stack;

public class SortStack {
	private Stack<Integer> sorted_stack;
	
	
	
	public SortStack() {
		this.sorted_stack = new Stack<Integer>();
	}
	
	
	
	public Stack<Integer> sortAscending(Stack<Integer> stack) {
		this.sorted_stack = new Stack<Integer>();
		
		while (!stack.isEmpty()) {
			this.sorted_stack.push(this.popMax(stack));;
		}
		
		return this.sorted_stack;
	}
	
	public Integer popMax(Stack<Integer> stack) {
		Integer data = stack.pop();
		
		if (stack.isEmpty()) {
			return data;
		}
		
		Integer max = this.popMax(stack);
		if (data > max) {
			stack.push(max);
			return data;
		} else {
			stack.push(data);
			return max;
		}
	}
}
