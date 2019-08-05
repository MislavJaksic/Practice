package list;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import list.ListProblems;
import list.Node;

public class ListProblemTest {
	@Nested
	class ListCompareTests {
		@Test
		public void bothNullTest() {
			Node<Integer> one = null;
			Node<Integer> two = null;
			
			boolean expected = true;
			
			boolean actual = ListProblems.compareLists(one, two);

			assertEquals(expected, actual);
		}
		
		@Test
		public void oneNullTest() {
			Node<Integer> one = null;
			Node<Integer> two = new Node<Integer>(1);
			
			boolean expected = false;
			
			boolean actual = ListProblems.compareLists(one, two);

			assertEquals(expected, actual);
		}
		
		@Test
		public void twoNullTest() {
			Node<Integer> one = new Node<Integer>(1);
			Node<Integer> two = null;
			
			boolean expected = false;
			
			boolean actual = ListProblems.compareLists(one, two);

			assertEquals(expected, actual);
		}
		
		@Test
		public void shortListEqualTest() {
			Node<Integer> one = new Node<Integer>(1);
			Node<Integer> two = new Node<Integer>(1);
			
			boolean expected = true;
			
			boolean actual = ListProblems.compareLists(one, two);

			assertEquals(expected, actual);
		}
		
		@Test
		public void shortListDifferentTest() {
			Node<Integer> one = new Node<Integer>(1);
			Node<Integer> two = new Node<Integer>(2);
			
			boolean expected = false;
			
			boolean actual = ListProblems.compareLists(one, two);

			assertEquals(expected, actual);
		}

		@Test
		public void oneLongerTest() {
			Node<Integer> one = new Node<Integer>(1);
			Node<Integer> two = new Node<Integer>(1);
			one.next = new Node<Integer>(2);
			
			boolean expected = false;
			
			boolean actual = ListProblems.compareLists(one, two);

			assertEquals(expected, actual);
		}
		
		@Test
		public void twoLongerTest() {
			Node<Integer> one = new Node<Integer>(1);
			Node<Integer> two = new Node<Integer>(1);
			two.next = new Node<Integer>(2);
			
			boolean expected = false;
			
			boolean actual = ListProblems.compareLists(one, two);

			assertEquals(expected, actual);
		}
		
		@Test
		public void longListEqualTest() {
			Node<Integer> one = new Node<Integer>(1);
			Node<Integer> two = new Node<Integer>(1);
			one.next = new Node<Integer>(2);
			two.next = new Node<Integer>(2);
			
			boolean expected = true;
			
			boolean actual = ListProblems.compareLists(one, two);

			assertEquals(expected, actual);
		}
		
		@Test
		public void longListDifferentTest() {
			Node<Integer> one = new Node<Integer>(1);
			Node<Integer> two = new Node<Integer>(1);
			one.next = new Node<Integer>(2);
			two.next = new Node<Integer>(88);
			
			boolean expected = false;
			
			boolean actual = ListProblems.compareLists(one, two);

			assertEquals(expected, actual);
		}
	}
	
	@Nested
	class StringToListTests {
		@Test
		public void nullListTest() {
			Node<Integer> one = null;
			
			String expected = "->null";
			
			String actual = ListProblems.listToString(one);

			assertEquals(expected, actual);
		}
		
		@Test
		public void oneListTest() {
			Node<Integer> one = new Node<Integer>(1);
			
			String expected = "->1->null";
			
			String actual = ListProblems.listToString(one);

			assertEquals(expected, actual);
		}
		
		@Test
		public void twoListTest() {
			Node<Integer> one = new Node<Integer>(1);
			one.next = new Node<Integer>(2);
			
			String expected = "->1->2->null";
			
			String actual = ListProblems.listToString(one);

			assertEquals(expected, actual);
		}
		
		@Test
		public void threeListTest() {
			Node<Integer> one = new Node<Integer>(1);
			one.next = new Node<Integer>(2);
			one.next.next = new Node<Integer>(3);
			
			String expected = "->1->2->3->null";
			
			String actual = ListProblems.listToString(one);

			assertEquals(expected, actual);
		}
	}
	
