package fundamental.algorithm.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import fundamental.structure.tree.GraphNode;

public class GraphOperatorTests {
	@Nested
	class DFSDiamondTests {
		GraphNode<Integer> head;
		GraphNode<Integer> two;
		GraphNode<Integer> three;
		GraphNode<Integer> four;
		
		@BeforeEach
		public void createDiamondGraph() {
			head = new GraphNode<Integer>(1);
			two = new GraphNode<Integer>(2);
			three = new GraphNode<Integer>(3);
			four = new GraphNode<Integer>(4);
			
			head.addChild(two).addChild(three);
			two.addChild(head).addChild(four);
			three.addChild(head).addChild(four);
			four.addChild(two).addChild(three);
		}
		
		@Test
		public void falseTest() {
			int search_term = 5;

			boolean expected = false;

			assertEquals(expected, GraphOperator.DFS(head, search_term));
		}
		
		@Test
		public void trueTest() {
			int search_term = 3;

			boolean expected = true;

			assertEquals(expected, GraphOperator.DFS(head, search_term));
		}
	}
}
