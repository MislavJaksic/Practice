package fundamentals;

public class MergeSort {
	/**
	 * Subdivide the array into smaller arrays and then merge left and right arrays into a single ordered array.
	 * Calculate the middle index.
	 * Copy part of the original array into an array the size of the original array.
	 * Compare left and right array elements until one of them is empty.
	 * Be careful about where you place the elements.
	 * @param array
	 * @return
	 */
	public static int[] Sort(int[] array) {
		int low = 0;
		int high = array.length - 1;
		return MergeSort.TopDownMergeSort(low, high, array);
	}
	
	private static int[] TopDownMergeSort(int low, int high, int[] array) {
		if (high - low < 1) {
			return array;
		}
		
		int middle = (high + low) / 2;
		array = MergeSort.TopDownMergeSort(low, middle, array);
		array = MergeSort.TopDownMergeSort(middle + 1, high, array);
		array = MergeSort.Merge(low, high, array);
		
		return array;
	}
	
	private static int[] Merge(int low, int high, int[] array) {
		int[] copy_array = MergeSort.CopyArray(low, high, array);
		
		int middle = (high + low) / 2;
		int left = low;
		int right = middle + 1;
		int position = 0;
		
		while(left < (middle + 1) && right < (high + 1)) {
			if (copy_array[left] < copy_array[right]) {
				array[low + position] = copy_array[left];
				left++;
			} else {
				array[low + position] = copy_array[right];
				right++;
			}
			position++;
		}
		
		while(left < (middle + 1)) {
			array[low + position] = copy_array[left];
			left++;
			position++;
		}
		
		while(right < (high + 1)) {
			array[low + position] = copy_array[right];
			right++;
			position++;
		}
		
		return array;
	}
	
	private static int[] CopyArray(int low, int high, int[] array) {
		int[] copy_array = new int[array.length];
		for (int i = low; i < high + 1; i++) {
			copy_array[i] = array[i];
		}
		return copy_array;
	}
}
