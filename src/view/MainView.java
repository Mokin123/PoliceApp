package view;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;

import java.util.LinkedList;
import java.util.Timer;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.util.TimerTask;
import model.AccidentReport;
import model.UserManager;
import model.AccidentReportManager;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Scrollbar;
import java.awt.Label;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.ScrollPane;

public class MainView{
//	Importing class user as "u"
	

	private JFrame frame;
	private UserManager um;
//	private AccidentReport ar;
	private AccidentReportManager arm;
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
		arm = new AccidentReportManager();
//		ar = new AccidentReport();
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
					cLayout.show(frame.getContentPane(), "name_homePanel");
					
//					cLayout.show(frame.getContentPane(), "name_reportPanel");

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
				arm.createAccidentReport();
				System.out.println(arm.getAllReports().size());
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
		dateLb.setBounds(10, 75, 128, 16);
		reportPanel.add(dateLb);
		
		final JTextField dateTx = new JTextField();
		dateTx.setBounds(53, 70, 174, 26);
		reportPanel.add(dateTx);
		dateTx.setColumns(10);
		dateTx.setText("YYYY/MM/DD");
//		the following section removes the preset text when user clicks on the textbox, and inputs the text again if no text is added
		dateTx.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		        // Remove the preset text when the text field gains focus
		        if (dateTx.getText().equals("YYYY/MM/DD")) {
		            dateTx.setText("");
		        }
		    }
		    public void focusLost(FocusEvent e) {
		        // Add back the preset text if the text field loses focus and no input was provided
		        if (dateTx.getText().isEmpty()) {
		            dateTx.setText("YYYY/MM/DD");
		        }
		    }
		});
		
		JButton dateAuto = new JButton("Auto");
		dateAuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccidentReport ar = arm.getRecent();
				dateTx.setText(ar.generateDate());
			}
		});
		dateAuto.setBounds(224, 70, 54, 29);
		reportPanel.add(dateAuto);
		
		JLabel timeLb = new JLabel("Time :");
		timeLb.setBounds(10, 103, 61, 16);
		reportPanel.add(timeLb);
		
		final JTextField timeTx = new JTextField();
		timeTx.setBounds(53, 98, 174, 26);
		reportPanel.add(timeTx);
		timeTx.setColumns(10);
		timeTx.setText("HH:mm");
		timeTx.addFocusListener(new FocusListener() {
		    public void focusGained(FocusEvent e) {
		        // Remove the preset text when the text field gains focus
		        if (timeTx.getText().equals("HH:mm")) {
		        	timeTx.setText("");
		        }
		    }
		    public void focusLost(FocusEvent e) {
		        // Add back the preset text if the text field loses focus and no input was provided
		        if (timeTx.getText().isEmpty()) {
		        	timeTx.setText("HH:mm");
		        }
		    }
		});
		
		JButton timeAuto = new JButton("Auto");
		timeAuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccidentReport ar = arm.getRecent();
				timeTx.setText(ar.generateTime());
			}
		});
		timeAuto.setBounds(224, 98, 54, 29);
		reportPanel.add(timeAuto);
		
		JLabel lpLb = new JLabel("Lampost no. :");
		lpLb.setBounds(10, 131, 156, 16);
		reportPanel.add(lpLb);
		
		final JTextField lpTx = new JTextField();
		lpTx.setBounds(102, 126, 120, 26);
		reportPanel.add(lpTx);
		lpTx.setColumns(10);
		
