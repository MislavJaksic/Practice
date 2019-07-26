package fundamental.data_structure;

public class HashTable {
	public static int sentinel = 0;
	
	private int size;
	private HashNode[] table;
	
	
	
	public HashTable(int size) {
		this.setSize(size);
		this.table = new HashNode[this.size];
	}
	
	private void setSize(int size) {
		if (size < 1) {
			size = 1;
		}
		
		this.size = size;
	}
	
	
	
	public void add(int key, int value) {
		int index = this.hash(key);
		HashNode node = new HashNode(key, value);
		
		this.appendNode(index, node);
	}
	
	public int get(int key) {
		int index = this.hash(key);
		return this.find(index, key);
	}
	
	
	
	private void appendNode(int index, HashNode node) {
		HashNode head = this.getFinalOrKeyNode(index, node.key);
		if (head == null) {
			this.addFirstNode(index, node);
		} else {
			if (head.key == node.key) {
				head.value = node.value;
			} else {
				head.next = node;
			}
		}
	}
	
	private void addFirstNode(int index, HashNode node) {
		this.table[index] = node;
	}
	
	private int find(int index, int key) {
		int value = HashTable.sentinel;
		HashNode head = this.getFinalOrKeyNode(index, key);
		if (head != null) {
			value = head.value;
		}
		
		return value;
	}
	
	public HashNode getFinalOrKeyNode(int index, int key) {
		HashNode head = this.table[index];
		if (head != null) {
			while ((head.key != key) && (head.next != null)) {
				head = head.next;
			}
		}
		
		return head;
	}
	
	public int hash(int key) {
		return (key % this.size);
	}

}
