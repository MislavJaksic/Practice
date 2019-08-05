package list;

public class Node<T> {
	public T data;
	public Node<T> next;
	
	
	
	public Node(T data) {
		this.data = data;
		this.next = null;
	}
	
	
	
	public Node<T> add(T data) {
		this.next = new Node<T>(data);
		return this.next;
	}
}
