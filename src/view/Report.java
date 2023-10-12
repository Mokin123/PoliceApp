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
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class Report {
	private AccidentReport ar;
	private JFrame frame;
	private JTextField dateTx;
	private JTextField timeTx;
	private JTextField locTx;


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
		dateLb.setBounds(10, 91, 128, 16);
		frame.getContentPane().add(dateLb);
		
		dateTx = new JTextField();
		dateTx.setBounds(53, 86, 156, 26);
		frame.getContentPane().add(dateTx);
		dateTx.setColumns(10);
		dateTx.setText("YYYY/MM/DD");
		
		JButton dateAuto = new JButton("Auto");
		dateAuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dateTx.setText(ar.generateDate());
			}
		});
		dateAuto.setBounds(224, 86, 54, 29);
		frame.getContentPane().add(dateAuto);
		
		JLabel timeLb = new JLabel("Time :");
		timeLb.setBounds(10, 119, 61, 16);
		frame.getContentPane().add(timeLb);
		
		timeTx = new JTextField();
		timeTx.setBounds(53, 114, 156, 26);
		frame.getContentPane().add(timeTx);
		timeTx.setColumns(10);
		timeTx.setText("HH:mm");
		
		JButton timeAuto = new JButton("Auto");
		timeAuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timeTx.setText(ar.generateTime());
			}
		});
		timeAuto.setBounds(224, 114, 54, 29);
		frame.getContentPane().add(timeAuto);
		
		JLabel locLb = new JLabel("Location :");
		locLb.setBounds(10, 147, 68, 16);
		frame.getContentPane().add(locLb);
		
		locTx = new JTextField();
		locTx.setBounds(79, 142, 192, 26);
		frame.getContentPane().add(locTx);
		locTx.setColumns(10);
		locTx.setText("Location...");
		
		JRadioButton fatalRadio = new JRadioButton();
		fatalRadio.setBounds(68, 165, 28, 23);
		frame.getContentPane().add(fatalRadio);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(43, 223, 61, 16);
		frame.getContentPane().add(lblNewLabel);
		
		
	}
}
