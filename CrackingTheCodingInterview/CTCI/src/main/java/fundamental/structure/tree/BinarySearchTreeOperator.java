package fundamental.structure.tree;

import java.util.List;

/*
 * All left children are smaller and all right children are bigger then the root of the subtree.
 */
public class BinarySearchTreeOperator {
	public static BinaryNode<Integer> add(BinaryNode<Integer> root, BinaryNode<Integer> node) {
		if (root == null) {
			return node;
		} else {
			if (root.data > node.data) {
				root.left = BinarySearchTreeOperator.add(root.left, node);
			} else {
				root.right = BinarySearchTreeOperator.add(root.right, node);
			}
		}
		return root;
	}
	
	public static List<Integer> getInOrder(BinaryNode<Integer> root, List<Integer> list) {
		if (root != null) {
			list = BinarySearchTreeOperator.getInOrder(root.left, list);
			list.add(root.data);
			list = BinarySearchTreeOperator.getInOrder(root.right, list);
		}
		return list;
	}
	
	public static List<Integer> getPreOrder(BinaryNode<Integer> root, List<Integer> list) {
		if (root != null) {
			list.add(root.data);
			list = BinarySearchTreeOperator.getPreOrder(root.left, list);
			list = BinarySearchTreeOperator.getPreOrder(root.right, list);
		}
		return list;
	}
	
	public static List<Integer> getPostOrder(BinaryNode<Integer> root, List<Integer> list) {
		if (root != null) {
			list = BinarySearchTreeOperator.getPostOrder(root.left, list);
			list = BinarySearchTreeOperator.getPostOrder(root.right, list);
			list.add(root.data);
		}
		return list;
	}
}
