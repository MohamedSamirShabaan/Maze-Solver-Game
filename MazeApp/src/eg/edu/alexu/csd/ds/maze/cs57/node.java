package eg.edu.alexu.csd.ds.maze.cs57;


import javax.swing.JLabel;

public class node {

	public char  value ;
	public node left = null , rigth = null  , up = null  , down = null , parent = null ;
	public int x , y  ;
	int flag = 0 ;
	public JLabel panel ;
	
	
	
	public node(char value, int x, int y , JLabel panel) {
		this.value = value;
		this.x = x;
		this.y = y;
		this.panel=panel;
	}
	
	
	public void set(node left, node rigth, node up, node down) {
		this.left = left;
		this.rigth = rigth;
		this.up = up;
		this.down = down;
	}

	
	
	
}
