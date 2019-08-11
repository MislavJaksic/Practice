package fundamental.structure.tree;

import java.util.List;

/*
 * All left children are smaller and all right children are bigger then the root of the subtree.
 */
public class BSTOperator {
	public static BinaryNode<Integer> add(BinaryNode<Integer> root, BinaryNode<Integer> node) {
		if (root == null) {
			return node;
		} else {
			if (root.data > node.data) {
				root.left = BSTOperator.add(root.left, node);
			} else {
				root.right = BSTOperator.add(root.right, node);
			}
		}
		return root;
	}
	
	public static List<Integer> getInOrder(BinaryNode<Integer> root, List<Integer> list) {
		if (root != null) {
			list = BSTOperator.getInOrder(root.left, list);
			list.add(root.data);
			list = BSTOperator.getInOrder(root.right, list);
		}
		return list;
	}
	
	public static List<Integer> getPreOrder(BinaryNode<Integer> root, List<Integer> list) {
		if (root != null) {
			list.add(root.data);
			list = BSTOperator.getPreOrder(root.left, list);
			list = BSTOperator.getPreOrder(root.right, list);
		}
		return list;
	}
	
	public static List<Integer> getPostOrder(BinaryNode<Integer> root, List<Integer> list) {
		if (root != null) {
			list = BSTOperator.getPostOrder(root.left, list);
			list = BSTOperator.getPostOrder(root.right, list);
			list.add(root.data);
		}
		return list;
	}
}