	@Nested
	class RemoveDuplicatesTests {
		@Test
		public void nullTest() {
			Node<Integer> one = null;
			
			Node<Integer> expected = null;
			
			Node<Integer> actual = ListProblems.removeDuplicates(one);

			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
		
		@Test
		public void noDuplicatesShortTest() {
			Node<Integer> one = new Node<Integer>(1);
			
			Node<Integer> expected = new Node<Integer>(1);
			
			Node<Integer> actual = ListProblems.removeDuplicates(one);

			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
		
		@Test
		public void noDuplicatesLongTest() {
			Node<Integer> one = new Node<Integer>(1);
			one.next = new Node<Integer>(2);
			one.next.next = new Node<Integer>(3);
			
			Node<Integer> expected = new Node<Integer>(1);
			expected.next = new Node<Integer>(2);
			expected.next.next = new Node<Integer>(3);
			
			Node<Integer> actual = ListProblems.removeDuplicates(one);

			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
		
		@Test
		public void duplicatesShortTest() {
			Node<Integer> one = new Node<Integer>(1);
			one.next = new Node<Integer>(1);
			
			Node<Integer> expected = new Node<Integer>(1);
			
			Node<Integer> actual = ListProblems.removeDuplicates(one);

			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
		
		@Test
		public void duplicatesLongTest() {
			Node<Integer> one = new Node<Integer>(1);
			one.add(1).add(1).add(1);
			
			Node<Integer> expected = new Node<Integer>(1);
			
			Node<Integer> actual = ListProblems.removeDuplicates(one);

			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
		
		@Test
		public void manyDuplicatesLongTest() {
			Node<Integer> one = new Node<Integer>(1);
			one.add(2).add(3).add(1).add(2).add(3);
			
			Node<Integer> expected = new Node<Integer>(1);
			expected.next = new Node<Integer>(2);
			expected.next.next = new Node<Integer>(3);
			
			Node<Integer> actual = ListProblems.removeDuplicates(one);

			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
	}
	
	@Nested
	class KthToLastTests {
		@Test
		public void nullTest() {
			Node<Integer> one = null;
			int k = 0;
			
			Node<Integer> expected = null;
			
			Node<Integer> actual = ListProblems.kthToLast(one, k);

			assertEquals(expected, actual);
		}
		
		@Test
		public void kTooLargeTest() {
			Node<Integer> one = new Node<Integer>(1);
			one.next = new Node<Integer>(2);
			one.next.next = new Node<Integer>(3);
			one.next.next.next = new Node<Integer>(4);
			int k = 4;
			
			Node<Integer> expected = null;
			
			Node<Integer> actual = ListProblems.kthToLast(one, k);

			assertEquals(expected, actual);
		}
		
		@Test
		public void lastTest() {
			Node<Integer> one = new Node<Integer>(1);
			one.next = new Node<Integer>(2);
			one.next.next = new Node<Integer>(3);
			one.next.next.next = new Node<Integer>(4);
			int k = 0;
			
			Node<Integer> expected = new Node<Integer>(4);
			
			Node<Integer> actual = ListProblems.kthToLast(one, k);

			assertEquals(expected.data, actual.data);
		}
		
		@Test
		public void firstTest() {
			Node<Integer> one = new Node<Integer>(1);
			one.next = new Node<Integer>(2);
			one.next.next = new Node<Integer>(3);
			one.next.next.next = new Node<Integer>(4);
			int k = 3;
			
			Node<Integer> expected = new Node<Integer>(1);
			
			Node<Integer> actual = ListProblems.kthToLast(one, k);

			assertEquals(expected.data, actual.data);
		}
		
		@Test
		public void penultimateTest() {
			Node<Integer> one = new Node<Integer>(1);
			one.next = new Node<Integer>(2);
			one.next.next = new Node<Integer>(3);
			one.next.next.next = new Node<Integer>(4);
			int k = 1;
			
			Node<Integer> expected = new Node<Integer>(3);
			
			Node<Integer> actual = ListProblems.kthToLast(one, k);

			assertEquals(expected.data, actual.data);
		}
	}
	
	@Nested
	class partitionTests {
		@Test
		public void nullTest() {
			Node<Integer> one = null;
			int data = 5;
			
			Node<Integer> expected = null;
			
			Node<Integer> actual = ListProblems.partition(one, data);

			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
		
		@Test
		public void oneTest() {
			Node<Integer> one = new Node<Integer>(5);
			int data = 5;
			
			Node<Integer> expected = new Node<Integer>(5);
			
			Node<Integer> actual = ListProblems.partition(one, data);

			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
		
		@Test
		public void uniformSmallTest() {
			Node<Integer> one = new Node<Integer>(1);
			one.add(2).add(3);
			
			int data = 3;
			
			Node<Integer> expected = new Node<Integer>(1);
			expected.add(2).add(3);
			
			Node<Integer> actual = ListProblems.partition(one, data);

			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
		
		@Test
		public void uniformBigTest() {
			Node<Integer> one = new Node<Integer>(3);
			one.add(4).add(5);
			
			int data = 3;
			
			Node<Integer> expected = new Node<Integer>(3);
			expected.add(4).add(5);
			
			Node<Integer> actual = ListProblems.partition(one, data);

			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
		
		@Test
		public void unsortedTest() {
			Node<Integer> one = new Node<Integer>(4);
			one.add(1).add(3).add(3).add(2).add(2);
			
			int data = 3;
			
			Node<Integer> expected = new Node<Integer>(1);
			expected.add(2).add(2).add(3).add(4).add(3);
			
			Node<Integer> actual = ListProblems.partition(one, data);
			
			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
	}
	
	@Nested
	class SumListsTests {
		@Test
		public void bothNullTest() {
			Node<Integer> one = null;
			Node<Integer> two = null;
			
			Node<Integer> expected = null;
			
			Node<Integer> actual = ListProblems.sumReverse(one, two);

			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
		
		@Test
		public void oneNullTest() {
			Node<Integer> one = null;
			Node<Integer> two = new Node<Integer>(1);
			
			Node<Integer> expected = new Node<Integer>(1);
			
			Node<Integer> actual = ListProblems.sumReverse(one, two);

			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
		
		@Test
		public void twoNullTest() {
			Node<Integer> one = new Node<Integer>(1);
			Node<Integer> two = null;
			
			Node<Integer> expected = new Node<Integer>(1);;
			
			Node<Integer> actual = ListProblems.sumReverse(one, two);

			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
		
		@Test
		public void shortListSumTest() {
			Node<Integer> one = new Node<Integer>(1);
			Node<Integer> two = new Node<Integer>(1);
			
			Node<Integer> expected = new Node<Integer>(2);;
			
			Node<Integer> actual = ListProblems.sumReverse(one, two);

			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
		
		@Test
		public void endOverflowTest() {
			Node<Integer> one = new Node<Integer>(9);
			Node<Integer> two = new Node<Integer>(9);
			
			Node<Integer> expected = new Node<Integer>(8);
			expected.add(1);
			
			Node<Integer> actual = ListProblems.sumReverse(one, two);

			assertEquals(true, ListProblems.compareLists(expected, actual));
		}

		@Test
		public void oneLongerTest() {
			Node<Integer> one = new Node<Integer>(0);
			Node<Integer> two = new Node<Integer>(1);
			one.add(1);
			
			Node<Integer> expected = new Node<Integer>(1);
			expected.add(1);
			
			Node<Integer> actual = ListProblems.sumReverse(one, two);
			
			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
		
		@Test
		public void twoLongerTest() {
			Node<Integer> one = new Node<Integer>(1);
			Node<Integer> two = new Node<Integer>(0);
			two.add(1);
			
			Node<Integer> expected = new Node<Integer>(1);
			expected.add(1);
			
			Node<Integer> actual = ListProblems.sumReverse(one, two);

			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
		
		@Test
		public void longListDifferentTest() {
			Node<Integer> one = new Node<Integer>(9);
			Node<Integer> two = new Node<Integer>(1);
			one.add(9).add(9).add(9);
			
			Node<Integer> expected = new Node<Integer>(0);
			expected.add(0).add(0).add(0).add(1);
			
			Node<Integer> actual = ListProblems.sumReverse(one, two);

			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
	}
	
	@Nested
	class ReverseListTests {
		@Test
		public void nullTest() {
			Node<Integer> head = null;
			
			Node<Integer> expected = null;
			
			Node<Integer> actual = ListProblems.reverse(head);

			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
		
		@Test
		public void oneNodeTest() {
			Node<Integer> head = new Node<Integer>(1);
			
			Node<Integer> expected = new Node<Integer>(1);
			
			Node<Integer> actual = ListProblems.reverse(head);

			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
		
		@Test
		public void manyNodeTest() {
			Node<Integer> head = new Node<Integer>(1);
			head.add(2).add(3).add(4);
			
			Node<Integer> expected = new Node<Integer>(4);
			expected.add(3).add(2).add(1);
			
			Node<Integer> actual = ListProblems.reverse(head);

			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
	}
	
	@Nested
	class IsPalindromeTests {
		@Test
		public void nullTest() {
			Node<Integer> one = null;
			
			boolean expected = true;
			
			boolean actual = ListProblems.isPalindrome(one);

			assertEquals(expected, actual);
		}
		
		@Test
		public void shortListTest() {
			Node<Integer> one = new Node<Integer>(1);
			
			boolean expected = true;
			
			boolean actual = ListProblems.isPalindrome(one);

			assertEquals(expected, actual);
		}
		
		@Test
		public void evenPalindromeTest() {
			Node<Integer> one = new Node<Integer>(1);
			one.add(2).add(2).add(1);
			
			boolean expected = true;
			
			boolean actual = ListProblems.isPalindrome(one);

			assertEquals(expected, actual);
		}
		
		@Test
		public void oddPalindromeTest() {
			Node<Integer> one = new Node<Integer>(1);
			one.add(2).add(1);
			
			boolean expected = true;
			
			boolean actual = ListProblems.isPalindrome(one);

			assertEquals(expected, actual);
		}
		
		@Test
		public void evenNonPalindromeTest() {
			Node<Integer> one = new Node<Integer>(1);
			one.add(2).add(3).add(4);
			
			boolean expected = false;
			
			boolean actual = ListProblems.isPalindrome(one);

			assertEquals(expected, actual);
		}
		
		@Test
		public void oddNonPalindromeTest() {
			Node<Integer> one = new Node<Integer>(1);
			one.add(2).add(3);
			
			boolean expected = false;
			
			boolean actual = ListProblems.isPalindrome(one);

			assertEquals(expected, actual);
		}
	}
}