package eg.edu.alexu.csd.ds.maze.cs57;

import java.awt.BorderLayout;










import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.awt.Font;

import javax.swing.JTextField;



@SuppressWarnings("serial")
public class UserInterFace extends JFrame {

	public static node[][] grid;
	public int  Sx, Sy , gx ,gy,Kx ,Ky ;
	public static char[][] originalGrid;
	boolean flag = false , fmove = false;
	String choose = null ;
	static Scanner input = new Scanner(System.in);
	public int H , W ;
	public JPanel panel_1 ; 
	private JPanel contentPane;
	private JTextField txtQueueuOrStack;
	
	private class MyKeyHandler extends KeyAdapter{
		public void keyPressed (KeyEvent theEvent){
			switch (theEvent.getKeyCode()){
				case KeyEvent.VK_UP:{
					try {
						if(grid[Sx][Sy-1].value=='K'){grid[gx][gy].value='.'; grid[gx][gy].panel.setIcon(new ImageIcon("empty.png"));flag = true ;fmove =true;}
						if(grid[Sx][Sy-1].value=='E'){
							JOptionPane optionPane = new JOptionPane("���� ���� ���� :D", JOptionPane.INFORMATION_MESSAGE); 
							JDialog dialog = optionPane.createDialog("Congratulations");
							dialog.setAlwaysOnTop(true);
							dialog.setVisible(true);
						}
						else if(grid[Sx][Sy-1]!=null&&grid[Sx][Sy-1].value!='#'&&grid[Sx][Sy-1].value!='G'&&Sx>=0&&Sx<H&&Sy-1>=0&&Sy-1<W){
							grid[Sx][Sy-1].panel.setIcon(new ImageIcon("start2.png"));
							grid[Sx][Sy].panel.setIcon(new ImageIcon("empty.png"));
							Sy--;
						}else {break;}
						break;
					} catch (Exception e) {
						// TODO: handle exception
					}
					
				}
				case KeyEvent.VK_LEFT:{
					try {
						if(grid[Sx-1][Sy].value=='K'){grid[gx][gy].value='.';grid[gx][gy].panel.setIcon(new ImageIcon("empty.png"));flag = true ;fmove =true;}
						if(grid[Sx-1][Sy].value=='E'){
							JOptionPane optionPane = new JOptionPane("���� ���� ���� :D", JOptionPane.INFORMATION_MESSAGE); 
							JDialog dialog = optionPane.createDialog("Congratulations");
							dialog.setAlwaysOnTop(true);
							dialog.setVisible(true);
						}
						else if(grid[Sx-1][Sy]!=null&&grid[Sx-1][Sy].value!='#'&&grid[Sx-1][Sy].value!='G'&&Sx-1>=0&&Sx-1<H&&Sy>=0&&Sy<W){
							grid[Sx-1][Sy].panel.setIcon(new ImageIcon("start2.png"));
							grid[Sx][Sy].panel.setIcon(new ImageIcon("empty.png"));
							Sx--;
						}else {break;}
						break;
					} catch (Exception e) {
						// TODO: handle exception
					}
					
				}
				case KeyEvent.VK_DOWN:{
					try {
						if(grid[Sx][Sy+1].value=='K'){grid[gx][gy].value='.';grid[gx][gy].panel.setIcon(new ImageIcon("empty.png"));flag = true ;fmove =true;}
						if(grid[Sx][Sy+1].value=='E'){
							JOptionPane optionPane = new JOptionPane("���� ���� ���� :D", JOptionPane.INFORMATION_MESSAGE); 
							JDialog dialog = optionPane.createDialog("Congratulations");
							dialog.setAlwaysOnTop(true);
							dialog.setVisible(true);
						}
						else if(grid[Sx][Sy+1]!=null&&grid[Sx][Sy+1].value!='#'&&grid[Sx][Sy+1].value!='G'&&Sx>=0&&Sx<H&&Sy+1>=0&&Sy+1<W){
							grid[Sx][Sy+1].panel.setIcon(new ImageIcon("start2.png"));
							grid[Sx][Sy].panel.setIcon(new ImageIcon("empty.png"));
							Sy++;
						}else{break;}
						break;
					} catch (Exception e) {
						// TODO: handle exception
					}
					
				}
				case KeyEvent.VK_RIGHT:{
					try {
						if(grid[Sx+1][Sy].value=='K'){grid[gx][gy].value='.';grid[gx][gy].panel.setIcon(new ImageIcon("empty.png"));flag = true ;fmove =true;}
						if(grid[Sx+1][Sy].value=='E'){
							JOptionPane optionPane = new JOptionPane("���� ���� ���� :D", JOptionPane.INFORMATION_MESSAGE); 
							JDialog dialog = optionPane.createDialog("Congratulations");
							dialog.setAlwaysOnTop(true);
							dialog.setVisible(true);
						}
						else if(grid[Sx+1][Sy]!=null&&grid[Sx+1][Sy].value!='#'&&grid[Sx+1][Sy].value!='G'&&Sx+1>=0&&Sx+1<H&&Sy>=0&&Sy<W){
							grid[Sx+1][Sy].panel.setIcon(new ImageIcon("start2.png"));
							grid[Sx][Sy].panel.setIcon(new ImageIcon("empty.png"));
							Sx++;
						}else{break;}
						break;
					} catch (Exception e) {
						// TODO: handle exception
					}
					
				}
			}
		}
	}
	
	
	/**
	 * Launch the application.
	 */
	
	
	/**
	 * Create the frame.
	 */
	
	
	
