package fundamental.structure.graphtree;

public class BinaryHeapNode<T> {
	public T data;
	public BinaryHeapNode<T> parent;
	public BinaryHeapNode<T> left;
	public BinaryHeapNode<T> right;
	
	
	
	public BinaryHeapNode(T data) {
		this.data = data;
		this.parent = null;
		this.left = null;
		this.right = null;
	}
}
