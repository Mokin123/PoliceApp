package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import view.Login;
import javax.swing.JLabel;
import model.AccidentReport;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Report {
	private AccidentReport ar;
	private JFrame frame;
	private Login login;
	private JTextField dateTx;
	private JTextField timeTx;
	private JTextField locTx;
	private ButtonGroup severityGroup;



	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		initialize();
	}

	public void initialize() {
		login = new Login();
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
		
//		RADIO buttons
		severityGroup = new ButtonGroup();
		
		JLabel severityLb = new JLabel("Severity :");
		severityLb.setBounds(10, 172, 61, 16);
		frame.getContentPane().add(severityLb);
		
		JRadioButton fatalRadio = new JRadioButton();
		fatalRadio.setBounds(68, 170, 28, 23);
		frame.getContentPane().add(fatalRadio);
		severityGroup.add(fatalRadio);
		
		JRadioButton severeRadio = new JRadioButton();
		severeRadio.setBounds(118, 170, 28, 23);
		frame.getContentPane().add(severeRadio);
		severityGroup.add(severeRadio);
		
		JRadioButton moderateRadio = new JRadioButton();
		moderateRadio.setBounds(168, 170, 28, 23);
		frame.getContentPane().add(moderateRadio);
		severityGroup.add(moderateRadio);
		
		JRadioButton lightRadio = new JRadioButton();
		lightRadio.setBounds(218, 170, 28, 23);
		frame.getContentPane().add(lightRadio);
		severityGroup.add(lightRadio);
		
		JLabel fatalLb = new JLabel("fatal");
		fatalLb.setBounds(70, 193, 28, 16);
		frame.getContentPane().add(fatalLb);
		fatalLb.setFont(new Font(fatalLb.getName(), Font.PLAIN, 10));

		JLabel severeLb = new JLabel("severe");
		severeLb.setBounds(117, 193, 37, 16);
		frame.getContentPane().add(severeLb);
		severeLb.setFont(new Font(severeLb.getName(), Font.PLAIN, 10));

		JLabel moderateLb = new JLabel("moderate");
		moderateLb.setBounds(159, 193, 52, 16);
		frame.getContentPane().add(moderateLb);
		moderateLb.setFont(new Font(moderateLb.getName(), Font.PLAIN, 10));

		JLabel lightLb = new JLabel("light");
		lightLb.setBounds(222, 193, 28, 16);
		frame.getContentPane().add(lightLb);
		lightLb.setFont(new Font(lightLb.getName(), Font.PLAIN, 10));
		
		
//		Parties involved
		JLabel typeLb = new JLabel("New label");
		typeLb.setBounds(6, 216, 61, 16);
		frame.getContentPane().add(typeLb);

		
		
	}
}
