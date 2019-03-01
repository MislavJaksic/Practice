package fundamentals.data_structure;

public class ResizableArray {
	private static final int enlarge_factor = 2;
	private static final float shrink_factor = 0.5f;
	
	private static final int full_factor = 1;
	private static final float sparse_factor = 0.25f;
	

	private int[] array;
	private int index;



	public ResizableArray() {
		this.array = new int[1];
		this.index = 0;
	}

	public void Append(int data) {
		if (this.IsFull()) {
			this.Enlarge();
		}

		this.array[this.GetIndex()] = data;
		this.IncrementIndex();
	}

	public int Pop() {
		int data = this.array[this.GetIndex()];
		this.array[this.GetIndex()] = 0;
		this.DecrementIndex();

		if (this.IsSparse()) {
			this.Shrink();
		}

		return data;
	}

	

	public void Enlarge() {
		int new_capacity = this.Size() * ResizableArray.enlarge_factor;
		this.array = this.CopyArray(new_capacity);
	}

	public void Shrink() {
		int new_capacity = (int) (this.Size() * ResizableArray.shrink_factor);
		this.array = this.CopyArray(new_capacity);
	}

	
	
	public int[] CopyArray(int new_capacity) {
		int[] new_array = new int[new_capacity];
		
		int smallest_capacity;
		if (new_capacity > this.Size()) {
			smallest_capacity = this.Size();
		} else {
			smallest_capacity = new_capacity;
		}
		
		for (int i = 0; i < smallest_capacity; i++) {
			new_array[i] = this.array[i];
		}
		
		return new_array;
	}
	
	
	
	public boolean IsFull() {
		if ((this.GetIndex() + 1) * ResizableArray.full_factor == this.Size()) {
			return true;
		}
		return false;
	}

	public boolean IsSparse() {
		if (this.Size() * ResizableArray.sparse_factor > (this.GetIndex() + 1)) {
			return true;
		}
		return false;
	}
	
	
	
	public int[] GetArray() {
		return this.CopyArray(this.Size());
	}
	
	public int Size() {
		return this.Length();
	}
	
	public int Length() {
		return this.array.length;
	}
	
	public int GetIndex() {
		return this.index;
	}
	
	private void IncrementIndex() {
		this.index++;
	}

	private void DecrementIndex() {
		this.index--;
	}
}