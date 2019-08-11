package fundamental.algorithm.search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import fundamental.algorithm.search.BinarySearch;

public class BinarySearchTest {
	public static Stream<Arguments> arrayProvider() {
		Integer[] small_even_array = { 0, 5 };
		Integer[] small_odd_array = { 0, 5, 10 };
		Integer[] big_even_array = { 0, 5, 15, 20, 25, 30 };
		Integer[] big_odd_array = { 0, 5, 15, 20, 25, 30, 35};
		
		return Stream.of(
				Arguments.of(0, small_odd_array),
				Arguments.of(1, small_even_array),
				Arguments.of(2, big_even_array),
				Arguments.of(3, big_odd_array)
				);
	}
	
	@ParameterizedTest
	@MethodSource("arrayProvider")
	public void trueLeftTest(Integer count, Integer[] array) {
		Integer search_term = 0;
		
		boolean expected = true;

		assertEquals(expected, BinarySearch.search(array, search_term));
	}
	
	@ParameterizedTest
	@MethodSource("arrayProvider")
	public void trueRightTest(Integer count, Integer[] array) {
		int search_term = 5;
		
		boolean expected = true;

		assertEquals(expected, BinarySearch.search(array, search_term));
	}
	
	@ParameterizedTest
	@MethodSource("arrayProvider")
	public void falseLeftTest(Integer count, Integer[] array) {
		int search_term = -5;
		
		boolean expected = false;

		assertEquals(expected, BinarySearch.search(array, search_term));
	}
	
	@ParameterizedTest
	@MethodSource("arrayProvider")
	public void falseRightTest(Integer count, Integer[] array) {
		int search_term = 40;
		
		boolean expected = false;

		assertEquals(expected, BinarySearch.search(array, search_term));
	}
}
