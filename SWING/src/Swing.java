import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class Swing extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

					Swing frame = new Swing();
					frame.setSize(600,200);
					frame.setVisible(true);

				}

	/**
	 * Create the frame.
	 */
	public Swing() {
		super("Title");
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,2));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel celsius = new JLabel("Celsius");
		celsius.setHorizontalAlignment(SwingConstants.CENTER);
		JTextField textField1 = new JTextField("");
		textField1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel fahrenheit = new JLabel("Fahrenheit");
		fahrenheit.setHorizontalAlignment(SwingConstants.CENTER);
		JTextField textField2 = new JTextField("");
		textField2.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		JButton button1 = new JButton("Celsius -> Fahrenheit");
		JButton button2 = new JButton("Fahrenheit -> Celsius");
		
		panel.add(celsius);
		panel.add(textField1);
		panel.add(fahrenheit);
		panel.add(textField2);
		panel.add(button1);
		panel.add(button2);
		
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent actionEvent) {
				
				try {
				Double celsius = Double.valueOf(textField1.getText());
				Double fahrenheit = celsius*1.8 +32;
				textField2.setText(String.valueOf(fahrenheit));;
				}
				catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Inavlid format");
			
				}
			}
		});
		

		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent actionEvent) {
				
				try {
					
				Double fahrenheit = Double.valueOf(textField2.getText());
				Double celsius = (fahrenheit-32)/1.8;
				textField1.setText(String.valueOf(celsius));
				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Inavlid format");
				
					}
			}
		});

		setContentPane(panel);
	}

}