//		RADIO buttons
		final JRadioButton[] severityGroup = new JRadioButton[4];

		JLabel severityLb = new JLabel("Severity :");
		severityLb.setBounds(10, 159, 61, 16);
		reportPanel.add(severityLb);

		JRadioButton fatal = new JRadioButton();
		fatal.setBounds(68, 154, 28, 23);
		reportPanel.add(fatal);
		severityGroup[0] = fatal;

		JRadioButton severe = new JRadioButton();
		severe.setBounds(118, 154, 28, 23);
		reportPanel.add(severe);
		severityGroup[1] = severe;
		
		JRadioButton moderate = new JRadioButton();
		moderate.setBounds(168, 154, 28, 23);
		reportPanel.add(moderate);
		severityGroup[2] = moderate;

		JRadioButton light = new JRadioButton();
		light.setBounds(218, 154, 28, 23);
		reportPanel.add(light);
		severityGroup[3] = light;

		JLabel fatalLb = new JLabel("fatal");
		fatalLb.setBounds(70, 175, 28, 16);
		reportPanel.add(fatalLb);
		fatalLb.setFont(new Font(fatalLb.getName(), Font.PLAIN, 10));

		JLabel severeLb = new JLabel("severe");
		severeLb.setBounds(117, 173, 37, 16);
		reportPanel.add(severeLb);
		severeLb.setFont(new Font(severeLb.getName(), Font.PLAIN, 10));

		JLabel moderateLb = new JLabel("moderate");
		moderateLb.setBounds(161, 173, 52, 16);
		reportPanel.add(moderateLb);
		moderateLb.setFont(new Font(moderateLb.getName(), Font.PLAIN, 10));

		JLabel lightLb = new JLabel("light");
		lightLb.setBounds(223, 173, 28, 16);
		reportPanel.add(lightLb);
		lightLb.setFont(new Font(lightLb.getName(), Font.PLAIN, 10));
		
		JLabel caseNumLb = new JLabel("Case no. :");
		caseNumLb.setBounds(10, 47, 77, 16);
		reportPanel.add(caseNumLb);
		
		JButton lpNumCheckBt = new JButton("Check");
		lpNumCheckBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lpNum = lpTx.getText();
				try {
					AccidentReport ar = arm.getRecent();
					int rowNum = ar.checkLP(lpNum);
					if (rowNum != -1) {
				        lpTx.setBackground(Color.GREEN);
				        
//		CODE FROM: https://www.geeksforgeeks.org/java-util-timer-class-java/
//				        returns color of text box to white after 3 seconds
						Timer timer = new Timer();
				        timer.schedule(new TimerTask() {
				            public void run() {
				                // Remove the background color
				                lpTx.setBackground(Color.WHITE);
				            }
				        }, 1800);
					}
					else {
				        lpTx.setBackground(Color.RED);
				        Timer timer = new Timer();
				        timer.schedule(new TimerTask() {
				            public void run() {
				                // Remove the background color
				                lpTx.setBackground(Color.WHITE);
				            }
				        }, 1800);

					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println("Something wrong");
					e1.printStackTrace();
				}
			}
		});
		lpNumCheckBt.setBounds(216, 126, 63, 29);
		reportPanel.add(lpNumCheckBt);
		
		final JTextField caseNumTx = new JTextField();
		caseNumTx.setColumns(10);
		caseNumTx.setBounds(76, 42, 198, 26);
		reportPanel.add(caseNumTx);
		
//		Check Box
		final JCheckBox[] partiesGroup = new JCheckBox[10];
		
		JLabel partiesLb = new JLabel("Type of parties involved :");
		partiesLb.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		partiesLb.setBounds(10, 193, 186, 16);
		reportPanel.add(partiesLb);
		
		JCheckBox pedestrianCB = new JCheckBox("Pedestrian ");
		pedestrianCB.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		pedestrianCB.setBounds(18, 210, 128, 23);
		reportPanel.add(pedestrianCB);
		partiesGroup[0] = pedestrianCB;
		
		JCheckBox cyclistCB = new JCheckBox("Cyclist");
		cyclistCB.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		cyclistCB.setBounds(18, 232, 128, 23);
		reportPanel.add(cyclistCB);
		partiesGroup[1] = cyclistCB;
		
		JCheckBox motorCycleCB = new JCheckBox("Motor Cycle");
		motorCycleCB.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		motorCycleCB.setBounds(18, 301, 128, 23);
		reportPanel.add(motorCycleCB);
		partiesGroup[2] = motorCycleCB;
		
		JCheckBox privateCarCB = new JCheckBox("Private Car");
		privateCarCB.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		privateCarCB.setBounds(128, 210, 128, 23);
		reportPanel.add(privateCarCB);
		partiesGroup[3] = privateCarCB;
		
		JCheckBox taxiCB = new JCheckBox("Taxi");
		taxiCB.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		taxiCB.setBounds(128, 232, 128, 23);
		reportPanel.add(taxiCB);
		partiesGroup[4] = taxiCB;
		
		JCheckBox lgvCB = new JCheckBox("Light Goods Vehicle");
		lgvCB.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lgvCB.setBounds(128, 255, 156, 23);
		reportPanel.add(lgvCB);
		partiesGroup[5] = lgvCB;
		
		JCheckBox hgvCB = new JCheckBox("Heavy Goods Vehicle");
		hgvCB.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		hgvCB.setBounds(128, 278, 156, 23);
		reportPanel.add(hgvCB);
		partiesGroup[6] = hgvCB;
	
		JCheckBox publicBusCB = new JCheckBox("Public Bus");
		publicBusCB.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		publicBusCB.setBounds(18, 255, 156, 23);
		reportPanel.add(publicBusCB);
		partiesGroup[7] = publicBusCB;
		
		JCheckBox privateBusCB = new JCheckBox("Private Bus");
		privateBusCB.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		privateBusCB.setBounds(18, 278, 156, 23);
		reportPanel.add(privateBusCB);
		partiesGroup[8] = privateBusCB;
		
		JCheckBox propertyCB = new JCheckBox("Gov. /Private Property");
		propertyCB.setHorizontalAlignment(SwingConstants.LEFT);
		propertyCB.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		propertyCB.setBounds(128, 300, 150, 23);
		reportPanel.add(propertyCB);
		partiesGroup[9] = propertyCB;
		
		
