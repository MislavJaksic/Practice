package fundamental.algorithm.search;

public class BinaryTrickster {
	public static int sentinel = -1;
	
	public static boolean isSquare(int x) {
		int left = 0;
		int right = x;
		int[] array = BinaryTrickster.getSequenceArray(x);
		
		while (right >= left) {
			int middle = left + (right - left)/2;
			int value_squared = array[middle] * array[middle];
			
			if (value_squared == x) {
				return true;
			} else if (value_squared > x) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}
		
		return false;
	}
	
	public static int[] getSequenceArray(int x) {
		int[] array = new int[x+1];
		for (int i = 1; i <= x; i++) {
			array[i] = i;
		}
		
		return array;
	}
	
	public static <T extends Comparable<T>> int findLowerBoundIndex(T[] array, T search_term) {
		int left = 0;
		int right = array.length - 1;
		int last_true = -1;
		
		while (right >= left) {
			int middle = left + (right - left)/2;
			T value = array[middle];
			
			if (value.compareTo(search_term) > -1) {
				last_true = middle;
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}
		
		return last_true;
	}
	
	public static <T extends Comparable<T>> T findRotatedMinValue(T[] array) {
		int left = 0;
		int right = array.length - 1;
		T min = array[0];
		
		while (right >= left) {
			int middle = left + (right - left)/2;
			T value = array[middle];
			
			if (value.compareTo(min) == 1) {
				left = middle + 1;
			} else {
				min = value;
				right = middle - 1;
			}
		}
		
		return min;
	}
	
	public static <T extends Comparable<T>> T findPeakValue(T[] array) {
		int left = 0;
		int right = array.length - 1;
		T peak = array[0];
		
		while (right >= left) {
			int middle = left + (right - left)/2;
			
			if ((middle == array.length - 1) || (array[middle].compareTo(array[middle + 1]) == 1)) {
				peak = array[middle];
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}
		
		return peak;
	}
}
