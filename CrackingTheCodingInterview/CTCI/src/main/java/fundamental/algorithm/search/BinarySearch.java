package fundamental.algorithm.search;

public class BinarySearch {
	public static <T extends Comparable<T>> boolean search(T[] array, T search_term) {
		int low = 0;
		int high = array.length - 1;
		int mid;
		
		while (high - low > -1) {
			mid = (low + high) / 2;
			if (array[mid] == search_term) {
				return true;
			} else if (array[mid].compareTo(search_term) == -1) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return false;
	}
}
