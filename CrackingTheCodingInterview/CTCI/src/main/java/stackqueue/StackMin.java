package stackqueue;

public class StackMin {
public static int sentinel = 0;
	
	private NodeMin head;
	
	
	
	public StackMin() {
		this.head = null;
	}
	
	
	
	public void push(int data) {
		NodeMin new_node = new NodeMin(data);
				
		if (!this.isEmpty()) {
			new_node.next = this.head;
			
			if (this.head.min.data < new_node.data) {
				new_node.min = this.head.min;
			}
		}
		
		this.head = new_node;
	}
	
	public int pop() {
		int value = StackMin.sentinel;
		
		if (!this.isEmpty()) {
			value = head.data;
			this.head = head.next;
		}
		
		return value;
	}
	
	public int peek() {
		int value = StackMin.sentinel;
		
		if (!this.isEmpty()) {
			value = this.head.data;
		}
		
		return value;
	}
	
	public int min() {
		int value = StackMin.sentinel;
		
		if (!this.isEmpty()) {
			value = this.head.min.data;
		}
		
		return value;
	}
	
	
	
	public boolean isEmpty() {
		return (this.head == null);
	}
}
