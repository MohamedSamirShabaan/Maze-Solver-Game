package eg.edu.alexu.csd.ds.maze.cs57;

public class Stack_algoro implements IMazeAlgoro{

	MyStack s = new Stack_imp();
	
	@Override
	public void add(Object elem) {
		// TODO Auto-generated method stub
		s.push(elem);
	}

	@Override
	public Object remove() {
		// TODO Auto-generated method stub
		return s.pop() ;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return s.isEmpty();
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < s.size() ;i++){System.out.print(s.pop()+" ");}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return s.size() ;
	}

}
