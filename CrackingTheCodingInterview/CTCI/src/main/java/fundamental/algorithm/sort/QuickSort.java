package fundamental.algorithm.sort;

public class QuickSort {
	/**
	 * Pick a pivot to divide the array into two smaller arrays.
	 * Sort the smaller arrays by swapping places elements if they are smaller then the pivot.
	 * @param array
	 * @return
	 */
	public static <T extends Comparable<T>> T[] sort(T[] array) {
		int low = 0;
		int high = array.length - 1;
		return QuickSort.sortQuickly(low, high, array);
	}
	
	private static <T extends Comparable<T>> T[] sortQuickly(int low, int high, T[] array) {
		int partition;
		if (low < high) {
			partition = QuickSort.partition(low, high, array);
			array = QuickSort.sortQuickly(low, partition - 1, array);
			array = QuickSort.sortQuickly(partition + 1, high, array);
		}
		
		return array;
	}
	
	private static <T extends Comparable<T>> int partition(int low, int high, T[] array) {
		T sentinel;
		
		T pivot = array[high];
		int i = low;
		for (int j = low; j < high; j++) {
			if (array[j].compareTo(pivot) == -1) {
				sentinel = array[i];
				array[i] = array[j];
				array[j] = sentinel;
				
				i++;
			}
		}
		
		sentinel = array[i];
		array[i] = array[high];
		array[high] = sentinel;
		
		return i;
	}
}
