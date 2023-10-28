package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import model.AccidentReport;
import model.UserManager;
import javax.swing.JScrollBar;
import java.awt.Scrollbar;
import java.awt.Label;

public class MainView {
//	Importing class user as "u"
	

	private JFrame frame;
	private UserManager um;
	private AccidentReport ar;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public MainView() {
		ar = new AccidentReport();
		um = new UserManager();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 284, 573);
		frame.setLocation(570, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final CardLayout cLayout = new CardLayout(0,0);
		frame.getContentPane().setLayout(cLayout);
		

//		loginPanel ---- 
		JPanel loginPanel = new JPanel();
		loginPanel.setForeground(new Color(0, 0, 0));
		loginPanel.setBounds(0, 0, 284, 573);
		frame.getContentPane().add(loginPanel,"name_loginPanel");
		loginPanel.setLayout(null);
//		Username Labels:
		JLabel UNLabel = new JLabel("Username :");
		UNLabel.setFont(new Font("Dialog", Font.PLAIN, 24));
		UNLabel.setBounds(17, 266, 145, 56);
		loginPanel.add(UNLabel);
//		Username textfield:
		final JTextField unText = new JTextField();
		unText.setBackground(new Color(128, 128, 128));
		unText.setBounds(17, 321, 246, 49);
		unText.setColumns(10);
		loginPanel.add(unText);
//		Password Label:
		JLabel pwLabel = new JLabel("password :");
		pwLabel.setFont(new Font("Dialog", Font.PLAIN, 24));
		pwLabel.setBounds(17, 367, 145, 56);
		loginPanel.add(pwLabel);
//		Password Textfield
		final JTextField pwText = new JTextField();
		pwText.setColumns(10);
		pwText.setBackground(Color.GRAY);
		pwText.setBounds(17, 418, 246, 49);
		loginPanel.add(pwText);
		
		JLabel loginLogoimg = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/HKPF_275.png"));
		loginLogoimg.setIcon(img);
		loginLogoimg.setBounds(20, 5, 244, 275);
		loginPanel.add(loginLogoimg);
		
//		Login button
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//					frame.setVisible(false);
				String un = unText.getText();
				String pw = pwText.getText();
				
				if (um.checkUser(un, pw) == true) {
//					cLayout.show(frame.getContentPane(), "name_homePanel");
					cLayout.show(frame.getContentPane(), "name_reportPanel");

				}
				else {
//					JOptionPane.WARNING_MESSAGE
					JOptionPane.showMessageDialog(null,"Enter a valid username or password",
                            "Login Failed", 2);
				}
			}
		});
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		btnNewButton.setBounds(17, 479, 245, 43);
		loginPanel.add(btnNewButton);	
		
		
		
//		homePanel ---- 
		JPanel homePanel = new JPanel();
		loginPanel.setBounds(0, 0, 284, 573);
		frame.getContentPane().add(homePanel,"name_homePanel");
		homePanel.setLayout(null);
			
//		TEST BUTTON THIS NEEDS WORK ON, IT IS TEMP
		JButton repotBt = new JButton("Report");
		repotBt.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		repotBt.setBounds(23, 210, 226, 87);
		homePanel.add(repotBt);
		
		JButton reviewBt = new JButton("Review");
		reviewBt.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		reviewBt.setBounds(23, 320, 226, 87);
		homePanel.add(reviewBt);
		
		JButton clusterBt = new JButton("Cluster");
		clusterBt.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		clusterBt.setBounds(23, 430, 226, 87);
		homePanel.add(clusterBt);
		
		JLabel intructionLb = new JLabel("Choose an option :");
		intructionLb.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		intructionLb.setBounds(16, 189, 209, 22);
		homePanel.add(intructionLb);
		
		JLabel homeLogoimg = new JLabel("");
		ImageIcon img2 = new ImageIcon(this.getClass().getResource("/HKPF_190.png"));
		homeLogoimg.setIcon(img2);
		homeLogoimg.setBounds(57, 0, 169, 183);
		homePanel.add(homeLogoimg);
		repotBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cLayout.show(frame.getContentPane(), "name_reportPanel");
			}
			});
		
		
