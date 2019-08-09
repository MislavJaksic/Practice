package fundamental.structure.tree;

public class BinaryNode<T> {
	public T data;
	public BinaryNode<T> left = null;
	public BinaryNode<T> right = null;
	
	
	
	public BinaryNode(T data) {
		this.data = data;
	}
}
