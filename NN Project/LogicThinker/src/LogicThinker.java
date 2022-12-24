import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class LogicThinker {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogicThinker window = new LogicThinker();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogicThinker() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JTextArea textArea = new JTextArea();
		textArea.setBounds(22, 30, 947, 48);
		frame.getContentPane().add(textArea);
		
		JLabel lblEnterYourStatement = new JLabel("Enter Your Statement here");
		lblEnterYourStatement.setBounds(12, 0, 219, 15);
		frame.getContentPane().add(lblEnterYourStatement);
		
		final JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(22, 163, 117, 93);
		frame.getContentPane().add(textArea_1);
		
		JLabel lblEnterTestcase = new JLabel("Enter testcase");
		lblEnterTestcase.setBounds(22, 136, 164, 15);
		frame.getContentPane().add(lblEnterTestcase);
		
		final JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(310, 163, 107, 93);
		frame.getContentPane().add(textArea_2);
		
		final JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(159, 163, 123, 93);
		frame.getContentPane().add(textArea_3);
		
		JButton btnGenerate = new JButton("Solve");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					textArea_2.setText(compute.getString(textArea.getText(),textArea_1.getText(),textArea_3.getText()));
				}
				catch(Exception e)
				{
					
				}
			}
		});
		btnGenerate.setBounds(174, 90, 117, 25);
		frame.getContentPane().add(btnGenerate);
		
		JLabel lblVariable = new JLabel("Variable");
		lblVariable.setBounds(161, 136, 70, 15);
		frame.getContentPane().add(lblVariable);
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setBounds(314, 136, 70, 15);
		frame.getContentPane().add(lblAnswer);
	}
}
