package mjaksic.java_maven.list;

public class List {
	public final static String head_sentinel = "HEAD";
	public final static String tail_sentinel = "TAIL";
	
	private ListNode head = null;
	private int length = 0;

	public List(ListNode node) {
		this.CreateHead();
		this.AddNode(node);
	}
	
	private void CreateHead() {
		this.head = new ListNode(List.head_sentinel);
	}
	
	
	
	public void AddNode(ListNode node) {
		if (!this.IsNull(node)) {
			ListNode tail = this.GetTailNode();
			tail.next = node;
			this.IncreaseLength();
		}
	}
	
	public void InsertNodeAtIndex(ListNode node, int index) {
		if (!(this.IsNull(node) || this.IsNull(index))) {
			
			ListNode before = this.GetNode(index);
			if (before.next == null) {
				this.AddNode(node);
				
			} else {
				ListNode after = before.next;
				node.next = after;
				before.next = node;
				this.IncreaseLength();
			}
		}
	}
	
	
	
	public void DeleteTail() {
		ListNode node = this.GetNodeBeforeTail();
		node.next = null;
		this.DecreaseLength();
	}
	
	public void DeleteAtIndex(int index) {
		if (this.IsNull(index)) {
			ListNode before = this.GetNode(index - 1);
			ListNode after = before.next;
			before.next = after.next;
			this.DecreaseLength();
		}
	}
	
	
	
	private ListNode GetTailNode() {
		ListNode current = this.head;
		while (current.next != null) {
			current = current.next;
		}
		return current;
	}
	
	private ListNode GetNodeBeforeTail() {
		ListNode current = this.GetNode(this.length - 1);
		if (current == null) {
			return this.head;
		}
		return current;
	}
	
	/**
	 * 0    1   2   
	 * head one two null
	 * @param index 0 indexed index. 0 is the HEAD.
	 * @return A Node or null if it is not in range.
	 */
	private ListNode GetNode(int index) {
		if (this.IsIndexInRange(index)) {
			ListNode current = this.head;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
			return current;
		}
		this.ThrowException("Node index out of range.");
		return null;
	}
	

	
	private void IncreaseLength() {
		this.length++;
	}

	private void DecreaseLength() {
		this.length--;
	}
	
	
	
	private <T> boolean IsNull(T data) {
		if (data == null) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @param index Node index.
	 * @return True if between 0 and length.
	 */
	private boolean IsIndexInRange(int index) {
		if ((0 <= index) && (index <= this.length)) {
			return true;
		}
		return false;
	}

	
	
	private void ThrowException(String string) {
		try {
			throw new Exception(string);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		ListNode current = this.head;
		
		do {
			builder.append(current.string);
			builder.append("->");
			current = current.next;
		} while (current != null);
		builder.append(List.tail_sentinel);
		
		return builder.toString();
	}
}
