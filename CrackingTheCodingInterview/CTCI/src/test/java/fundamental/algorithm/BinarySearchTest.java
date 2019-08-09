package fundamental.algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import fundamental.algorithm.search.BinarySearch;

public class BinarySearchTest {
    @Test public void TestBinarySearchIsExist() {
    	int[] sorted_array = {1,5,15,20,25,40};
    	int element = 40;
    	int result = 5;
    	
        assertEquals(result, BinarySearch.search(sorted_array, element));
    }
    
    @Test public void TestBinarySearchNotExist() {
    	int[] sorted_array = {1,5,15,20,25,40};
    	int element = 41;
    	int result = -1;
    	
        assertEquals(result, BinarySearch.search(sorted_array, element));
    }
    
    @Test public void TestBinarySearchSmallIsExist() {
    	int[] sorted_array = {1};
    	int element = 1;
    	int result = 0;
    	
        assertEquals(result, BinarySearch.search(sorted_array, element));
    }
    
    @Test public void TestBinarySearchSmallNotExist() {
    	int[] sorted_array = {1};
    	int element = 0;
    	int result = -1;
    	
        assertEquals(result, BinarySearch.search(sorted_array, element));
    }
}
