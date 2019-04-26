package string;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import string.StringProblems;

public class StringProblemTest {
	@Nested
	class IsUniqueTests {
		@Test
		public void EmptyStringTest() {
			String input = "";

			boolean expected = true;

			boolean actual = StringProblems.IsUnique(input);

			assertEquals(expected, actual);
		}

		@Test
		public void UniqueStringTest() {
			String input = "5498fscg";

			boolean expected = true;

			boolean actual = StringProblems.IsUnique(input);

			assertEquals(expected, actual);
		}

		@Test
		public void NonUniqueStringTest() {
			String input = "abcddefg";

			boolean expected = false;

			boolean actual = StringProblems.IsUnique(input);

			assertEquals(expected, actual);
		}
	}

	@Nested
	class IsPermutationTests {
		@Test
		public void EmptyStringTest() {
			String one = "";
			String two = "";

			boolean expected = true;

			boolean actual = StringProblems.IsPermutation(one, two);

			assertEquals(expected, actual);
		}

		@Test
		public void PermutationStringTest() {
			String one = "abbcccdddd";
			String two = "ddddcccbba";

			boolean expected = true;

			boolean actual = StringProblems.IsPermutation(one, two);

			assertEquals(expected, actual);
		}

		@Test
		public void NonPermutationCaseOneStringTest() {
			String one = "abbcccddd";
			String two = "ddddcccbba";

			boolean expected = false;

			boolean actual = StringProblems.IsPermutation(one, two);

			assertEquals(expected, actual);
		}

		@Test
		public void NonPermutationCaseTwoStringTest() {
			String one = "abbcccdddd";
			String two = "ddddcccbb";

			boolean expected = false;

			boolean actual = StringProblems.IsPermutation(one, two);

			assertEquals(expected, actual);
		}
	}

	@Nested
	class URLifyTests {
		@Test
		public void URLifyThreeWordsTest() {
			char[] string = { 'm', 'i', ' ', 's', 'l', 'a', 'v', ' ', 'j', 'a', ' ', ' ', ' ', ' ' };
			int true_length = 10;

			char[] expected = { 'm', 'i', '%', '2', '0', 's', 'l', 'a', 'v', '%', '2', '0', 'j', 'a' };

			char[] actual = StringProblems.URLify(string, true_length);

			assertArrayEquals(expected, actual);
		}

		@Test
		public void URLifyTwoWordsTest() {
			char[] string = { 'm', 'i', ' ', 's', 'l', 'a', 'v', ' ', ' ' };
			int true_length = 7;

			char[] expected = { 'm', 'i', '%', '2', '0', 's', 'l', 'a', 'v' };

			char[] actual = StringProblems.URLify(string, true_length);

			assertArrayEquals(expected, actual);
		}

		@Test
		public void URLifyOneWordsTest() {
			char[] string = { 'm', 'i' };
			int true_length = 2;

			char[] expected = { 'm', 'i' };

			char[] actual = StringProblems.URLify(string, true_length);

			assertArrayEquals(expected, actual);
		}
	}

	@Nested
	class PalindromePermutationTests {
		@Test
		public void EmptyStringTest() {
			String input = "";

			boolean expected = true;

			boolean actual = StringProblems.PalindromePermutation(input);

			assertEquals(expected, actual);
		}

		@Test
		public void EvenPalindromeTest() {
			String input = "aabbccdd";

			boolean expected = true;

			boolean actual = StringProblems.PalindromePermutation(input);

			assertEquals(expected, actual);
		}

		@Test
		public void OddPalindromeTest() {
			String input = "aabbccd";

			boolean expected = true;

			boolean actual = StringProblems.PalindromePermutation(input);

			assertEquals(expected, actual);
		}
		
		@Test
		public void NonPalindromeTest() {
			String input = "aabbcd";

			boolean expected = false;

			boolean actual = StringProblems.PalindromePermutation(input);

			assertEquals(expected, actual);
		}
	}
	
	@Nested
	class OneAwayTests {
		@Test
		public void EmptyStringTest() {
			String one = "";
			String two = "";

			boolean expected = true;

			boolean actual = StringProblems.OneAway(one, two);

			assertEquals(expected, actual);
		}

		@Test
		public void ManyReplacementsTest() {
			String one = "abbcccdddd";
			String two = "ddddcccbba";

			boolean expected = false;

			boolean actual = StringProblems.OneAway(one, two);

			assertEquals(expected, actual);
		}

		@Test
		public void ManyDeletionsTest() {
			String one = "abbcccddd";
			String two = "ddddcccbbaaaaa";

			boolean expected = false;

			boolean actual = StringProblems.OneAway(one, two);

			assertEquals(expected, actual);
		}
		
		@Test
		public void OneReplacementTest() {
			String one = "abbcccdddd";
			String two = "abbcccddda";

			boolean expected = true;

			boolean actual = StringProblems.OneAway(one, two);

			assertEquals(expected, actual);
		}
		
		@Test
		public void OneDeletionAtMiddleTest() {
			String one = "abbcccdddd";
			String two = "abbccdddd";

			boolean expected = true;

			boolean actual = StringProblems.OneAway(one, two);

			assertEquals(expected, actual);
		}

		@Test
		public void OneDeletionAtEndTest() {
			String one = "abbcccdddd";
			String two = "abbcccddd";

			boolean expected = true;

			boolean actual = StringProblems.OneAway(one, two);

			assertEquals(expected, actual);
		}
	}
	
	@Nested
	class StringCompressionTests {
		@Test
		public void SmallStringTest() {
			String one = "ab";

			String expected = "ab";

			String actual = StringProblems.StringCompression(one);

			assertEquals(expected, actual);
		}

		@Test
		public void UniformStringTest() {
			String one = "aaaaa";

			String expected = "a5";

			String actual = StringProblems.StringCompression(one);

			assertEquals(expected, actual);
		}
		
		@Test
		public void LargeDescendingStringTest() {
			String one = "aaaaabbbbcccdde";

			String expected = "a5b4c3d2e1";

			String actual = StringProblems.StringCompression(one);

			assertEquals(expected, actual);
		}
		
		@Test
		public void LargeAscendingStringTest() {
			String one = "abbcccddddeeeee";

			String expected = "a1b2c3d4e5";

			String actual = StringProblems.StringCompression(one);

			assertEquals(expected, actual);
		}
		
		@Test
		public void LargeNonRepeatingStringTest() {
			String one = "abcdefghiklmnop";

			String expected = "abcdefghiklmnop";

			String actual = StringProblems.StringCompression(one);

			assertEquals(expected, actual);
		}
	}
}
