package fundamental.algorithm.sort;



public class InsertionSort {
	/**
	 * The array is divided into two parts. Sorted and unsorted.
	 * The sorted part is empty at the start.
	 * The elements are taken from the unsorted part and swapped until they are placed in the sorted part.
	 * @param array
	 * @return
	 */
	public static int[] sort(int[] array) {
		int sentinel;
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				if (array[i - j] < array[i - j - 1]) {
					sentinel = array[i - j];
					array[i - j] = array[i - j - 1];
					array[i - j - 1] = sentinel;
				} else {
					break;
				}
			}
		}
		return array;
	}
}
