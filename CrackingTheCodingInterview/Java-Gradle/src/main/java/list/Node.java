package list;

public class Node {
	public int data;
	public Node next;
	
	
	
	public Node(int data) {
		this.data = data;
		this.next = null;
	}
	
	
	
	public Node Add(int data) {
		this.next = new Node(data);
		return this.next;
	}
}
