package fundamental.algorithm;

public class QuickSort {
	/**
	 * Pick a pivot to divide the array into two smaller arrays.
	 * Sort the smaller arrays by swapping places elements if they are smaller then the pivot.
	 * @param array
	 * @return
	 */
	public static int[] sort(int[] array) {
		int low = 0;
		int high = array.length - 1;
		return QuickSort.sortQuickly(low, high, array);
	}
	
	private static int[] sortQuickly(int low, int high, int[] array) {
		int partition;
		if (low < high) {
			partition = QuickSort.partition(low, high, array);
			array = sortQuickly(low, partition - 1, array);
			array = sortQuickly(partition + 1, high, array);
		}
		
		return array;
	}
	
	private static int partition(int low, int high, int[] array) {
		int sentinel;
		
		int pivot = array[high];
		int i = low;
		for (int j = low; j < high - 1; j++) {
			if (array[j] < pivot) {
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