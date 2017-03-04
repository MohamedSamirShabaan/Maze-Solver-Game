package eg.edu.alexu.csd.ds.maze.cs57;

public class Queue_LinkedList implements MyQueue{

	MyLinkedList list = new Doubly() ;
	
	@Override
	public void enqueue(Object item) {
		// TODO Auto-generated method stub
		list.add(list.size(), item);
	}

	@Override
	public Object dequeue() {
		// TODO Auto-generated method stub
		Object tmp = null ;
		if(isEmpty()){throw new RuntimeException();}
		else{
			tmp = list.get(0);
			list.remove(0);
		}
		return tmp ;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return list.isEmpty() ;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return list.size() ;
	}

}
