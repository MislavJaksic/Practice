package fundamental.algorithm;

public class BinarySearch {
	public static int search(int[] array, int element) {
		int low = 0;
		int high = array.length - 1;
		int mid;
		
		while (high - low > -1) {
			mid = (low + high) / 2;
			if (array[mid] == element) {
				return mid;
			} else if (array[mid] < element) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}
}
