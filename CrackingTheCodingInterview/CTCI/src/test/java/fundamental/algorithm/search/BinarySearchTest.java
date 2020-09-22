package fundamental.algorithm.search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BinarySearchTest {
	public static Stream<Arguments> arrayProvider() {
		Integer[] small_even_array = { 0, 5 };
		Integer[] small_odd_array = { 0, 5, 10 };
		Integer[] big_even_array = { 0, 5, 15, 20, 25, 30 };
		Integer[] big_odd_array = { 0, 5, 15, 20, 25, 30, 35};

		// Integer[] max_array = new Integer[Integer.MAX_VALUE];
		// max_array[1] = 5;

		return Stream.of(
				Arguments.of(0, small_odd_array),
				Arguments.of(1, small_even_array),
				Arguments.of(2, big_even_array),
				Arguments.of(3, big_odd_array) // ,
				// Arguments.of(4, max_array)
				);
	}

	@ParameterizedTest
	@MethodSource("arrayProvider")
	public void trueLeftTest(Integer count, Integer[] array) {
		Integer search_term = 0;

		int expected = 0;

		assertEquals(expected, BinarySearcher.binarySearchIndex(array, search_term));
	}

	@ParameterizedTest
	@MethodSource("arrayProvider")
	public void trueRightTest(Integer count, Integer[] array) {
		int search_term = 5;

		int expected = 1;

		assertEquals(expected, BinarySearcher.binarySearchIndex(array, search_term));
	}

	@ParameterizedTest
	@MethodSource("arrayProvider")
	public void falseLeftTest(Integer count, Integer[] array) {
		int search_term = -5;

		int expected = BinarySearcher.sentinel;

		assertEquals(expected, BinarySearcher.binarySearchIndex(array, search_term));
	}

	@ParameterizedTest
	@MethodSource("arrayProvider")
	public void falseRightTest(Integer count, Integer[] array) {
		int search_term = 40;

		int expected = BinarySearcher.sentinel;

		assertEquals(expected, BinarySearcher.binarySearchIndex(array, search_term));
	}
}
