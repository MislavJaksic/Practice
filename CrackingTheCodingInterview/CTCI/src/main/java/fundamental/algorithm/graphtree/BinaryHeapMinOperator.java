package fundamental.algorithm.graphtree;

import fundamental.structure.graphtree.BinaryHeapNode;
import fundamental.structure.stackqueue.Queue;

public class BinaryHeapMinOperator {
	public static <T> BinaryHeapNode<T> insert(BinaryHeapNode<T> root, T element) {
		Queue<BinaryHeapNode<T>> q = new Queue<BinaryHeapNode<T>>();
		BinaryHeapNode<T> new_node = new BinaryHeapNode<T>(element);

		q.add(root);

		BinaryHeapNode<T> node;
		while (!q.isEmpty()) {
			node = q.remove();
			if (node.left == null) {
				node.left = new_node;
				return root;
			} else if (node.right == null) {
				node.right = new_node;
				return root;
			} else {
				q.add(node.left);
				q.add(node.right);
			}
		}

		return new_node;
	}

//	public static <T> BinaryNode<T> extractMin(BinaryNode<T> root) {
//
//	}
}
