package fundamental.algorithm.graph;

import java.util.ArrayList;

import fundamental.structure.tree.GraphNode;

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
}