	public UserInterFace(int Height , int Width , int x ) {
		setTitle("MAZE");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(35, 5,Height*25+25, Width*25+85);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		H=Height;
		W=Width;
		/* setting buttons panel */
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		contentPane.add(panel, BorderLayout.NORTH);
		
		/* generating the maze  */
		
		generation(Height, Width);

		/* setting grid panel */
				
			panel_1 = new JPanel();
			panel_1.setBorder(null);
			panel_1.setBackground(Color.BLACK);
			contentPane.add(panel_1, BorderLayout.CENTER);
			GridBagLayout gbl_panel_1 = new GridBagLayout();
			gbl_panel_1.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
					Double.MIN_VALUE };
			gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			panel_1.setLayout(gbl_panel_1);
				
			/* setting moving keys */
				
			panel.addKeyListener(new MyKeyHandler());
			panel.setFocusable(true);
			panel.requestFocusInWindow();
				
			/*	Reading from the file & printing the grid	*/
			
			
				printing(Height, Width,x);
			
				/*	setting buttons actions   */
				
				JButton btnNewButton_2 = new JButton("New Game");
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
						setBounders newGame = new setBounders();
						newGame.setVisible(true);
					}
				});
				btnNewButton_2.setFont(new Font("AR CENA", Font.ITALIC, 15));
				panel.add(btnNewButton_2);

				txtQueueuOrStack = new JTextField();
				txtQueueuOrStack.setText("Stack/Queue");
				txtQueueuOrStack.setBackground(Color.LIGHT_GRAY);
				panel.add(txtQueueuOrStack);
				txtQueueuOrStack.setColumns(10);
				
				int h = Height ;
				int w = Width ;
				
				JButton btnNewButton_1 = new JButton("solve Key");
				btnNewButton_1.setFont(new Font("AR CENA", Font.ITALIC, 15));
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(grid[gx][gy].value=='G'){
							if(txtQueueuOrStack.getText().isEmpty()){
								JOptionPane optionPane = new JOptionPane("ErrorMsg", JOptionPane.ERROR_MESSAGE); 
								JDialog dialog = optionPane.createDialog("Failure");
								dialog.setAlwaysOnTop(true);
								dialog.setVisible(true);
							}
							else{choose = txtQueueuOrStack.getText();}
							try {
								Algorithms heeba = new Algorithms(h ,w , grid[Sx][Sy], choose);
								heeba.solve('K');
								grid[gx][gy].value='.';
								grid[gx][gy].panel.setIcon(new ImageIcon("empty.png"));
								flag = true ;
								grid[Sx][Sy].value = 'S'; // to change * >>> S
								for (int i = 0; i < h; i++) {
									for (int j = 0; j < w; j++) {
										if(grid[i][j].value=='.'){
											grid[i][j].panel.setIcon(new ImageIcon("empty.png"));
										}
										else if(grid[i][j].value=='*'){
											grid[i][j].panel.setIcon(new ImageIcon("dote.png"));
										}
									}
								}
							} catch (Exception e) {
								// TODO: handle exception
							}
							
						}
						}
				});
				panel.add(btnNewButton_1);
				
				JButton btnNewButton_3 = new JButton("solve Girl");
				btnNewButton_3.setFont(new Font("AR CENA", Font.ITALIC, 15));
				btnNewButton_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(flag){
							if(txtQueueuOrStack.getText().isEmpty()){
								JOptionPane optionPane = new JOptionPane("ErrorMsg", JOptionPane.ERROR_MESSAGE); 
								JDialog dialog = optionPane.createDialog("Failure");
								dialog.setAlwaysOnTop(true);
								dialog.setVisible(true);
							}
							else{choose = txtQueueuOrStack.getText();}
							try {								
								Algorithms heeba = new Algorithms(h ,w , grid[Sx][Sy], choose);
								heeba.solve('E');
								grid[Sx][Sy].value = 'S'; // to change * >>> S
								for (int i = 0; i < h; i++) {
									for (int j = 0; j < w; j++) {
										if(grid[i][j].value=='.'){
											grid[i][j].panel.setIcon(new ImageIcon("empty.png"));
										}
										else if(grid[i][j].value=='*'){
											grid[i][j].panel.setIcon(new ImageIcon("heart.png"));
										}
									}
								}
								if(!(Kx==Sx&&Ky==Sy)&&!fmove){
									grid[Kx][Ky].value = 'K';
									grid[Kx][Ky].panel.setIcon(new ImageIcon("key.png"));
								}
							} catch (Exception e) {
								// TODO: handle exception
							}
							
						}
					}
				});
				panel.add(btnNewButton_3);
				

	}
	
	public void printing(int Height , int Width , int x  ){

		Scanner scanFile;

		try {
			scanFile = new Scanner(new File("Level"+x+".txt"));

			String convert = scanFile.nextLine();
			StringTokenizer token;
			token = new StringTokenizer(convert);
			Height = Integer.parseInt(token.nextToken());
			Width = Integer.parseInt(token.nextToken());

			grid = new node[Height][Width];

			int wall = (int) (Math.random()*7);
			String read = null;
			JLabel lblNewLabel = null ;
			for (int i = 0; i < Height; i++) {
				read = scanFile.nextLine();
				for (int j = 0; j < Width; j++) {
					char c = read.charAt(j);
					if(c=='#'){
						lblNewLabel = new JLabel("");
						GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
						gbc_lblNewLabel.gridx = i;
						gbc_lblNewLabel.gridy = j;
						panel_1.add(lblNewLabel, gbc_lblNewLabel);
						int randomWall = (int) (Math.random()*4);
						if(wall>=4){
							randomWall= (int) (Math.random()*4);
							lblNewLabel.setIcon(new ImageIcon("wall"+randomWall+".png"));	
						}else{
							randomWall=wall;
							lblNewLabel.setIcon(new ImageIcon("wall"+randomWall+".png"));	
						}
					}
					else if(c=='.'){
						lblNewLabel = new JLabel("");
						lblNewLabel.setIcon(new ImageIcon("empty.png"));
						GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
						gbc_lblNewLabel.gridx = i;
						gbc_lblNewLabel.gridy = j;
						panel_1.add(lblNewLabel, gbc_lblNewLabel);
					}
					else if(c=='S'){
						lblNewLabel = new JLabel("");
						lblNewLabel.setIcon(new ImageIcon("start2.png"));
						GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
						gbc_lblNewLabel.gridx = i;
						gbc_lblNewLabel.gridy = j;
						Sx=i;
						Sy=j;
						panel_1.add(lblNewLabel, gbc_lblNewLabel);
					}
					else if(c=='K'){
						lblNewLabel = new JLabel("");
						lblNewLabel.setIcon(new ImageIcon("key.png"));
						GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
						gbc_lblNewLabel.gridx = i;
						gbc_lblNewLabel.gridy = j;
						Kx=i;
						Ky=j;
						panel_1.add(lblNewLabel, gbc_lblNewLabel);
					}
					else if(c=='G'){
						lblNewLabel = new JLabel("");
						lblNewLabel.setIcon(new ImageIcon("gate.png"));
						GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
						gbc_lblNewLabel.gridx = i;
						gbc_lblNewLabel.gridy = j;
						gx=i;
						gy=j;
						panel_1.add(lblNewLabel, gbc_lblNewLabel);
					}
					else if(c=='E'){
						lblNewLabel = new JLabel("");
						lblNewLabel.setIcon(new ImageIcon("end5.png"));
						GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
						gbc_lblNewLabel.gridx = i;
						gbc_lblNewLabel.gridy = j;
						panel_1.add(lblNewLabel, gbc_lblNewLabel);
					}
					grid[i][j] = new node(c, i, j,lblNewLabel);
				}
			}
		} catch (Exception e) {
			JOptionPane optionPane = new JOptionPane("file not found!!", JOptionPane.ERROR_MESSAGE); 
			JDialog dialog = optionPane.createDialog("Error");
			dialog.setAlwaysOnTop(true);
			dialog.setVisible(true);
			System.exit(0);
		}

			/* setting 2D array to graph */

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
						grid[i][j].set(grid[i][j - 1], grid[i][j + 1], null,
								grid[i + 1][j]);
					} else if (i != 0 && j == 0) {
						grid[i][j].set(null, grid[i][j + 1], grid[i - 1][j],
								grid[i + 1][j]);
					} else if (i == Height - 1 && j != Width - 1) {
						grid[i][j].set(grid[i][j - 1], grid[i][j + 1],
								grid[i - 1][j], null);
					} else if (i != Height - 1 && j == Width - 1) {
						grid[i][j].set(grid[i][j - 1], null, grid[i - 1][j],
								grid[i + 1][j]);
					} else {
						grid[i][j].set(grid[i][j - 1], grid[i][j + 1],
								grid[i - 1][j], grid[i + 1][j]);
					}
				}
			}

	}

	public void generation(int Height , int Width ){

		// initialization
		originalGrid = new char[Height][Width];
		for (int i = 0; i < Height; i++) {
			for (int j = 0; j < Width; j++) {
				originalGrid[i][j] = '#';
			}
		}

		Point S = new Point((int) (Math.random() * Height),
				(int) (Math.random() * Width), null);
		originalGrid[S.r][S.c] = 'S';
		Sx = S.r;
		Sy = S.c;
		MyLinkedList l = new Doubly();

		for (int i = -1; i < 2; i++) {// check bounding Vertical and Horizontal
			for (int j = -1; j < 2; j++) {
				if (i == 0 && j == 0 || i != 0 && j != 0) { // i == 0 && j == 0
															// >> the same Point
					continue; // , i != 0 && j !=0 >> // diagonal test not
								// matter
				}

				try {
					if (originalGrid[S.r + i][S.c + j] == '.')
						continue;
				} catch (Exception e) { // ignore ArrayIndexOutOfBounds
					continue;
				}

				l.add(new Point(S.r + i, S.c + j, S));// add point in List

			}
		}

		Point last = null; // to point to the position of E
		while (!l.isEmpty()) { // repeat the previous method
			int s = (int) (Math.random() * l.size());// random point form list
			Point bound = (Point) l.get(s);
			l.remove(s);
			Point op = bound.opposite();

			try {
				// if both node and its opposite are walls
				if (originalGrid[bound.r][bound.c] == '#') {
					if (originalGrid[op.r][op.c] == '#') {

						// open path between the nodes
						originalGrid[bound.r][bound.c] = '.';
						originalGrid[op.r][op.c] = '.';

						// store last node in order to mark it later
						last = op;

						for (int i = -1; i < 2; i++) {// check bounding Vertical
														// and Horizontal
							for (int j = -1; j < 2; j++) {
								if (i == 0 && j == 0 || i != 0 && j != 0) { // i
																			// ==
																			// 0
																			// &&
																			// j
																			// ==
																			// 0
																			// >>
																			// the
																			// same
																			// Point
									continue; // , i != 0 && j !=0 >> //
												// diagonal test not matter
								}

								try {
									if (originalGrid[op.r + i][op.c + j] == '.')
										continue;
								} catch (Exception e) { // ignore
														// ArrayIndexOutOfBounds
									continue;
								}

								l.add(new Point(op.r + i, op.c + j, op));// add
																			// point
																			// in
																			// List
							}
						}
					}
				}
			} catch (Exception e) { // ignore NullPointer and
									// ArrayIndexOutOfBounds

			}

			// if algorithm has resolved, mark end node
			try {
				if (l.isEmpty()) {
					originalGrid[last.r][last.c] = 'E';
					gx=last.r;
					gy=last.c;
					if(last.r>=0&&last.r<H&&last.c-1>=0&&last.c-1<W&&originalGrid[last.r][last.c-1]=='.'){originalGrid[last.r][last.c-1]='G';gy--;}
					else if(last.r>=0&&last.r<H&&last.c+1>=0&&last.c+1<W&&originalGrid[last.r][last.c+1]=='.'){originalGrid[last.r][last.c+1]='G';gy++;}
					else if(last.r+1>=0&&last.r+1<H&&last.c>=0&&last.c<W&&originalGrid[last.r+1][last.c]=='.'){originalGrid[last.r+1][last.c]='G';gx++;}
					else if(last.r-1>=0&&last.r-1<H&&last.c>=0&&last.c<W&&originalGrid[last.r-1][last.c]=='.'){originalGrid[last.r-1][last.c]='G';gx--;}
					do{
					Kx=(int)((int)(H-1)*Math.random());
					Ky=(int)((int)(W-1)*Math.random());
					}while(originalGrid[Kx][Ky]=='#'||originalGrid[Sx][Sy]=='#'||originalGrid[last.r][last.c]=='#');
					originalGrid[Kx][Ky]='K';
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		// print in fail

		try {
			PrintWriter out = new PrintWriter("Level0.txt");
			out.println(Height + " " + Width);
			for (int i = 0; i < Height; i++) {
				for (int j = 0; j < Width; ++j) {
					out.print(originalGrid[i][j]);
				}
				out.println();
			}
			out.close();

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	} 
	
	
}
