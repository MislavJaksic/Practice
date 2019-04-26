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
			Node one = null;
			Node two = null;
			
			boolean expected = true;
			
			boolean actual = ListProblems.compareLists(one, two);

			assertEquals(expected, actual);
		}
		
		@Test
		public void oneNullTest() {
			Node one = null;
			Node two = new Node(1);
			
			boolean expected = false;
			
			boolean actual = ListProblems.compareLists(one, two);

			assertEquals(expected, actual);
		}
		
		@Test
		public void twoNullTest() {
			Node one = new Node(1);
			Node two = null;
			
			boolean expected = false;
			
			boolean actual = ListProblems.compareLists(one, two);

			assertEquals(expected, actual);
		}
		
		@Test
		public void shortListEqualTest() {
			Node one = new Node(1);
			Node two = new Node(1);
			
			boolean expected = true;
			
			boolean actual = ListProblems.compareLists(one, two);

			assertEquals(expected, actual);
		}
		
		@Test
		public void shortListDifferentTest() {
			Node one = new Node(1);
			Node two = new Node(2);
			
			boolean expected = false;
			
			boolean actual = ListProblems.compareLists(one, two);

			assertEquals(expected, actual);
		}

		@Test
		public void oneLongerTest() {
			Node one = new Node(1);
			Node two = new Node(1);
			one.next = new Node(2);
			
			boolean expected = false;
			
			boolean actual = ListProblems.compareLists(one, two);

			assertEquals(expected, actual);
		}
		
		@Test
		public void twoLongerTest() {
			Node one = new Node(1);
			Node two = new Node(1);
			two.next = new Node(2);
			
			boolean expected = false;
			
			boolean actual = ListProblems.compareLists(one, two);

			assertEquals(expected, actual);
		}
		
		@Test
		public void longListEqualTest() {
			Node one = new Node(1);
			Node two = new Node(1);
			one.next = new Node(2);
			two.next = new Node(2);
			
			boolean expected = true;
			
			boolean actual = ListProblems.compareLists(one, two);

			assertEquals(expected, actual);
		}
		
		@Test
		public void longListDifferentTest() {
			Node one = new Node(1);
			Node two = new Node(1);
			one.next = new Node(2);
			two.next = new Node(88);
			
			boolean expected = false;
			
			boolean actual = ListProblems.compareLists(one, two);

			assertEquals(expected, actual);
		}
	}
	
	@Nested
	class StringToListTests {
		@Test
		public void nullListTest() {
			Node one = null;
			
			String expected = "->null";
			
			String actual = ListProblems.listToString(one);

			assertEquals(expected, actual);
		}
		
		@Test
		public void oneListTest() {
			Node one = new Node(1);
			
			String expected = "->1->null";
			
			String actual = ListProblems.listToString(one);

			assertEquals(expected, actual);
		}
		
		@Test
		public void twoListTest() {
			Node one = new Node(1);
			one.next = new Node(2);
			
			String expected = "->1->2->null";
			
			String actual = ListProblems.listToString(one);

			assertEquals(expected, actual);
		}
		
		@Test
		public void threeListTest() {
			Node one = new Node(1);
			one.next = new Node(2);
			one.next.next = new Node(3);
			
			String expected = "->1->2->3->null";
			
			String actual = ListProblems.listToString(one);

			assertEquals(expected, actual);
		}
	}
	
	@Nested
	class RemoveDuplicatesTests {
		@Test
		public void nullTest() {
			Node one = null;
			
			Node expected = null;
			
			Node actual = ListProblems.removeDuplicates(one);

			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
		
		@Test
		public void noDuplicatesShortTest() {
			Node one = new Node(1);
			
			Node expected = new Node(1);
			
			Node actual = ListProblems.removeDuplicates(one);

			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
		
		@Test
		public void noDuplicatesLongTest() {
			Node one = new Node(1);
			one.next = new Node(2);
			one.next.next = new Node(3);
			
			Node expected = new Node(1);
			expected.next = new Node(2);
			expected.next.next = new Node(3);
			
			Node actual = ListProblems.removeDuplicates(one);

			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
		
		@Test
		public void duplicatesShortTest() {
			Node one = new Node(1);
			one.next = new Node(1);
			
			Node expected = new Node(1);
			
			Node actual = ListProblems.removeDuplicates(one);

			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
		
		@Test
		public void duplicatesLongTest() {
			Node one = new Node(1);
			one.Add(1).Add(1).Add(1);
			
			Node expected = new Node(1);
			
			Node actual = ListProblems.removeDuplicates(one);

			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
		
		@Test
		public void manyDuplicatesLongTest() {
			Node one = new Node(1);
			one.Add(2).Add(3).Add(1).Add(2).Add(3);
			
			Node expected = new Node(1);
			expected.next = new Node(2);
			expected.next.next = new Node(3);
			
			Node actual = ListProblems.removeDuplicates(one);

			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
	}
	
	@Nested
	class KthToLastTests {
		@Test
		public void nullTest() {
			Node one = null;
			int k = 0;
			
			Node expected = null;
			
			Node actual = ListProblems.kthToLast(one, k);

			assertEquals(expected, actual);
		}
		
		@Test
		public void kTooLargeTest() {
			Node one = new Node(1);
			one.next = new Node(2);
			one.next.next = new Node(3);
			one.next.next.next = new Node(4);
			int k = 4;
			
			Node expected = null;
			
			Node actual = ListProblems.kthToLast(one, k);

			assertEquals(expected, actual);
		}
		
		@Test
		public void lastTest() {
			Node one = new Node(1);
			one.next = new Node(2);
			one.next.next = new Node(3);
			one.next.next.next = new Node(4);
			int k = 0;
			
			Node expected = new Node(4);
			
			Node actual = ListProblems.kthToLast(one, k);

			assertEquals(expected.data, actual.data);
		}
		
		@Test
		public void firstTest() {
			Node one = new Node(1);
			one.next = new Node(2);
			one.next.next = new Node(3);
			one.next.next.next = new Node(4);
			int k = 3;
			
			Node expected = new Node(1);
			
			Node actual = ListProblems.kthToLast(one, k);

			assertEquals(expected.data, actual.data);
		}
		
		@Test
		public void penultimateTest() {
			Node one = new Node(1);
			one.next = new Node(2);
			one.next.next = new Node(3);
			one.next.next.next = new Node(4);
			int k = 1;
			
			Node expected = new Node(3);
			
			Node actual = ListProblems.kthToLast(one, k);

			assertEquals(expected.data, actual.data);
		}
	}
	
	@Nested
	class partitionTests {
		@Test
		public void nullTest() {
			Node one = null;
			int data = 5;
			
			Node expected = null;
			
			Node actual = ListProblems.partition(one, data);

			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
		
		@Test
		public void oneTest() {
			Node one = new Node(5);
			int data = 5;
			
			Node expected = new Node(5);
			
			Node actual = ListProblems.partition(one, data);

			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
		
		@Test
		public void uniformSmallTest() {
			Node one = new Node(1);
			one.Add(2).Add(3);
			
			int data = 3;
			
			Node expected = new Node(1);
			expected.Add(2).Add(3);
			
			Node actual = ListProblems.partition(one, data);

			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
		
		@Test
		public void uniformBigTest() {
			Node one = new Node(3);
			one.Add(4).Add(5);
			
			int data = 3;
			
			Node expected = new Node(3);
			expected.Add(4).Add(5);
			
			Node actual = ListProblems.partition(one, data);

			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
		
		@Test
		public void unsortedTest() {
			Node one = new Node(4);
			one.Add(1).Add(3).Add(3).Add(2).Add(2);
			
			int data = 3;
			
			Node expected = new Node(1);
			expected.Add(2).Add(2).Add(3).Add(4).Add(3);
			
			Node actual = ListProblems.partition(one, data);
			
			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
	}
	
	@Nested
	class SumListsTests {
		@Test
		public void bothNullTest() {
			Node one = null;
			Node two = null;
			
			Node expected = null;
			
			Node actual = ListProblems.sumReverse(one, two);

			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
		
		@Test
		public void oneNullTest() {
			Node one = null;
			Node two = new Node(1);
			
			Node expected = new Node(1);
			
			Node actual = ListProblems.sumReverse(one, two);

			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
		
		@Test
		public void twoNullTest() {
			Node one = new Node(1);
			Node two = null;
			
			Node expected = new Node(1);;
			
			Node actual = ListProblems.sumReverse(one, two);

			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
		
		@Test
		public void shortListSumTest() {
			Node one = new Node(1);
			Node two = new Node(1);
			
			Node expected = new Node(2);;
			
			Node actual = ListProblems.sumReverse(one, two);

			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
		
		@Test
		public void endOverflowTest() {
			Node one = new Node(9);
			Node two = new Node(9);
			
			Node expected = new Node(8);
			expected.Add(1);
			
			Node actual = ListProblems.sumReverse(one, two);

			assertEquals(true, ListProblems.compareLists(expected, actual));
		}

		@Test
		public void oneLongerTest() {
			Node one = new Node(0);
			Node two = new Node(1);
			one.Add(1);
			
			Node expected = new Node(1);
			expected.Add(1);
			
			Node actual = ListProblems.sumReverse(one, two);
			
			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
		
		@Test
		public void twoLongerTest() {
			Node one = new Node(1);
			Node two = new Node(0);
			two.Add(1);
			
			Node expected = new Node(1);
			expected.Add(1);
			
			Node actual = ListProblems.sumReverse(one, two);

			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
		
		@Test
		public void longListDifferentTest() {
			Node one = new Node(9);
			Node two = new Node(1);
			one.Add(9).Add(9).Add(9);
			
			Node expected = new Node(0);
			expected.Add(0).Add(0).Add(0).Add(1);
			
			Node actual = ListProblems.sumReverse(one, two);

			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
	}
	
	@Nested
	class ReverseListTests {
		@Test
		public void nullTest() {
			Node head = null;
			
			Node expected = null;
			
			Node actual = ListProblems.reverse(head);

			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
		
		@Test
		public void oneNodeTest() {
			Node head = new Node(1);
			
			Node expected = new Node(1);
			
			Node actual = ListProblems.reverse(head);

			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
		
		@Test
		public void manyNodeTest() {
			Node head = new Node(1);
			head.Add(2).Add(3).Add(4);
			
			Node expected = new Node(4);
			expected.Add(3).Add(2).Add(1);
			
			Node actual = ListProblems.reverse(head);

			assertEquals(true, ListProblems.compareLists(expected, actual));
		}
	}
	
	@Nested
	class IsPalindromeTests {
		@Test
		public void nullTest() {
			Node one = null;
			
			boolean expected = true;
			
			boolean actual = ListProblems.isPalindrome(one);

			assertEquals(expected, actual);
		}
		
		@Test
		public void shortListTest() {
			Node one = new Node(1);
			
			boolean expected = true;
			
			boolean actual = ListProblems.isPalindrome(one);

			assertEquals(expected, actual);
		}
		
		@Test
		public void evenPalindromeTest() {
			Node one = new Node(1);
			one.Add(2).Add(2).Add(1);
			
			boolean expected = true;
			
			boolean actual = ListProblems.isPalindrome(one);

			assertEquals(expected, actual);
		}
		
		@Test
		public void oddPalindromeTest() {
			Node one = new Node(1);
			one.Add(2).Add(1);
			
			boolean expected = true;
			
			boolean actual = ListProblems.isPalindrome(one);

			assertEquals(expected, actual);
		}
		
		@Test
		public void evenNonPalindromeTest() {
			Node one = new Node(1);
			one.Add(2).Add(3).Add(4);
			
			boolean expected = false;
			
			boolean actual = ListProblems.isPalindrome(one);

			assertEquals(expected, actual);
		}
		
		@Test
		public void oddNonPalindromeTest() {
			Node one = new Node(1);
			one.Add(2).Add(3);
			
			boolean expected = false;
			
			boolean actual = ListProblems.isPalindrome(one);

			assertEquals(expected, actual);
		}
	}
}