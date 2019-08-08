package stackqueue.min;

import fundamental.structure.Stack;

public class StackMin extends Stack<NodeMin> {
	public int sentinel = Integer.MAX_VALUE;
	
	
	
	public void push(int data) {
		int min = Math.min(this.min(), data);
		
		NodeMin new_node = new NodeMin(data, min);
		
		this.push(new_node);
	}
	
	public int min() {
		int value = this.sentinel;
		
		if (!this.isEmpty()) {
			value = this.peek().min;
		}
		
		return value;
	}
}
