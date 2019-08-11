package fundamental.algorithm.graphtree;

import java.util.List;

import fundamental.structure.graphtree.BinaryNode;

/*
 * Left children are smaller and right children are bigger then the root of the subtree.
 */
public class BSTOperator {
	public static <T extends Comparable<T>> BinaryNode<T> add(BinaryNode<T> root, BinaryNode<T> node) {
		if (root == null) {
			return node;
		} else {
			if (root.data.compareTo(node.data) == 1) {
				root.left = BSTOperator.add(root.left, node);
			} else {
				root.right = BSTOperator.add(root.right, node);
			}
		}
		
		return root;
	}
	
	
	
	public static <T extends Comparable<T>> List<T> getInOrder(BinaryNode<T> root, List<T> list) {
		if (root != null) {
			list = BSTOperator.getInOrder(root.left, list);
			list.add(root.data);
			list = BSTOperator.getInOrder(root.right, list);
		}
		
		return list;
	}
	
	public static <T extends Comparable<T>> List<T> getPreOrder(BinaryNode<T> root, List<T> list) {
		if (root != null) {
			list.add(root.data);
			list = BSTOperator.getPreOrder(root.left, list);
			list = BSTOperator.getPreOrder(root.right, list);
		}
		
		return list;
	}
	
	public static <T extends Comparable<T>> List<T> getPostOrder(BinaryNode<T> root, List<T> list) {
		if (root != null) {
			list = BSTOperator.getPostOrder(root.left, list);
			list = BSTOperator.getPostOrder(root.right, list);
			list.add(root.data);
		}
		
		return list;
	}
}
