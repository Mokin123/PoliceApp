package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import view.Login;
import javax.swing.JLabel;
import model.AccidentReport;

public class Report {
	private AccidentReport ar;
	private JFrame frame;


	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		initialize();
	}

	/**
	 * Create the application.
	 */
	

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		ar = new AccidentReport();
		frame = new JFrame();
		frame.setVisible(true);

		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 284, 573);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("Report Accident");
		titleLabel.setFont(new Font(titleLabel.getName(), Font.PLAIN, 24));

		titleLabel.setBounds(43, 33, 192, 46);
		frame.getContentPane().add(titleLabel);
		
		JLabel dateLb = new JLabel("Date :");
		dateLb.setBounds(6, 90, 61, 16);
		frame.getContentPane().add(dateLb);
		dateLb.setText(ar.getDate());
	}
}
