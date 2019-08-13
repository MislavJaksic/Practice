package fundamental.structure.array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import fundamental.structure.array.ResizableArray;

public class ResizableArrayTest {
	@Nested
	class InitTests {
		ResizableArray array = new ResizableArray();
		
		@Test
		public void copyArrayTest() {
			int[] expected = new int[1];
			int capacity = 1;
			
			assertArrayEquals(expected, array.copyArray(capacity));
		}
		
		@Test
		public void isFullTest() {
			boolean expected = true;
			
			assertEquals(expected, array.isFull());
		}
		
		@Test
		public void isSparseTest() {
			boolean expected = false;
			
			assertEquals(expected, array.isSparse());
		}
		
		@Test
		public void getArrayTest() {
			int[] expected = new int[1];
			
			assertArrayEquals(expected, array.getArray());
		}
		
		@Test
		public void sizeTest() {
			int expected = 1;
			
			assertEquals(expected, array.size());
		}
		
		@Test
		public void getIndexTest() {
			int expected = 0;
			
			assertEquals(expected, array.getIndex());
		}
	}
	
	@Nested
	class ResizingTests {
		ResizableArray array = new ResizableArray();
		int capacity = 7;
		
		@Test
		public void appendTest() {
			ResizableArray array = new ResizableArray();
			
			int[] expected = new int[capacity];
			
			for (int i = 0; i < capacity; i++) {
				array.append(i);
				expected[i] = i;
			}
			
			assertArrayEquals(expected, array.copyArray(capacity));
		}
		
		@Test
		public void popTest() {
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
