package lists;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ListProblemTest {
	@Nested
	class ListCompareTests {
		@Test
		public void BothNullTest() {
			Node one = null;
			Node two = null;
			
			boolean expected = true;
			
			boolean actual = ListProblems.CompareLists(one, two);

			assertEquals(expected, actual);
		}
		
		@Test
		public void OneNullTest() {
			Node one = null;
			Node two = new Node(1);
			
			boolean expected = false;
			
			boolean actual = ListProblems.CompareLists(one, two);

			assertEquals(expected, actual);
		}
		
		@Test
		public void TwoNullTest() {
			Node one = new Node(1);
			Node two = null;
			
			boolean expected = false;
			
			boolean actual = ListProblems.CompareLists(one, two);

			assertEquals(expected, actual);
		}
		
		@Test
		public void ShortListEqualTest() {
			Node one = new Node(1);
			Node two = new Node(1);
			
			boolean expected = true;
			
			boolean actual = ListProblems.CompareLists(one, two);

			assertEquals(expected, actual);
		}
		
		@Test
		public void ShortListDifferentTest() {
			Node one = new Node(1);
			Node two = new Node(2);
			
			boolean expected = false;
			
			boolean actual = ListProblems.CompareLists(one, two);

			assertEquals(expected, actual);
		}

		@Test
		public void OneLongerTest() {
			Node one = new Node(1);
			Node two = new Node(1);
			one.next = new Node(2);
			
			boolean expected = false;
			
			boolean actual = ListProblems.CompareLists(one, two);

			assertEquals(expected, actual);
		}
		
		@Test
		public void TwoLongerTest() {
			Node one = new Node(1);
			Node two = new Node(1);
			two.next = new Node(2);
			
			boolean expected = false;
			
			boolean actual = ListProblems.CompareLists(one, two);

			assertEquals(expected, actual);
		}
		
		@Test
		public void LongListEqualTest() {
			Node one = new Node(1);
			Node two = new Node(1);
			one.next = new Node(2);
			two.next = new Node(2);
			
			boolean expected = true;
			
			boolean actual = ListProblems.CompareLists(one, two);

			assertEquals(expected, actual);
		}
		
		@Test
		public void LongListDifferentTest() {
			Node one = new Node(1);
			Node two = new Node(1);
			one.next = new Node(2);
			two.next = new Node(88);
			
			boolean expected = false;
			
			boolean actual = ListProblems.CompareLists(one, two);

			assertEquals(expected, actual);
		}
	}
	
	@Nested
	class StringToListTests {
		@Test
		public void NullListTest() {
			Node one = null;
			
			String expected = "->null";
			
			String actual = ListProblems.ListToString(one);

			assertEquals(expected, actual);
		}
		
		@Test
		public void OneListTest() {
			Node one = new Node(1);
			
			String expected = "->1->null";
			
			String actual = ListProblems.ListToString(one);

			assertEquals(expected, actual);
		}
		
		@Test
		public void TwoListTest() {
			Node one = new Node(1);
			one.next = new Node(2);
			
			String expected = "->1->2->null";
			
			String actual = ListProblems.ListToString(one);

			assertEquals(expected, actual);
		}
		
		@Test
		public void ThreeListTest() {
			Node one = new Node(1);
			one.next = new Node(2);
			one.next.next = new Node(3);
			
			String expected = "->1->2->3->null";
			
			String actual = ListProblems.ListToString(one);

			assertEquals(expected, actual);
		}
	}
	
	@Nested
	class RemoveDuplicatesTests {
		@Test
		public void NullTest() {
			Node one = null;
			
			Node expected = null;
			
			Node actual = ListProblems.RemoveDuplicates(one);

			assertEquals(true, ListProblems.CompareLists(expected, actual));
		}
		
		@Test
		public void NoDuplicatesShortTest() {
			Node one = new Node(1);
			
			Node expected = new Node(1);
			
			Node actual = ListProblems.RemoveDuplicates(one);

			assertEquals(true, ListProblems.CompareLists(expected, actual));
		}
		
		@Test
		public void NoDuplicatesLongTest() {
			Node one = new Node(1);
			one.next = new Node(2);
			one.next.next = new Node(3);
			
			Node expected = new Node(1);
			expected.next = new Node(2);
			expected.next.next = new Node(3);
			
			Node actual = ListProblems.RemoveDuplicates(one);

			assertEquals(true, ListProblems.CompareLists(expected, actual));
		}
		
		@Test
		public void DuplicatesShortTest() {
			Node one = new Node(1);
			one.next = new Node(1);
			
			Node expected = new Node(1);
			
			Node actual = ListProblems.RemoveDuplicates(one);

			assertEquals(true, ListProblems.CompareLists(expected, actual));
		}
		
		@Test
		public void DuplicatesLongTest() {
			Node one = new Node(1);
			one.Add(1).Add(1).Add(1);
			
			Node expected = new Node(1);
			
			Node actual = ListProblems.RemoveDuplicates(one);

			assertEquals(true, ListProblems.CompareLists(expected, actual));
		}
		
		@Test
		public void ManyDuplicatesLongTest() {
			Node one = new Node(1);
			one.Add(2).Add(3).Add(1).Add(2).Add(3);
			
			Node expected = new Node(1);
			expected.next = new Node(2);
			expected.next.next = new Node(3);
			
			Node actual = ListProblems.RemoveDuplicates(one);

			assertEquals(true, ListProblems.CompareLists(expected, actual));
		}
	}
	
	@Nested
	class KthToLastTests {
		@Test
		public void NullTest() {
			Node one = null;
			int k = 0;
			
			Node expected = null;
			
			Node actual = ListProblems.KthToLast(one, k);

			assertEquals(expected, actual);
		}
		
		@Test
		public void KTooLargeTest() {
			Node one = new Node(1);
			one.next = new Node(2);
			one.next.next = new Node(3);
			one.next.next.next = new Node(4);
			int k = 4;
			
			Node expected = null;
			
			Node actual = ListProblems.KthToLast(one, k);

			assertEquals(expected, actual);
		}
		
		@Test
		public void LastTest() {
			Node one = new Node(1);
			one.next = new Node(2);
			one.next.next = new Node(3);
			one.next.next.next = new Node(4);
			int k = 0;
			
			Node expected = new Node(4);
			
			Node actual = ListProblems.KthToLast(one, k);

			assertEquals(expected.data, actual.data);
		}
		
		@Test
		public void FirstTest() {
			Node one = new Node(1);
			one.next = new Node(2);
			one.next.next = new Node(3);
			one.next.next.next = new Node(4);
			int k = 3;
			
			Node expected = new Node(1);
			
			Node actual = ListProblems.KthToLast(one, k);

			assertEquals(expected.data, actual.data);
		}
		
		@Test
		public void PenultimateTest() {
			Node one = new Node(1);
			one.next = new Node(2);
			one.next.next = new Node(3);
			one.next.next.next = new Node(4);
			int k = 1;
			
			Node expected = new Node(3);
			
			Node actual = ListProblems.KthToLast(one, k);

			assertEquals(expected.data, actual.data);
		}
	}
	
	@Nested
	class PartitionTests {
		@Test
		public void NullTest() {
			Node one = null;
			int data = 5;
			
			Node expected = null;
			
			Node actual = ListProblems.Partition(one, data);

			assertEquals(true, ListProblems.CompareLists(expected, actual));
		}
		
		@Test
		public void OneTest() {
			Node one = new Node(5);
			int data = 5;
			
			Node expected = new Node(5);
			
			Node actual = ListProblems.Partition(one, data);

			assertEquals(true, ListProblems.CompareLists(expected, actual));
		}
		
		@Test
		public void UniformSmallTest() {
			Node one = new Node(1);
			one.Add(2).Add(3);
			
			int data = 3;
			
			Node expected = new Node(1);
			expected.Add(2).Add(3);
			
			Node actual = ListProblems.Partition(one, data);

			assertEquals(true, ListProblems.CompareLists(expected, actual));
		}
		
		@Test
		public void UniformBigTest() {
			Node one = new Node(3);
			one.Add(4).Add(5);
			
			int data = 3;
			
			Node expected = new Node(3);
			expected.Add(4).Add(5);
			
			Node actual = ListProblems.Partition(one, data);

			assertEquals(true, ListProblems.CompareLists(expected, actual));
		}
		
		@Test
		public void UnsortedTest() {
			Node one = new Node(4);
			one.Add(1).Add(3).Add(3).Add(2).Add(2);
			
			int data = 3;
			
			Node expected = new Node(1);
			expected.Add(2).Add(2).Add(3).Add(3).Add(4);
			
			Node actual = ListProblems.Partition(one, data);

			assertEquals(true, ListProblems.CompareLists(expected, actual));
		}
	}
	
	@Nested
	class SumListsTests {
		@Test
		public void BothNullTest() {
			Node one = null;
			Node two = null;
			
			Node expected = null;
			
			Node actual = ListProblems.Sum(one, two);

			assertEquals(true, ListProblems.CompareLists(expected, actual));
		}
		
		@Test
		public void OneNullTest() {
			Node one = null;
			Node two = new Node(1);
			
			Node expected = new Node(1);
			
			Node actual = ListProblems.Sum(one, two);

			assertEquals(true, ListProblems.CompareLists(expected, actual));
		}
		
		@Test
		public void TwoNullTest() {
			Node one = new Node(1);
			Node two = null;
			
			Node expected = new Node(1);;
			
			Node actual = ListProblems.Sum(one, two);

			assertEquals(true, ListProblems.CompareLists(expected, actual));
		}
		
		@Test
		public void ShortListSumTest() {
			Node one = new Node(1);
			Node two = new Node(1);
			
			Node expected = new Node(2);;
			
			Node actual = ListProblems.Sum(one, two);

			assertEquals(true, ListProblems.CompareLists(expected, actual));
		}
		
		@Test
		public void EndOverflowTest() {
			Node one = new Node(9);
			Node two = new Node(9);
			
			Node expected = new Node(8);
			expected.Add(1);
			
			Node actual = ListProblems.Sum(one, two);

			assertEquals(true, ListProblems.CompareLists(expected, actual));
		}

		@Test
		public void OneLongerTest() {
			Node one = new Node(0);
			Node two = new Node(1);
			one.Add(1);
			
			Node expected = new Node(1);
			expected.Add(1);
			
			Node actual = ListProblems.Sum(one, two);
			
			assertEquals(true, ListProblems.CompareLists(expected, actual));
		}
		
		@Test
		public void TwoLongerTest() {
			Node one = new Node(1);
			Node two = new Node(0);
			two.Add(1);
			
			Node expected = new Node(1);
			expected.Add(1);
			
			Node actual = ListProblems.Sum(one, two);

			assertEquals(true, ListProblems.CompareLists(expected, actual));
		}
		
		@Test
		public void LongListDifferentTest() {
			Node one = new Node(9);
			Node two = new Node(1);
			one.Add(9).Add(9).Add(9);
			
			Node expected = new Node(0);
			expected.Add(0).Add(0).Add(0).Add(1);
			
			Node actual = ListProblems.Sum(one, two);

			assertEquals(true, ListProblems.CompareLists(expected, actual));
		}
	}
	
	@Nested
	class IsPalindromeTests {
		@Test
		public void NullTest() {
			Node one = null;
			
			boolean expected = true;
			
			boolean actual = ListProblems.IsPalindrome(one);

			assertEquals(expected, actual);
		}
		
		@Test
		public void ShortListTest() {
			Node one = new Node(1);
			
			boolean expected = true;
			
			boolean actual = ListProblems.IsPalindrome(one);

			assertEquals(expected, actual);
		}
		
		@Test
		public void EvenPalindromeTest() {
			Node one = new Node(1);
			one.Add(2).Add(2).Add(1);
			
			boolean expected = true;
			
			boolean actual = ListProblems.IsPalindrome(one);

			assertEquals(expected, actual);
		}
		
		@Test
		public void OddPalindromeTest() {
			Node one = new Node(1);
			one.Add(2).Add(1);
			
			boolean expected = true;
			
			boolean actual = ListProblems.IsPalindrome(one);

			assertEquals(expected, actual);
		}
		
		@Test
		public void EvenNonPalindromeTest() {
			Node one = new Node(1);
			one.Add(2).Add(3).Add(4);
			
			boolean expected = false;
			
			boolean actual = ListProblems.IsPalindrome(one);

			assertEquals(expected, actual);
		}
		
		@Test
		public void OddNonPalindromeTest() {
			Node one = new Node(1);
			one.Add(2).Add(3);
			
			boolean expected = false;
			
			boolean actual = ListProblems.IsPalindrome(one);

			assertEquals(expected, actual);
		}
	}
}