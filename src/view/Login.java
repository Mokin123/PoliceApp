package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import model.User;

public class Login {
//	Importing class user as "u"
	User u = new User();
	Home home = new Home();
	public JFrame frame;
	private JTextField unText;
	private JTextField pwText;

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
		frame.getContentPane().setLayout(null);
//		
		
		
//		Username Labels:
		final JLabel UNLabel = new JLabel("Username :");
		UNLabel.setFont(new Font(UNLabel.getName(), Font.PLAIN, 24));
		UNLabel.setBounds(17, 266, 145, 56);
		frame.getContentPane().add(UNLabel);
//		Username textfield:
		unText = new JTextField();
		unText.setBackground(new Color(128, 128, 128));
		unText.setBounds(17, 321, 246, 49);
		frame.getContentPane().add(unText);
		unText.setColumns(10);
//		Password Label:
		JLabel pwLabel = new JLabel("password :");
		pwLabel.setFont(new Font("Dialog", Font.PLAIN, 24));
		pwLabel.setBounds(17, 367, 145, 56);
		frame.getContentPane().add(pwLabel);
//		Login button
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				String un = unText.getText();
				String pw = pwText.getText();
				System.out.println(un);
				System.out.println(pw);
//				System.out.println(u.checkUser(un,pw));
				home.initialize();
			}
		});
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		btnNewButton.setBounds(17, 479, 245, 43);
		frame.getContentPane().add(btnNewButton);
		
//		Password Textfield
		pwText = new JTextField();
		pwText.setColumns(10);
		pwText.setBackground(Color.GRAY);
		pwText.setBounds(17, 418, 246, 49);
		frame.getContentPane().add(pwText);
	}
}
