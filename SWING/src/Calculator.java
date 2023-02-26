import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Calculator extends JFrame {


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
					frame.setVisible(true);
					frame.setSize(400,400);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calculator() {
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(6, 2));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel firstNumber = new JLabel("First Number");
		JLabel secondNumber = new JLabel("Second Number");
		JLabel result = new JLabel("Result");
		
		JButton plus = new JButton("+");
		JButton minus = new JButton("-");
		JButton dalinti = new JButton("/");
		JButton dauginti = new JButton("*");
		JButton liekana = new JButton("%");
		JButton clear = new JButton("CLEAR");
		
		JTextField first = new JTextField("");
		JTextField second = new JTextField("");
		JTextField finalResult = new JTextField("");

		panel.add(firstNumber);
		panel.add(first);
		panel.add(secondNumber);
		panel.add(second);
		panel.add(result);
		panel.add(finalResult);
		panel.add(plus);
		panel.add(minus);
		panel.add(dauginti);
		panel.add(dalinti);
		panel.add(liekana);
		panel.add(clear);
		setContentPane(panel);
		
		plus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent actionEvent) {
				
				try {
				
					Double firstNum = Double.valueOf(first.getText());
					Double secNum = Double.valueOf(second.getText());
					
					Double result = firstNum + secNum;
					finalResult.setText(String.valueOf(result));
				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Invalid format");
				
					}
			}
		});
		
		minus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent actionEvent) {
				
				try {
				
					Double firstNum = Double.valueOf(first.getText());
					Double secNum = Double.valueOf(second.getText());
					
					Double result = firstNum - secNum;
					finalResult.setText(String.valueOf(result));
				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Invalid format");
				
					}
			}
		});
		
		dauginti.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent actionEvent) {
				
				try {
				
					Double firstNum = Double.valueOf(first.getText());
					Double secNum = Double.valueOf(second.getText());
					
					Double result = firstNum * secNum;
					finalResult.setText(String.valueOf(result));
				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Invalid format");
				
					}
			}
		});
		
		dalinti.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent actionEvent) {
				
				try {
				
					Double firstNum = Double.valueOf(first.getText());
					Double secNum = Double.valueOf(second.getText());
					
					if(secNum > 0) {
					Double result = firstNum / secNum;
					finalResult.setText(String.valueOf(result));
					
					}
					else if(secNum == 0) {
						JOptionPane.showMessageDialog(null, "Dalyba is nulio negalima");	
					}
				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Invalid format");
				
					}
			}
		});
		
		liekana.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent actionEvent) {
				
				try {
				
					Double firstNum = Double.valueOf(first.getText());
					Double secNum = Double.valueOf(second.getText());
					
					Double result = firstNum % secNum;
					finalResult.setText(String.valueOf(result));
				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Invalid format");
				
					}
			}
		});
		
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent actionEvent) {
				
				try {
				
					first.setText("");
					second.setText("");
					finalResult.setText("");

				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Invalid format");
				
					}
			}
		});

	}

}
