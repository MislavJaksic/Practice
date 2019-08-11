package fundamental.algorithm.graphtree;

import java.util.ArrayList;

import fundamental.structure.graphtree.GraphNode;
import fundamental.structure.stackqueue.Queue;

public class GraphOperator {
	public static <T> boolean DFS(GraphNode<T> head, T search_term) {
		ArrayList<GraphNode<T>> visited = new ArrayList<GraphNode<T>>();
		
		return GraphOperator.DFSExecute(head, search_term, visited);
	}
	
	private static <T> boolean DFSExecute(GraphNode<T> head, T search_term, ArrayList<GraphNode<T>> visited) {
		if (head.data == search_term) {
			return true;
		}
		
		visited.add(head);
		for (GraphNode<T> node : head.children) {
			if (!visited.contains(node)) {
				if (GraphOperator.DFSExecute(node, search_term, visited)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	
	public static <T> boolean BFS(GraphNode<T> head, T search_term) {
		Queue<GraphNode<T>> q = new Queue<GraphNode<T>>();
		ArrayList<GraphNode<T>> visited = new ArrayList<GraphNode<T>>();
		
		q.add(head);
		
		GraphNode<T> node;
		while (!q.isEmpty()) {
			node = q.remove();
			if (node.data == search_term) {
				return true;
			}
			
			visited.add(node);
			for (GraphNode<T> child : node.children) {
				if (!visited.contains(child)) {
					q.add(child);
				}
			}
		}
		
		return false;
	}
}
