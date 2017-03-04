package eg.edu.alexu.csd.ds.maze.cs57;

public class nodeDouble {

	public nodeDouble next = null ;
	public nodeDouble prev = null ;
	public Object value ;
	
	
	public nodeDouble(Object element) {
		// TODO Auto-generated constructor stub
		this.value=element;
	}
	
	public nodeDouble(Object element , nodeDouble n , nodeDouble p) {
		// TODO Auto-generated constructor stub
		this.value=element;
		this.next=n;
		this.prev=p;
	}
	
	public nodeDouble getNext() {
		return next;
	}
	public void setNext(nodeDouble next) {
		this.next = next;
	}
	public nodeDouble getPrivious() {
		return prev;
	}
	public void setPrivious(nodeDouble privious) {
		this.prev = privious;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
	
	
	
}
