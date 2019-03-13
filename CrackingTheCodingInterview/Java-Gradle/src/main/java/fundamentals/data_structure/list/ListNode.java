package fundamentals.data_structure.list;

public class ListNode {
	public int data;
	public ListNode next;
	
	
	
	public ListNode(int data) {
		this.data = data;
	}
	
	
	
	@Override
	public String toString() {
		return "ListNode [data=" + data + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + data;
		result = prime * result + ((next == null) ? 0 : next.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListNode other = (ListNode) obj;
		if (data != other.data)
			return false;
		return true;
	}
}
