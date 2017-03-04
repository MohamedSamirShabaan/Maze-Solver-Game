package eg.edu.alexu.csd.ds.maze.cs57;

public class Algorithms {
	
	//IMazeAlgoro  s = new Queue_algoro();
	//IMazeAlgoro  s = new Stack_algoro();
	
	
	public String sol ;
	public int x , y  ; 
	public node start  = null ;
	boolean [][]visited;
	IMazeAlgoro s ;
	
	public Algorithms(int x, int y, node start, String sol){
		this.x = x;
		this.y = y;
		this.start = start;
		this.sol = sol ;
		try {
			Class<?> newClass = Class.forName("eg.edu.alexu.csd.ds.maze.cs57."+sol+"_algoro");
			try {
				s = (IMazeAlgoro)newClass.newInstance() ;
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
		}
		
		visited = new boolean[x][y] ;
	}
	
	public void solve(char c){
		s.add(start);
		visited[start.x][start.y] = true ;
		while(!s.isEmpty()){
			node temp = (node) s.remove();
			//if(temp.value!='s'||temp.value!='E'){temp.value='.';}
			visited[temp.x][temp.y] = true ;
			if(temp.value==c){break;}
			
			if(temp.up!=null&&temp.up.value!='#'
					&&temp.up.value!='G'
					&&visited[temp.up.x][temp.up.y]==false
					&&temp.up.x>=0&&temp.up.x<this.x
					&&temp.up.y>=0&&temp.up.y<this.y)
			{s.add(temp.up); temp.value='*'; temp.up.parent=temp; temp.flag++;}
			
			if(temp.left!=null&&temp.left.value!='#'
					&&temp.left.value!='G'
					&&visited[temp.left.x][temp.left.y]==false
					&&temp.left.x>=0&&temp.left.x<this.x
					&&temp.left.y>=0&&temp.left.y<this.y)
			{s.add(temp.left); temp.value='*'; temp.left.parent=temp; temp.flag++;}
			
			if(temp.rigth!=null&&temp.rigth.value!='#'
					&&temp.rigth.value!='G'
					&&visited[temp.rigth.x][temp.rigth.y]==false
					&&temp.rigth.x>=0&&temp.rigth.x<this.x
					&&temp.rigth.y>=0&&temp.rigth.y<this.y)
			{s.add(temp.rigth); temp.value='*'; temp.rigth.parent=temp; temp.flag++;}
			
			if(temp.down!=null&&temp.down.value!='#'
					&&temp.down.value!='G'
					&&visited[temp.down.x][temp.down.y]==false
					&&temp.down.x>=0&&temp.down.x<this.x
					&&temp.down.y>=0&&temp.down.y<this.y)
			{s.add(temp.down); temp.value='*'; temp.down.parent=temp; temp.flag++;}
			
			
			while(temp.flag==0){
				temp.value='.';
				temp.parent.flag--;
				temp=temp.parent;
			}
		}
		
		while(!s.isEmpty()){
			node ttt = (node) s.remove();
		//	System.out.println(ttt.value+" "+ttt.x+"  "+ttt.y);
			while(ttt.flag==0){
				ttt.value='.';
				ttt.parent.flag--;
				ttt=ttt.parent;
			}
		}
	}	
}
