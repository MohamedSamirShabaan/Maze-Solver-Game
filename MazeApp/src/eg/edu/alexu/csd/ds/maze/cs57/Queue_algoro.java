package eg.edu.alexu.csd.ds.maze.cs57;

public class Queue_algoro implements IMazeAlgoro{

	MyQueue q = new Queue_LinkedList();
	
	@Override
	public void add(Object elem) {
		// TODO Auto-generated method stub
		q.enqueue(elem);
	}

	@Override
	public Object remove() {
		// TODO Auto-generated method stub
		return q.dequeue() ;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return q.isEmpty();
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < q.size() ; i++){System.out.print(q.dequeue()+" ");}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return q.size();
	}

}
