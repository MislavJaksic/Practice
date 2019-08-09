package fundamental.algorithm;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import fundamental.algorithm.sort.QuickSort;

public class QuickSortTest {
	@Test public void TestQuickSort() {
    	int[] small_array = {5,20,15,25,40,1};
    	int[] sorted_array = {1,5,15,20,25,40};
    	
        assertArrayEquals(sorted_array, QuickSort.sort(small_array));
    }
}