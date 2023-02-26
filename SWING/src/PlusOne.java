import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PlusOne extends JFrame implements ActionListener {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlusOne frame = new PlusOne();
					frame.setVisible(true);
					frame.setSize(600,600);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PlusOne() {
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,2));
		
		JButton button1 = new JButton("0");
		JButton button2 = new JButton("0");
		JButton button3 = new JButton("0");
		JButton button4 = new JButton("0");
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		setContentPane(panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton newButton = (JButton) e.getSource();
		
		Integer clickPlus = Integer.valueOf(newButton.getText())+1;
		
		newButton.setText(String.valueOf(clickPlus));

	}

}
