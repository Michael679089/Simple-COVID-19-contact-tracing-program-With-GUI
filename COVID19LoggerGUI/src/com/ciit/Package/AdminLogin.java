package com.ciit.Package;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class AdminLogin {

	private JFrame frmAdminLogin;
	private JTextField txtfieldUsername;
	
	private String password = AdminPasswordAndAdminUsername.getPassword();
	private String username = AdminPasswordAndAdminUsername.getUsername();
	private JPasswordField passwordfieldAdminPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin window = new AdminLogin();
					window.frmAdminLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminLogin = new JFrame();
		frmAdminLogin.setTitle("Admin Login");
		frmAdminLogin.setBounds(100, 100, 500, 500);
		frmAdminLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminLogin.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("COVID-19 Logger");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 14));
		lblTitle.setBounds(153, 11, 178, 14);
		frmAdminLogin.getContentPane().add(lblTitle);
		
		JLabel lblLiveDate = new JLabel("Date");
		lblLiveDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblLiveDate.setFont(new Font("Arial", Font.PLAIN, 11));
		lblLiveDate.setBounds(176, 36, 131, 14);
		frmAdminLogin.getContentPane().add(lblLiveDate);
		Home newHome = new Home();
		newHome.liveDate(lblLiveDate);
		
		JLabel lblBackToHome = new JLabel("< Back to Home");
		lblBackToHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(lblBackToHome.getText() + " is clicked");
				newHome.setVisible(true);
				frmAdminLogin.setVisible(false);
				frmAdminLogin.dispose();
			}
		});
		lblBackToHome.setFont(new Font("Arial", Font.PLAIN, 11));
		lblBackToHome.setBounds(10, 12, 108, 14);
		frmAdminLogin.getContentPane().add(lblBackToHome);
		
		JLabel lblAdminLogin = new JLabel("Admin Login");
		lblAdminLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminLogin.setFont(new Font("Arial", Font.PLAIN, 14));
		lblAdminLogin.setBounds(169, 114, 146, 14);
		frmAdminLogin.getContentPane().add(lblAdminLogin);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Arial", Font.PLAIN, 11));
		lblUsername.setBounds(169, 142, 83, 14);
		frmAdminLogin.getContentPane().add(lblUsername);
		
		txtfieldUsername = new JTextField();
		txtfieldUsername.setFont(new Font("Arial", Font.PLAIN, 11));
		txtfieldUsername.setHorizontalAlignment(SwingConstants.LEFT);
		txtfieldUsername.setBounds(169, 167, 146, 20);
		frmAdminLogin.getContentPane().add(txtfieldUsername);
		txtfieldUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 11));
		lblPassword.setBounds(169, 198, 83, 14);
		frmAdminLogin.getContentPane().add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Check if both Username & Password are correct.
				
				// START Checks Password
				String tempStringPassword = "";
				for (char i : passwordfieldAdminPassword.getPassword()) { 
					tempStringPassword += i;
				}
				// END Checks Password
				
				
				if (txtfieldUsername.getText().contentEquals(username) == false) {
					System.out.println("Username is incorrect.");
					JOptionPane.showMessageDialog(frmAdminLogin, "Either the username or the password is incorrect.");
					return;
				}
				else if (tempStringPassword.contentEquals(password) == false) {
					System.out.println("Password is incorrect.");
					JOptionPane.showMessageDialog(frmAdminLogin, "Either the username or the password is incorrect.");
					return;
				}
				else if ((txtfieldUsername.getText().contentEquals(username) == true) && (tempStringPassword.contentEquals(password) == true)) {
					System.out.println("Admin & Password is correct");
					JOptionPane.showMessageDialog(frmAdminLogin, "Access Granted");
					
					AdminPanel newAdminPanel = new AdminPanel();
					newAdminPanel.setVisible(true);
					frmAdminLogin.setVisible(false);
					frmAdminLogin.dispose();
				}
			}
		});
		btnLogin.setFont(new Font("Arial", Font.PLAIN, 11));
		btnLogin.setBounds(197, 253, 89, 23);
		frmAdminLogin.getContentPane().add(btnLogin);
		
		passwordfieldAdminPassword = new JPasswordField();
		passwordfieldAdminPassword.setFont(new Font("Arial", Font.PLAIN, 11));
		passwordfieldAdminPassword.setBounds(169, 222, 146, 20);
		frmAdminLogin.getContentPane().add(passwordfieldAdminPassword);
	}
	
	
	
	// Custom Methods
	
	public void setVisible(boolean isVisible) {
		frmAdminLogin.setVisible(isVisible);
	}
	
	protected void setUsername(String newUserName) {
		username = newUserName;
	}
	
	protected void setpassword(String newPassword) {
		password = newPassword;
	}
}
