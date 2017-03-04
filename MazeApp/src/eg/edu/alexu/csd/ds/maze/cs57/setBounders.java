package eg.edu.alexu.csd.ds.maze.cs57;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class setBounders extends JDialog {

	private JTextField textFieldW;
	private JTextField textFieldH;
	public int Height, Width ;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			setBounders dialog = new setBounders();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public setBounders() {
		setBounds(100, 100, 581, 448);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			
			JLabel lblWidth = new JLabel("width:");
			lblWidth.setForeground(new Color(240, 128, 128));
			lblWidth.setBounds(10, 14, 65, 14);
			contentPanel.add(lblWidth);
			
			textFieldW = new JTextField();
			textFieldW.setForeground(Color.PINK);
			textFieldW.setText("50");
			textFieldW.setBackground(Color.DARK_GRAY);
			textFieldW.setBounds(47, 11, 86, 20);
			contentPanel.add(textFieldW);
			textFieldW.setColumns(10);	
			
			JLabel lblHeight = new JLabel("Height:");
			lblHeight.setForeground(new Color(240, 128, 128));
			lblHeight.setBounds(143, 14, 59, 14);
			contentPanel.add(lblHeight);
			
			textFieldH = new JTextField();
			textFieldH.setForeground(Color.PINK);
			textFieldH.setText("25");
			textFieldH.setBackground(Color.DARK_GRAY);
			textFieldH.setBounds(185, 11, 86, 20);
			contentPanel.add(textFieldH);
			textFieldH.setColumns(10);	
		
	
			}
		
		
		{
			JButton okButton = new JButton("OK");
			okButton.setBounds(384, 10, 53, 23);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			if(textFieldW.getText().isEmpty()||textFieldH.getText().isEmpty()){
				JOptionPane optionPane = new JOptionPane("ErrorMsg", JOptionPane.ERROR_MESSAGE); 
				JDialog dialog = optionPane.createDialog("Failure");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
			}else{
				int x = (int)Integer.valueOf(textField.getText());
				Height = (int)Integer.valueOf(textFieldW.getText());
				Width = (int)Integer.valueOf(textFieldH.getText());
				dispose();
				UserInterFace Unew = new UserInterFace(Height,Width,x);
				Unew.setVisible(true);
			}
			
		}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			JButton cancelButton = new JButton("Cancel");
			cancelButton.setBounds(447, 10, 77, 23);
			contentPanel.add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setActionCommand("Cancel");
		}
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(296, 128, 191, 246);
		contentPanel.add(panel);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("man.png"));
		lblNewLabel_3.setBackground(Color.BLACK);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(80, 128, 173, 246);
		contentPanel.add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBackground(new Color(0, 0, 0));
		lblNewLabel_2.setIcon(new ImageIcon("woman2.png"));
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		panel_2.setBounds(129, 86, 277, 45);
		contentPanel.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("Help them to get married");
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setForeground(Color.PINK);
		lblNewLabel.setBackground(Color.BLACK);
		panel_2.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setToolTipText("");
		panel_3.setForeground(Color.PINK);
		panel_3.setBackground(Color.BLACK);
		panel_3.setBounds(129, 42, 277, 45);
		contentPanel.add(panel_3);
		
		JLabel lblNewLabel_1 = new JLabel("WELCOME");
		lblNewLabel_1.setFont(new Font("Colbert", Font.BOLD | Font.ITALIC, 27));
		lblNewLabel_1.setForeground(Color.PINK);
		lblNewLabel_1.setBackground(Color.BLACK);
		panel_3.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setText("0");
		textField.setForeground(Color.PINK);
		textField.setBackground(Color.DARK_GRAY);
		textField.setBounds(332, 11, 42, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("level :");
		lblNewLabel_4.setForeground(new Color(250, 128, 114));
		lblNewLabel_4.setBackground(Color.BLACK);
		lblNewLabel_4.setBounds(281, 14, 46, 14);
		contentPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Level 0 means Random Game");
		lblNewLabel_5.setBackground(new Color(0, 0, 0));
		lblNewLabel_5.setForeground(new Color(250, 128, 114));
		lblNewLabel_5.setBounds(185, 384, 199, 14);
		contentPanel.add(lblNewLabel_5);
		}
	}


