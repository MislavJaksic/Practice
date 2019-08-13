package fundamental.structure.graphtree;

import java.util.ArrayList;

public class GraphNode<T> {
	public T data;
	public ArrayList<GraphNode<T>> children;
	
	
	
	public GraphNode(T data) {
		this.data = data;
		this.children = new ArrayList<GraphNode<T>>();
	}



	public GraphNode<T> addChild(GraphNode<T> child) {
		this.children.add(child);
		return this;
	}
}
