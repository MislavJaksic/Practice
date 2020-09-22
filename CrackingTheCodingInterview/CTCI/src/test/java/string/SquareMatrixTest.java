package string;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class SquareMatrixTest {
	@Nested
	class SwapTests {
		int[][] array = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
				};
		SquareMatrix matrix = new SquareMatrix(array);

		@Test
		public void SwapPointsTest() {
			int[][] expected = {
					{13,2,3,1},
					{5,6,7,8},
					{9,10,11,12},
					{16,14,15,4}
					};

			Point up = new Point(0,0);
			Point right = new Point(0,3);
			Point down = new Point(3,3);
			Point left = new Point(3,0);

			matrix.SwapClockwise(up, right, down, left);

			int[][] actual = matrix.toArray();

			assertArrayEquals(expected, actual);
		}

		@Test
		public void SwapOuterRingTest() {
			int[][] expected = {
					{13,9,5,1},
					{14,6,7,2},
					{15,10,11,3},
					{16,12,8,4}
					};
			Point corner = new Point(0, 0);
			int ring_width = 4;

			matrix.RotateRingClockwise(corner, ring_width);

			int[][] actual = matrix.toArray();

			assertArrayEquals(expected, actual);
		}

		@Test
		public void SwapInnerRingTest() {
			int[][] expected = {
					{1,2,3,4},
					{5,10,6,8},
					{9,11,7,12},
					{13,14,15,16}
					};

			Point corner = new Point(1, 1);
			int ring_width = 2;

			matrix.RotateRingClockwise(corner, ring_width);

			int[][] actual = matrix.toArray();

			assertArrayEquals(expected, actual);
		}

		@Test
		public void RotateMatrixTest() {
			int[][] expected = {
					{13,9,5,1},
					{14,10,6,2},
					{15,11,7,3},
					{16,12,8,4}
					};

			matrix.RotateMatrixClockwise();

			int[][] actual = matrix.toArray();

			assertArrayEquals(expected, actual);
		}
	}
}
