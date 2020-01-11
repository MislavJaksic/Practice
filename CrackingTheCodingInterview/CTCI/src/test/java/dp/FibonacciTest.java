package dp;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FibonacciTest {
	public static Stream<Arguments> integerProvider() {
		return Stream.of(
				Arguments.of(0, 5, 5),
				Arguments.of(1, 7, 13),
				Arguments.of(2, 20, 6765),
				Arguments.of(3, 40, 102334155)
				);
	}

	@ParameterizedTest
	@MethodSource("integerProvider")
	public void calculateTest(Integer id, Integer N, Integer expected) {
		assertEquals(expected, Fibonacci.calculate(N));
	}
}
