package stackqueue;

public class NodeMin {
	public int data;
	public NodeMin next;
	public NodeMin min;
	
	
	
	public NodeMin (int data) {
		this.data = data;
		this.min = this;
	}
}
