package fundamentals.data_structure;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ResizableArrayTest {
	@Test
	public void TestAppendTen() {
		ResizableArray array = new ResizableArray();
		int capacity = 10;
		
		int[] expected = new int[capacity];
		
		for (int i = 0; i < capacity; i++) {
			array.Append(i);
			expected[i] = i;
		}
		
		assertArrayEquals(expected, array.CopyArray(capacity));
	}
}
