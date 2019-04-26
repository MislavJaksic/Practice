package fundamental.data_structure;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import fundamental.data_structure.ResizableArray;

public class ResizableArrayTest {
	@Nested
	class InitTests {
		ResizableArray array = new ResizableArray();
		
		@Test
		public void TestCopyArray() {
			int[] expected = new int[1];
			int capacity = 1;
			
			assertArrayEquals(expected, array.CopyArray(capacity));
		}
		
		@Test
		public void TestIsFull() {
			boolean expected = true;
			
			assertEquals(expected, array.IsFull());
		}
		
		@Test
		public void TestIsSparse() {
			boolean expected = false;
			
			assertEquals(expected, array.IsSparse());
		}
		
		@Test
		public void TestGetArray() {
			int[] expected = new int[1];
			
			assertArrayEquals(expected, array.GetArray());
		}
		
		@Test
		public void TestSize() {
			int expected = 1;
			
			assertEquals(expected, array.Size());
		}
		
		@Test
		public void TestGetIndex() {
			int expected = 0;
			
			assertEquals(expected, array.GetIndex());
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
				array.Append(i);
				expected[i] = i;
			}
			
			assertArrayEquals(expected, array.CopyArray(capacity));
		}
		
		@Test
		public void TestPop() {
			ResizableArray array = new ResizableArray();
			
			int[] expected = new int[capacity];
			
			for (int i = 0; i < capacity; i++) {
				array.Append(i);
			}
			
			for (int i = 0; i < capacity; i++) {
				array.Pop();
			}
			
			assertArrayEquals(expected, array.CopyArray(capacity));
		}
	}
}
