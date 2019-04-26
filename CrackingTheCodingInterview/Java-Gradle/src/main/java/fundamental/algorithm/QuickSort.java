package fundamental.algorithm;

public class QuickSort {
	/**
	 * Pick a pivot to divide the array into two smaller arrays.
	 * Sort the smaller arrays by swapping places elements if they are smaller then the pivot.
	 * @param array
	 * @return
	 */
	public static int[] Sort(int[] array) {
		int low = 0;
		int high = array.length - 1;
		return QuickSort.SortQuickly(low, high, array);
	}
	
	private static int[] SortQuickly(int low, int high, int[] array) {
		int partition;
		if (low < high) {
			partition = QuickSort.Partition(low, high, array);
			array = SortQuickly(low, partition - 1, array);
			array = SortQuickly(partition + 1, high, array);
		}
		
		return array;
	}
	
	private static int Partition(int low, int high, int[] array) {
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
