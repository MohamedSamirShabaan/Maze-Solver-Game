package eg.edu.alexu.csd.ds.maze.cs57;

import java.util.EmptyStackException;


public class Stack_imp implements MyStack{

	private int size = 0 ;
	private MyLinkedList list = new Doubly();
	
	public Stack_imp(){
		this.size = 0 ;
		this.list = new Doubly();
	}
	
	
	
	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub
		list.add(index, element);
		size++;
	}

	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		Object ret = null ;
		try {
			ret = list.get(size-1);
			list.remove(size-1);
			size--;
		} catch (Exception e) {
			// TODO: handle exception
			throw new EmptyStackException();
		}
		return ret;
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		if(size<=0){return null;}
		return list.get(size-1);
	}

	@Override
	public void push(Object element) {
		// TODO Auto-generated method stub
		list.add(element);
		size++;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0 ;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

}
