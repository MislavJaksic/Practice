package fundamental.algorithm.graphtree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import fundamental.structure.graphtree.GraphNode;

public class GraphOperatorTests {
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
	
	@Nested
	class DFSDiamondTests {
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
	
	@Nested
	class BFSDiamondTests {
		@Test
		public void falseTest() {
			int search_term = 5;

			boolean expected = false;

			assertEquals(expected, GraphOperator.BFS(head, search_term));
		}
		
		@Test
		public void trueTest() {
			int search_term = 3;

			boolean expected = true;

			assertEquals(expected, GraphOperator.BFS(head, search_term));
		}
	}
}
