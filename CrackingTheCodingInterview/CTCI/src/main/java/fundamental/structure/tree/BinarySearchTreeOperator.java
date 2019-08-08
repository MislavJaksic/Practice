package fundamental.structure.tree;

import java.util.List;

/*
 * All left children are smaller and all right children are bigger then the root of the subtree.
 */
public class BinarySearchTreeOperator {
	public static BinaryNode Add(BinaryNode root, BinaryNode node) {
		if (root == null) {
			return node;
		} else {
			if (root.data > node.data) {
				root.left = BinarySearchTreeOperator.Add(root.left, node);
			} else {
				root.right = BinarySearchTreeOperator.Add(root.right, node);
			}
		}
		return root;
	}
	
	public static List<Integer> GetInOrder(BinaryNode root, List<Integer> list) {
		if (root != null) {
			list = BinarySearchTreeOperator.GetInOrder(root.left, list);
			list.add(root.data);
			list = BinarySearchTreeOperator.GetInOrder(root.right, list);
		}
		return list;
	}
	
	public static List<Integer> GetPreOrder(BinaryNode root, List<Integer> list) {
		if (root != null) {
			list.add(root.data);
			list = BinarySearchTreeOperator.GetPreOrder(root.left, list);
			list = BinarySearchTreeOperator.GetPreOrder(root.right, list);
		}
		return list;
	}
	
	public static List<Integer> GetPostOrder(BinaryNode root, List<Integer> list) {
		if (root != null) {
			list = BinarySearchTreeOperator.GetPostOrder(root.left, list);
			list = BinarySearchTreeOperator.GetPostOrder(root.right, list);
			list.add(root.data);
		}
		return list;
	}
}
