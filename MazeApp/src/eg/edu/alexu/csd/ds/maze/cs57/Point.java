package eg.edu.alexu.csd.ds.maze.cs57;

public class Point {
	Integer r;
	Integer c;
	Point parent;
	
	public Point(int x, int y, Point p){
		r=x;c=y;parent=p;
	}
	
	public Point opposite() {
		if (this.r.compareTo(parent.r) != 0)
			return new Point(this.r + this.r.compareTo(parent.r), this.c, this);
		if (this.c.compareTo(parent.c) != 0)
			return new Point(this.r, this.c + this.c.compareTo(parent.c), this);
		return null;
	}
}
