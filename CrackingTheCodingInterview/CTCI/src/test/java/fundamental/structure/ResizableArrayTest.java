package fundamental.structure;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import fundamental.structure.ResizableArray;

public class ResizableArrayTest {
	@Nested
	class InitTests {
		ResizableArray array = new ResizableArray();
		
		@Test
		public void TestCopyArray() {
			int[] expected = new int[1];
			int capacity = 1;
			
			assertArrayEquals(expected, array.copyArray(capacity));
		}
		
		@Test
		public void TestIsFull() {
			boolean expected = true;
			
			assertEquals(expected, array.isFull());
		}
		
		@Test
		public void TestIsSparse() {
			boolean expected = false;
			
			assertEquals(expected, array.isSparse());
		}
		
		@Test
		public void TestGetArray() {
			int[] expected = new int[1];
			
			assertArrayEquals(expected, array.getArray());
		}
		
		@Test
		public void TestSize() {
			int expected = 1;
			
			assertEquals(expected, array.size());
		}
		
		@Test
		public void TestGetIndex() {
			int expected = 0;
			
			assertEquals(expected, array.getIndex());
		}
	}
	
	@Nested
	class ResizingTests {
		ResizableArray array = new ResizableArray();
		int capacity = 7;
		
		@Test
		public void TestAppend() {
			ResizableArray array = new ResizableArray();
			
			int[] expected = new int[capacity];
			
			for (int i = 0; i < capacity; i++) {
				array.append(i);
				expected[i] = i;
			}
			
			assertArrayEquals(expected, array.copyArray(capacity));
		}
		
		@Test
		public void TestPop() {
			ResizableArray array = new ResizableArray();
			
			int[] expected = new int[capacity];
			
			for (int i = 0; i < capacity; i++) {
				array.append(i);
			}
			
			for (int i = 0; i < capacity; i++) {
				array.pop();
			}
			
			assertArrayEquals(expected, array.copyArray(capacity));
		}
	}
}