//		reportPanel ---- 
		JPanel reportPanel = new JPanel();
		reportPanel.setForeground(new Color(0, 0, 0));
		reportPanel.setBounds(0, 0, 284, 573);
		frame.getContentPane().add(reportPanel,"name_reportPanel");
		reportPanel.setLayout(null);
		
		JLabel reportMenuimg = new JLabel(" ");
		ImageIcon menuReportimg = new ImageIcon(this.getClass().getResource("/menu.png"));
		reportMenuimg.setIcon(menuReportimg);
		reportMenuimg.setBounds(10, 10, 30, 30);
		reportPanel.add(reportMenuimg);

		
		JLabel titleLabel = new JLabel("Report Accident");
		titleLabel.setFont(new Font(titleLabel.getName(), Font.PLAIN, 24));
		titleLabel.setBounds(45, 5, 192, 46);
		reportPanel.add(titleLabel);
		
		JLabel dateLb = new JLabel("Date :");
		dateLb.setBounds(10, 71, 128, 16);
		reportPanel.add(dateLb);
		
		final JTextField dateTx = new JTextField();
		dateTx.setBounds(53, 66, 174, 26);
		reportPanel.add(dateTx);
		dateTx.setColumns(10);
		dateTx.setText("YYYY/MM/DD");
		
		JButton dateAuto = new JButton("Auto");
		dateAuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dateTx.setText(ar.generateDate());
			}
		});
		dateAuto.setBounds(224, 66, 54, 29);
		reportPanel.add(dateAuto);
		
		JLabel timeLb = new JLabel("Time :");
		timeLb.setBounds(10, 99, 61, 16);
		reportPanel.add(timeLb);
		
		final JTextField timeTx = new JTextField();
		timeTx.setBounds(53, 94, 174, 26);
		reportPanel.add(timeTx);
		timeTx.setColumns(10);
		timeTx.setText("HH:mm");
		
		JButton timeAuto = new JButton("Auto");
		timeAuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timeTx.setText(ar.generateTime());
			}
		});
		timeAuto.setBounds(224, 94, 54, 29);
		reportPanel.add(timeAuto);
		
		JLabel lpLb = new JLabel("Lampost num:");
		lpLb.setBounds(10, 127, 156, 16);
		reportPanel.add(lpLb);
		
		final JTextField locTx = new JTextField();
		locTx.setBounds(103, 122, 113, 26);
		reportPanel.add(locTx);
		locTx.setColumns(10);
		locTx.setText("Number here ...");
		
//		RADIO buttons
		ButtonGroup severityGroup = new ButtonGroup();

		JLabel severityLb = new JLabel("Severity :");
		severityLb.setBounds(10, 152, 61, 16);
		reportPanel.add(severityLb);

		JRadioButton fatalRadio = new JRadioButton();
		fatalRadio.setBounds(68, 195, 28, 23);
		fatalRadio.setBounds(68, 150, 28, 23);
		reportPanel.add(fatalRadio);
		severityGroup.add(fatalRadio);

		JRadioButton severeRadio = new JRadioButton();
		severeRadio.setBounds(118, 150, 28, 23);
		reportPanel.add(severeRadio);
		severityGroup.add(severeRadio);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(43, 203, 61, 16);
		reportPanel.add(lblNewLabel);
		JRadioButton moderateRadio = new JRadioButton();
		moderateRadio.setBounds(168, 150, 28, 23);
		reportPanel.add(moderateRadio);
		severityGroup.add(moderateRadio);

		JRadioButton lightRadio = new JRadioButton();
		lightRadio.setBounds(218, 150, 28, 23);
		reportPanel.add(lightRadio);
		severityGroup.add(lightRadio);

		JLabel fatalLb = new JLabel("fatal");
		fatalLb.setBounds(70, 173, 28, 16);
		reportPanel.add(fatalLb);
		fatalLb.setFont(new Font(fatalLb.getName(), Font.PLAIN, 10));

		JLabel severeLb = new JLabel("severe");
		severeLb.setBounds(117, 173, 37, 16);
		reportPanel.add(severeLb);
		severeLb.setFont(new Font(severeLb.getName(), Font.PLAIN, 10));

		JLabel moderateLb = new JLabel("moderate");
		moderateLb.setBounds(159, 173, 52, 16);
		reportPanel.add(moderateLb);
		moderateLb.setFont(new Font(moderateLb.getName(), Font.PLAIN, 10));

		JLabel lightLb = new JLabel("light");
		lightLb.setBounds(222, 173, 28, 16);
		reportPanel.add(lightLb);
		lightLb.setFont(new Font(lightLb.getName(), Font.PLAIN, 10));
		
		JLabel caseNumLb = new JLabel("Case num:");
		caseNumLb.setBounds(10, 43, 77, 16);
		reportPanel.add(caseNumLb);
		
		JButton lpNumCheckBt = new JButton("Check");
		lpNumCheckBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lpNum = locTx.getText();
				try {
					ar.checkLP(lpNum);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		lpNumCheckBt.setBounds(215, 122, 63, 29);
		reportPanel.add(lpNumCheckBt);
		
		
	
	}
}
