package fundamentals;

import org.junit.Test;
import static org.junit.Assert.*;

public class InsertionSortTest {
    @Test public void TestInsertionSort() {
    	int[] small_array = {5,20,15,25,40,1};
    	int[] sorted_array = {1,5,15,20,25,40};
    	
        assertArrayEquals(sorted_array, InsertionSort.Sort(small_array));
    }
}
