package fundamental.structure.tree;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import fundamental.structure.tree.BinaryNode;
import fundamental.structure.tree.BinarySearchTreeOperator;

public class BinarySearchTreeOperatorTest {
	@Nested
	class AddNodesTests {
		BinaryNode<Integer> root = new BinaryNode<Integer>(6);
		
		@BeforeEach
		public void AddNineNodes() {
			int[] insertion_data = {2,10,0,4,8,12,3,9,13};
			BinaryNode<Integer> new_node;
			
			for (int i = 0; i < insertion_data.length; i++) {
				new_node = new BinaryNode<Integer>(insertion_data[i]);
				root = BinarySearchTreeOperator.add(root, new_node);
			}
		}
		
		@Test
		public void TestInOrder() {
			int[] in_order_data = {0,2,3,4,6,8,9,10,12,13};
			List<Integer> expected = new ArrayList<Integer>();
			
			for (int i = 0; i < in_order_data.length; i++) {
				expected.add(in_order_data[i]);
			}
			
			List<Integer> actual = new ArrayList<Integer>();
			
			assertArrayEquals(expected.toArray(), BinarySearchTreeOperator.getInOrder(root, actual).toArray());
		}
		
		@Test
		public void TestPreOrder() {
			int[] in_order_data = {6,2,0,4,3,10,8,9,12,13};
			List<Integer> expected = new ArrayList<Integer>();
			
			for (int i = 0; i < in_order_data.length; i++) {
				expected.add(in_order_data[i]);
			}
			
			List<Integer> actual = new ArrayList<Integer>();
			
			assertArrayEquals(expected.toArray(), BinarySearchTreeOperator.getPreOrder(root, actual).toArray());
		}
		
		@Test
		public void TestPostOrder() {
			int[] in_order_data = {0,3,4,2,9,8,13,12,10,6};
			List<Integer> expected = new ArrayList<Integer>();
			
			for (int i = 0; i < in_order_data.length; i++) {
				expected.add(in_order_data[i]);
			}
			
			List<Integer> actual = new ArrayList<Integer>();
			
			assertArrayEquals(expected.toArray(), BinarySearchTreeOperator.getPostOrder(root, actual).toArray());
		}
	}
}
