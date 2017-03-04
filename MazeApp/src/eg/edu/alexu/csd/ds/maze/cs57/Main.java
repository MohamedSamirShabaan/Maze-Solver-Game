package eg.edu.alexu.csd.ds.maze.cs57;
/*

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {

	public static node[][] grid;
	public static int Height, Width , Sx , Sy;
	public static char [][] originalGrid;

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
/////////////////////////////////////////////////Genertaor//////////////////////////////////////////////////////////////////////
		
		System.out.println("Enter The Board Size ");
		Height = input.nextInt();
		Width = input.nextInt();
		    	
	// initialization
		originalGrid = new char [Height][Width];
		for(int i = 0; i < Height ; i++){
			for (int j = 0 ; j < Width ; j++){
				originalGrid[i][j] = '#';
			}
		}
		
		Point S = new Point((int)(Math.random()*Height),(int)(Math.random()*Width),null);
		  originalGrid[S.r][S.c] = 'S';
		  Sx = S.r ; Sy = S.c;
		  MyLinkedList l = new Doubly();
		  
		  for (int i = -1 ; i < 2 ; i++){// check bounding Vertical and Horizontal 
			  for (int j = -1 ; j < 2 ; j++){
				if (i == 0 && j == 0 || i != 0 && j != 0) { // i == 0 && j == 0 >> the same Point
					continue;									// , i != 0 && j !=0 >> // diagonal test not matter
				}
				
				try{
        			if(originalGrid[S.r+i][S.c+j]=='.') continue;
        		}catch(Exception e){ // ignore ArrayIndexOutOfBounds
        			continue;
        		}
				
				l.add(new Point(S.r+i,S.c+j,S));// add point in List
				  
			}
		  }
		  
		 Point  last = null ; // to point to the position of E
		  while(!l.isEmpty()){ // repeat the previous method 
			  int s = (int)(Math.random()*l.size());// random point form list
			  Point bound = (Point) l.get(s) ; 
			  l.remove(s);
	          Point op = bound.opposite();
	          
	          try{
	        		// if both node and its opposite are walls
	        		if(originalGrid[bound.r][bound.c]=='#'){
	        			if(originalGrid[op.r][op.c]=='#'){
	 
	        				// open path between the nodes
	        				originalGrid[bound.r][bound.c]='.';
	        				originalGrid[op.r][op.c]='.';
	 
	        				// store last node in order to mark it later
	        				last = op;
	 
	        				 for (int i = -1 ; i < 2 ; i++){// check bounding Vertical and Horizontal 
	        					  for (int j = -1 ; j < 2 ; j++){
	        						if (i == 0 && j == 0 || i != 0 && j != 0) { // i == 0 && j == 0 >> the same Point
	        							continue;									// , i != 0 && j !=0 >> // diagonal test not matter
	        						}
	        						
	        						try{
	        		        			if(originalGrid[op.r+i][op.c+j]=='.') continue;
	        		        		}catch(Exception e){ // ignore ArrayIndexOutOfBounds
	        		        			continue;
	        		        		}
	        						
	        						l.add(new Point(op.r+i,op.c+j,op));// add point in List  
	        					}
	        				}
	        			}	
	        		}
	        	}catch(Exception e){ // ignore NullPointer and ArrayIndexOutOfBounds
	        	
	        	}
	 
	        	// if algorithm has resolved, mark end node
	        	if(l.isEmpty()){
	        		originalGrid[last.r][last.c]='E';
	        	}  
		  }
		  // print in fail
		  
		 
		try {
			 PrintWriter out = new PrintWriter("Heeba.txt");
			  out.println(Height + " " + Width);
			  for (int i = 0 ; i < Height ; i++){
				  for (int j = 0 ; j < Width ; ++j){
					 out.print(originalGrid[i][j]);
				  }
				  out.println();
			  }
			out.close();
			  
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	    	
		Scanner scanFile;

		try {
			scanFile = new Scanner(new File("Heeba.txt"));

			String convert = scanFile.nextLine();
			StringTokenizer token;
			token = new StringTokenizer(convert);
			Height = Integer.parseInt(token.nextToken());
			Width = Integer.parseInt(token.nextToken());

			grid = new node[Height][Width];

			String read = null;
			for (int i = 0; i < Height; i++) {
				read = scanFile.nextLine();
				for (int j = 0; j < Width; j++) {
					
					grid[i][j] = new node(read.charAt(j), i, j);
					System.out.print(grid[i][j].value);
				}
				System.out.println();
			}
			
		} catch (Exception e) {
			System.out.println("File Not Found");
		}

		/* setting 2D array to graph */
/*
		for (int i = 0; i < Height; i++) {
			for (int j = 0; j < Width; j++) {
				if (i == 0 && j == 0) {
					grid[i][j].set(null, grid[i][j + 1], null, grid[i + 1][j]);
				} else if (i == 0 && j == Width - 1) {
					grid[i][j].set(grid[i][j - 1], null, null, grid[i + 1][j]);
				} else if (i == Height - 1 && j == 0) {
					grid[i][j].set(null, grid[i][j + 1], grid[i - 1][j], null);
				} else if (i == Height - 1 && j == Width - 1) {
					grid[i][j].set(grid[i][j - 1], null, grid[i - 1][j], null);
				} else if (i == 0 && j != 0) {
					grid[i][j].set(grid[i][j - 1], grid[i][j + 1], null,grid[i + 1][j]);
				} else if (i != 0 && j == 0) {
					grid[i][j].set(null, grid[i][j + 1], grid[i - 1][j],grid[i + 1][j]);
				} else if (i == Height - 1 && j != Width - 1) {
					grid[i][j].set(grid[i][j - 1], grid[i][j + 1],grid[i - 1][j], null);
				} else if (i != Height - 1 && j == Width - 1) {
					grid[i][j].set(grid[i][j - 1], null, grid[i - 1][j],grid[i + 1][j]);
				} else {
					grid[i][j].set(grid[i][j - 1], grid[i][j + 1],grid[i - 1][j], grid[i + 1][j]);
				}
			}
		}
		
		
		
		System.out.println("chose a solution");
		System.out.println(" 1 - Stack");
		System.out.println(" 2 - Queue");
		
		String choose = input.next();
		
		Algorithms heeba = new Algorithms(Height, Width , grid[Sx][Sy], choose);
		heeba.solve();
		

		System.out.println();
		System.out.println();
		
		grid [Sx][Sy].value = 'S'; // to change * >>> S 

		for (int i = 0; i < Height; i++) {
			for (int j = 0; j < Width; j++) {
				System.out.print(grid[i][j].value);
			}
			System.out.println();
		}

	}

}
*/