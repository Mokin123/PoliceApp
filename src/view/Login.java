package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Login {
//	Importing class user as "u"
	

	private JFrame frame;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 284, 573);
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
		
//		Login button
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//					frame.setVisible(false);
				String un = unText.getText();
				String pw = pwText.getText();
				System.out.println(un);
				System.out.println(pw);
//				System.out.println(u.checkUser(un,pw));
				cLayout.show(frame.getContentPane(), "name_homePanel");
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
		repotBt.setBounds(30, 349, 226, 87);
		homePanel.add(repotBt);
		repotBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				frame.setVisible(false);
//				login.frame.setVisible(true);
			}
			});

	
	}
}
