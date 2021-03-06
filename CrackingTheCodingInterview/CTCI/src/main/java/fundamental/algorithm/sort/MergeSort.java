package fundamental.algorithm.sort;

import java.lang.reflect.Array;

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
	public static <T extends Comparable<T>> T[] sort(Class<T> class_type, T[] array) {
		int low = 0;
		int high = array.length - 1;
		return MergeSort.topDownMergeSort(class_type, low, high, array);
	}
	
	private static <T extends Comparable<T>> T[] topDownMergeSort(Class<T> class_type, int low, int high, T[] array) {
		if (high - low < 1) {
			return array;
		}
		
		int middle = (high + low) / 2;
		array = MergeSort.topDownMergeSort(class_type, low, middle, array);
		array = MergeSort.topDownMergeSort(class_type, middle + 1, high, array);
		array = MergeSort.merge(class_type, low, high, array);
		
		return array;
	}
	
	private static <T extends Comparable<T>> T[] merge(Class<T> class_type, int low, int high, T[] array) {
		T[] copy_array = MergeSort.copyArray(class_type, low, high, array);
		
		int middle = (high + low) / 2;
		int left = low;
		int right = middle + 1;
		int position = 0;
		
		while(left < (middle + 1) && right < (high + 1)) {
			if (copy_array[left].compareTo(copy_array[right]) == -1) {
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
	
	private static <T extends Comparable<T>> T[] copyArray(Class<T> class_type, int low, int high, T[] array) {
		T[] copy_array = MergeSort.createGenericArray(class_type, array.length);
		for (int i = low; i < high + 1; i++) {
			copy_array[i] = array[i];
		}
		
		return copy_array;
	}
	
	private static <T extends Comparable<T>> T[] createGenericArray(Class<T> class_type, int size) {
	    @SuppressWarnings("unchecked")
	    T[] array = (T[]) Array.newInstance(class_type, size);

	    return array;
	}
}