//      RESOURCE USED: https://www.javatpoint.com/java-jscrollpane
        // Wrap the panel within a JScrollPane
		final JButton addImgBt = new JButton("Add Image");
        addImgBt.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        addImgBt.setBounds(142, 323, 142, 39);
        reportPanel.add(addImgBt);
        
        final JButton uploadBt = new JButton("UPLOAD");
        uploadBt.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        uploadBt.setBounds(0, 362, 284, 39);
        reportPanel.add(uploadBt);
        
        
		final JPanel scrollPanel = new JPanel();
		scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.Y_AXIS));
		scrollPanel.setSize(280, 144);
        final JScrollPane scrollPane = new JScrollPane(scrollPanel);
		scrollPane.setVisible(false);
        scrollPane.setBounds(2, 325,280, 144);
        reportPanel.add(scrollPane);
        
       
        final JButton addTxBt = new JButton("Add Text");
        addTxBt.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        addTxBt.setBounds(0, 323, 142, 39);
        reportPanel.add(addTxBt);
        addTxBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTxBt.setLocation(0, 467);
				addImgBt.setLocation(142, 467);
				uploadBt.setLocation(0, 506);
				scrollPane.setVisible(true);
				
				scrollPanel.add(Box.createVerticalStrut(5));
				AccidentReport ar = arm.getRecent();
				JLabel label = new JLabel("Text Area " + (ar.getTextSize()+1));
			    scrollPanel.add(label);
				scrollPanel.add(Box.createVerticalStrut(10));
				final JTextArea textArea = new JTextArea("Insert Text Here");
				textArea.setLineWrap(true);
				ar.addTextArea(textArea);
				textArea.addFocusListener(new FocusListener() {
				    public void focusGained(FocusEvent e) {
				        if (textArea.getText().equals("Insert Text Here")) {
				        	textArea.setText("");
				        }
				    }
				    public void focusLost(FocusEvent e) {
				        if (textArea.getText().isEmpty()) {
				        	textArea.setText("Insert Text Here");
				        }
				    }
				});
				scrollPanel.add(textArea);
				scrollPane.setViewportView(scrollPanel);
			    scrollPane.revalidate();
			    ar.setTextSize(ar.getTextSize()+1);	
			    
			}
		});
        
        addImgBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addTxBt.setLocation(0, 467);
				addImgBt.setLocation(142, 467);
				uploadBt.setLocation(0, 506);
				scrollPane.setVisible(true);

			}
		});
        
        uploadBt.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
				AccidentReport ar = arm.getRecent();
				String aN = caseNumTx.getText();
				String date = dateTx.getText();
				String hour = timeTx.getText();
				String lp = lpTx.getText();
				boolean check = ar.checkEssential(aN, date, hour, severityGroup, lp);
				if (check == true) {
					int[] returnedConversion = ar.convertPartiesInvolved(partiesGroup);
					ar.updateInfo(aN, date, hour, lp, severityGroup, returnedConversion);
					ar.uploadInfo();
				}
				
        	}
        });
       
        
//        if (scrollPane.getComponentCount == 0)
        
        
        
	}
}
