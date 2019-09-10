package fundamental.algorithm.search;

/**
 * Use binary search when:
 * 1) you can express a condition which,
 * 2) divides the array in two parts
 * Binary search can find the border between the two.
 */
public class BinarySearcher {
	public static int sentinel = -1;
	
	public static <T extends Comparable<T>> int binarySearchIndex(T[] array, T search_term) {
		int left = 0;
		int right = array.length - 1;
		
		while (right >= left) {
			int middle = left + (right - left)/2; // "(left + right) / 2" may overflow the buffer
			T value = array[middle];
			
			if (value == search_term) {
				return middle;
			} else if (value.compareTo(search_term) == -1) {
				left = middle + 1;
			} else {
				right = middle - 1;
			}
		}
		
		return BinarySearcher.sentinel;
	}
}
