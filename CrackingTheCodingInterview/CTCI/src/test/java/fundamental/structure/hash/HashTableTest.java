package fundamental.structure.hash;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import fundamental.data_structure.hash.HashTable;


public class HashTableTest {
	@Nested
	class CreationTests {
		
		@Test
		public void negativeSizeTest() {
			int size = -1;
			HashTable table = new HashTable(size);
			
			int expected = HashTable.sentinel;
			
			assertEquals(expected, table.get(0));
		}
	}
	
	@Nested
	class HelperTests {
		int size = 2;
		HashTable table = new HashTable(size);
		
		@Test
 		public void hashTest() {
			int key = 3;
			int index = table.hash(key);
			
			int expected = 1;
			
			assertEquals(expected, index);
		}
		
		@Test
		public void getFinalNodeTest() {
			int key_1 = 1;
			int value_1 = 11;
			table.add(key_1, value_1);
			int key_2 = 3;
			int value_2 = 22;
			table.add(key_2, value_2);
			
			int expected = 22;
			
			assertEquals(expected, table.getFinalOrKeyNode(1, 3).value);
		}
		
		@Test
		public void getKeyNodeTest() {
			int key_1 = 1;
			int value_1 = 11;
			table.add(key_1, value_1);
			int key_2 = 3;
			int value_2 = 22;
			table.add(key_2, value_2);
			
			int expected = 11;
			
			assertEquals(expected, table.getFinalOrKeyNode(1, 1).value);
		}
	}
		
	@Nested
	class FunctionTests {
		int size = 2;
		HashTable table = new HashTable(size);
		
		@Test
 		public void addOneTest() {
			int key = 1;
			int value = 11;
			table.add(key, value);
			
			int expected = 11;
			
			assertEquals(expected, table.get(key));
		}
		
		@Test
		public void addTwoTest() {
			int key_1 = 1;
			int value_1 = 11;
			table.add(key_1, value_1);
			
			int key_2 = 2;
			int value_2 = 22;
			table.add(key_2, value_2);
			
			int expected = 22;
			
			assertEquals(expected, table.get(key_2));
		}
		
		@Test
		public void replaceTest() {
			int key = 1;
			int value = 11;
			table.add(key, value);
			
			value = 22;
			table.add(key, value);
			
			int expected = 22;
			
			assertEquals(expected, table.get(key));
		}
		
		@Test
		public void collisionTest() {
			int key_1 = 1;
			int value_1 = 11;
			table.add(key_1, value_1);
			
			int key_2 = 3;
			int value_2 = 22;
			table.add(key_2, value_2);
			
			int expected = 22;
			
			assertEquals(expected, table.get(key_2));
		}
		
//		@Test
//		public void addTest() {
//			expected = ;
//			
//			assertEquals(expected, );
//		}
	}
}
