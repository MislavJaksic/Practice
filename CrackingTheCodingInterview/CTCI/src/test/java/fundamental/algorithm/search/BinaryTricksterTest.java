package fundamental.algorithm.search;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BinaryTricksterTest {
	public static Stream<Arguments> squareProvider() {
		return Stream.of(
				Arguments.of(0, 0),
				Arguments.of(1, 1),
				Arguments.of(2, 16),
				Arguments.of(3, 25),
				Arguments.of(4, 36)
				);
	}
	
	public static Stream<Arguments> nonSquareProvider() {
		return Stream.of(
				Arguments.of(0, 3),
				Arguments.of(1, 20),
				Arguments.of(2, 27),
				Arguments.of(3, 50),
				Arguments.of(4, 95)
				);
	}
	
	@ParameterizedTest
	@MethodSource("squareProvider")
	public void trueIsSquareTest(int count, int x) {
		assertTrue(BinaryTrickster.isSquare(x));
	}
	
	@ParameterizedTest
	@MethodSource("nonSquareProvider")
	public void falseIsSquareTest(int count, int x) {
		assertFalse(BinaryTrickster.isSquare(x));
	}
	
	public static Stream<Arguments> lowerBoundArrayProvider() {
		Integer[] array = { 0, 5, 15, 20, 25, 30, 35};
		
		return Stream.of(
				Arguments.of(0, array, 0, 0),
				Arguments.of(1, array, 14, 2),
				Arguments.of(2, array, 31, 6),
				Arguments.of(3, array, 36, BinaryTrickster.sentinel)
				);
	}
	
	@ParameterizedTest
	@MethodSource("lowerBoundArrayProvider")
	public void lowerBoundTest(int count, Integer[] array, Integer search_term, Integer expected_index) {
		assertEquals(expected_index, BinaryTrickster.findLowerBoundIndex(array, search_term));
	}
	
	public static Stream<Arguments> roatedArrayProvider() {
		Integer[] small_shift_array = {19,2,3,6,7,9,15};
		Integer[] large_shift_array = {6,7,9,15,19,2,3};
		
		return Stream.of(
				Arguments.of(0, small_shift_array, 2),
				Arguments.of(1, large_shift_array, 2)
				);
	}
	
	@ParameterizedTest
	@MethodSource("roatedArrayProvider")
	public void findRotatedMinValueTest(int count, Integer[] array, Integer expected_value) {
		assertEquals(expected_value, BinaryTrickster.findRotatedMinValue(array));
	}
	
	public static Stream<Arguments> peakArrayProvider() {
		Integer[] even_peak_array = {1,3,5,6,4,2};
		Integer[] odd_peak_array = {2,3,4,6,9,12,11,8,6,4,1};
		Integer[] hill_array = {0,1,2,3,4,5};
		Integer[] valley_array = {5,4,3,2,1,0};
		
		return Stream.of(
				Arguments.of(0, even_peak_array, 6),
				Arguments.of(1, odd_peak_array, 12),
				Arguments.of(2, hill_array, 5),
				Arguments.of(3, valley_array, 5)
				);
	}
	
	@ParameterizedTest
	@MethodSource("peakArrayProvider")
	public void findPeakValueTest(int count, Integer[] array, Integer expected_value) {
		assertEquals(expected_value, BinaryTrickster.findPeakValue(array));
	}
}
