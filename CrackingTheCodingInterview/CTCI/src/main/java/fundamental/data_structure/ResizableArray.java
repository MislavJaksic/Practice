package fundamental.data_structure;

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

	public void append(int data) {
		if (this.isFull()) {
			this.enlarge();
		}

		this.array[this.getIndex()] = data;
		this.incrementIndex();
	}

	public int pop() {
		int data = this.array[this.getIndex()];
		this.array[this.getIndex()] = 0;
		this.decrementIndex();

		if (this.isSparse()) {
			this.shrink();
		}

		return data;
	}

	

	public void enlarge() {
		int new_capacity = this.size() * ResizableArray.enlarge_factor;
		this.array = this.copyArray(new_capacity);
	}

	public void shrink() {
		int new_capacity = (int) (this.size() * ResizableArray.shrink_factor);
		this.array = this.copyArray(new_capacity);
	}

	
	
	public int[] copyArray(int new_capacity) {
		int[] new_array = new int[new_capacity];
		
		int smallest_capacity;
		if (new_capacity > this.size()) {
			smallest_capacity = this.size();
		} else {
			smallest_capacity = new_capacity;
		}
		
		for (int i = 0; i < smallest_capacity; i++) {
			new_array[i] = this.array[i];
		}
		
		return new_array;
	}
	
	
	
	public boolean isFull() {
		if ((this.getIndex() + 1) * ResizableArray.full_factor == this.size()) {
			return true;
		}
		return false;
	}

	public boolean isSparse() {
		if (this.size() * ResizableArray.sparse_factor > (this.getIndex() + 1)) {
			return true;
		}
		return false;
	}
	
	
	
	public int[] getArray() {
		return this.copyArray(this.size());
	}
	
	public int size() {
		return this.length();
	}
	
	public int length() {
		return this.array.length;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	private void incrementIndex() {
		this.index++;
	}

	private void decrementIndex() {
		this.index--;
	}
}