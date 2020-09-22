package fundamental.algorithm.graphtree;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fundamental.structure.graphtree.BinaryNode;

public class BSTOperatorTest {
	BinaryNode<Integer> root = new BinaryNode<Integer>(6);

	@BeforeEach
	public void createBST() {
		Integer[] numbers = {2,10,0,4,8,12,3,9,13};

		BinaryNode<Integer> new_node;
		for (Integer number : numbers) {
			new_node = new BinaryNode<Integer>(number);
			root = BSTOperator.add(root, new_node);
		}
	}

	@Test
	public void TestInOrder() {
		Integer[] expected = {0,2,3,4,6,8,9,10,12,13};

		List<Integer> actual = new ArrayList<Integer>();
		assertArrayEquals(expected, BSTOperator.getInOrder(root, actual).toArray());
	}

	@Test
	public void TestPreOrder() {
		Integer[] expected = {6,2,0,4,3,10,8,9,12,13};

		List<Integer> actual = new ArrayList<Integer>();
		assertArrayEquals(expected, BSTOperator.getPreOrder(root, actual).toArray());
	}

	@Test
	public void TestPostOrder() {
		Integer[] expected = {0,3,4,2,9,8,13,12,10,6};

		List<Integer> actual = new ArrayList<Integer>();
		assertArrayEquals(expected, BSTOperator.getPostOrder(root, actual).toArray());
	}
}
