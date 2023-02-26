import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class RandomNumber extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RandomNumber frame = new RandomNumber();
					frame.setVisible(true);
					frame.setSize(400,200);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RandomNumber() {
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,1));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton guess = new JButton("Guess");
		
		JTextField guessNumber = new JTextField("");
		guessNumber.setHorizontalAlignment(SwingConstants.CENTER);

		panel.add(guessNumber);
		panel.add(guess);
		
		Random random = new Random();
		Integer randomNumber = random.nextInt(100);
		
		guess.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed (ActionEvent actionEvent) {
				
				try {
				
					Integer guess = Integer.valueOf(guessNumber.getText());
					
					if(guess == randomNumber) {
						JOptionPane.showMessageDialog(null,"You guessed the number");
					}
					else if(guess < randomNumber) {
						JOptionPane.showMessageDialog(null,"Your number is smaller than the random number");
					}
					else {
						JOptionPane.showMessageDialog(null,"Your number is greater than the random number");
					}
				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Inavlid format");
				
					}
			}
		});

		setContentPane(panel);
	}

}
