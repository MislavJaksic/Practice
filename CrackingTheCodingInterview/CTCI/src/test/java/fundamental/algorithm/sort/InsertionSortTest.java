package fundamental.algorithm.sort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class InsertionSortTest {
	public static Stream<Arguments> arrayProvider() {
		Integer[] small_even_unsorted_array = { 5,6,8,9 };
		Integer[] small_odd_unsorted_array = { 6,7,9,2,3 };
		Integer[] big_even_unsorted_array = { 1,6,7,6,4,5,7,9,3,5 };
		Integer[] big_odd_unsorted_array = { 1,6,3,5,5,6,4,9,7,3,8 };

		return Stream.of(
				Arguments.of(0, small_even_unsorted_array),
				Arguments.of(1, small_odd_unsorted_array),
				Arguments.of(2, big_even_unsorted_array),
				Arguments.of(3, big_odd_unsorted_array)
				);
	}

	@ParameterizedTest
	@MethodSource("arrayProvider")
	public void sortTest(Integer count, Integer[] array) {
		Integer[] expected = array.clone();
		Arrays.sort(expected);

		assertArrayEquals(expected, InsertionSort.sort(array));
	}
}
