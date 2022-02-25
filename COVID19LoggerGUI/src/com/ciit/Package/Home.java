package com.ciit.Package;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JTextField;
import com.github.lgooddatepicker.components.DatePicker;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;




public class Home {

	private JFrame frmHome;
	private JTextField txtfieldFirstName;
	private JTextField txtfieldMiddleName;
	private JTextField txtfieldLastName;
	private JTextField txtfieldPhoneNumber;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frmHome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		// Set Default Boolean 
		System.out.println(AdminPasswordAndAdminUsername.getSaveData());
		if (AdminPasswordAndAdminUsername.getSaveData() == null) {
			AdminPasswordAndAdminUsername.setSaveData(false); 
		}
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHome = new JFrame();
		frmHome.setTitle("COVID-19 Logger");
		frmHome.setBounds(100, 100, 500, 500);
		frmHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHome.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("COVID-19 Logger");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 14));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(167, 11, 150, 29);
		frmHome.getContentPane().add(lblTitle);
		
		JLabel lblDate = new JLabel("Month Date Year Time");
		lblDate.setFont(new Font("Arial", Font.PLAIN, 10));
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setBounds(166, 51, 151, 14);
		frmHome.getContentPane().add(lblDate);
		liveDate(lblDate);
		
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setHorizontalAlignment(SwingConstants.LEFT);
		lblFirstName.setFont(new Font("Arial", Font.PLAIN, 12));
		lblFirstName.setBounds(50, 100, 86, 14);
		frmHome.getContentPane().add(lblFirstName);
		
		txtfieldFirstName = new JTextField();
		txtfieldFirstName.setFont(new Font("Arial", Font.PLAIN, 11));
		txtfieldFirstName.setBounds(50, 125, 86, 20);
		frmHome.getContentPane().add(txtfieldFirstName);
		txtfieldFirstName.setColumns(10);
		
		JLabel lblMiddleName = new JLabel("Middle Name");
		lblMiddleName.setFont(new Font("Arial", Font.PLAIN, 12));
		lblMiddleName.setHorizontalAlignment(SwingConstants.LEFT);
		lblMiddleName.setBounds(199, 100, 86, 14);
		frmHome.getContentPane().add(lblMiddleName);
		
		txtfieldMiddleName = new JTextField();
		txtfieldMiddleName.setFont(new Font("Arial", Font.PLAIN, 11));
		txtfieldMiddleName.setBounds(199, 124, 86, 20);
		frmHome.getContentPane().add(txtfieldMiddleName);
		txtfieldMiddleName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Arial", Font.PLAIN, 12));
		lblLastName.setHorizontalAlignment(SwingConstants.LEFT);
		lblLastName.setBounds(350, 100, 86, 14);
		frmHome.getContentPane().add(lblLastName);
		
		txtfieldLastName = new JTextField();
		txtfieldLastName.setFont(new Font("Arial", Font.PLAIN, 11));
		txtfieldLastName.setBounds(350, 124, 86, 20);
		frmHome.getContentPane().add(txtfieldLastName);
		txtfieldLastName.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Arial", Font.PLAIN, 12));
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhoneNumber.setBounds(50, 156, 86, 14);
		frmHome.getContentPane().add(lblPhoneNumber);
		
		txtfieldPhoneNumber = new JTextField();
		txtfieldPhoneNumber.setFont(new Font("Arial", Font.PLAIN, 11));
		txtfieldPhoneNumber.setBounds(50, 181, 86, 20);
		frmHome.getContentPane().add(txtfieldPhoneNumber);
		txtfieldPhoneNumber.setColumns(10);
		
		JLabel lblBithdate = new JLabel("Birthdate");
		lblBithdate.setFont(new Font("Arial", Font.PLAIN, 12));
		lblBithdate.setBounds(199, 157, 86, 14);
		frmHome.getContentPane().add(lblBithdate);
		
		JLabel lblAdminPanel = new JLabel("Admin Panel >");
		lblAdminPanel.setFont(new Font("Arial", Font.PLAIN, 11));
		lblAdminPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(lblAdminPanel.getText() + " is clicked");
				AdminLogin adminLogin = new AdminLogin();
				adminLogin.setVisible(true);
				frmHome.setVisible(false);
				frmHome.dispose();
			}
		});
		lblAdminPanel.setBounds(388, 225, 86, 14);
		frmHome.getContentPane().add(lblAdminPanel);
		
		DatePicker datePicker = new DatePicker();
		datePicker.setBounds(199, 181, 144, 29);
		frmHome.getContentPane().add(datePicker);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Arial", Font.PLAIN, 11));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName, middleName, lastName, phoneNumber;
				LocalDate birthDate;
				
				firstName = txtfieldFirstName.getText();
				middleName = txtfieldMiddleName.getText();
				lastName = txtfieldLastName.getText();
				phoneNumber = txtfieldPhoneNumber.getText();
				birthDate = datePicker.getDate();
				
				if (firstName.isEmpty() || firstName.isBlank()) {
					JOptionPane.showMessageDialog(frmHome, "First Name is required.");
					return;
				}
				else if (lastName.isEmpty() || lastName.isBlank()) {
					JOptionPane.showMessageDialog(frmHome, "Last name is required");
					return;
				}
				
				// Start Check Phone Number, Check if number starts with 0 & 9
				Boolean flag = true;
				String msgIfContainsDigits = "Phone Numbers only contain digits and symbols.";
				
				if (phoneNumber.isBlank() || phoneNumber.isEmpty()) {
					JOptionPane.showMessageDialog(frmHome, "Phone Number is required.");
					return;
				}
				
				else if (phoneNumber.charAt(0) == '0' && phoneNumber.length() == 1) {
					JOptionPane.showMessageDialog(frmHome, "Phone Number must start with '09' or '9'.");
					return;
				}
				
				else if ((phoneNumber.charAt(0) == '0' && phoneNumber.charAt(1) == '9') == true) {
					if (phoneNumber.length() == 11) {
						for (char character : phoneNumber.toCharArray()) {
							flag = Character.isDigit(character);
							if (flag == false) {
								JOptionPane.showMessageDialog(frmHome, msgIfContainsDigits);
								return;
							}
						}
					}
					else if (phoneNumber.length() > 11 || phoneNumber.length() < 11) {
						JOptionPane.showMessageDialog(frmHome, "If it's starts with '09', it should be an 11-digit format.");
						return;
					}
				}
				else if ((phoneNumber.charAt(0) == '9') == true) {
					if (phoneNumber.length() == 10) {
						for (char character : phoneNumber.toCharArray()) {
							flag = Character.isDigit(character);
							if (flag == false) {
								JOptionPane.showMessageDialog(frmHome, msgIfContainsDigits);
								return;
							}
						}
					}
					else if (phoneNumber.length() < 10 || phoneNumber.length() > 10) {
						JOptionPane.showMessageDialog(frmHome, "If it's starts with '9', it should be an 10-digit format.");
						return;
					}
				}
				
				else if (phoneNumber.charAt(0) != '9' || (phoneNumber.charAt(0) == '0' && phoneNumber.charAt(1) != '9')) {
					JOptionPane.showMessageDialog(frmHome, "Phone Number must start with '09' or '9'.");
					return;
				}
				// END Check Phone Number
				
				// START Check Birthdate
				if (birthDate == null) {
					JOptionPane.showMessageDialog(frmHome, "Birthdate is required");
					return;
				}
				else if (birthDate.getYear() > LocalDateTime.now().getYear()) {
					JOptionPane.showMessageDialog(frmHome, "Choose an appropriate birthdate.");
					return;
				}
				// END Check Birthdate
				
				Visitor newVisitor = new Visitor(firstName, middleName, lastName, phoneNumber, birthDate);
				Visitor.visitorList.add(newVisitor);
				
				JOptionPane.showMessageDialog(frmHome, "Visitor details successfully logged.");
				
				//	Reset the Visitor Form
				if (AdminPasswordAndAdminUsername.getSaveData() == false) {
					txtfieldFirstName.setText("");
					txtfieldMiddleName.setText("");
					txtfieldLastName.setText("");
					txtfieldPhoneNumber.setText("");
					datePicker.clear();
				}
				
				System.out.println("Number of Visitors: " + Visitor.visitorList.size());
				
			}
		});
		btnSubmit.setBounds(196, 221, 89, 23);
		frmHome.getContentPane().add(btnSubmit);
	}
	
	
	
	// Custom Methods
	public void setVisible(boolean isVisible) {
		frmHome.setVisible(isVisible);
	}
	
	public void liveDate(JLabel label) {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				while (true) {
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM dd, yyyy - hh:mm:ss");
					LocalDateTime now = LocalDateTime.now();
					label.setText(dtf.format(now));
				}
			}
		};
		Thread changeDate = new Thread(runnable);
		changeDate.start();
	}
	
	public Boolean setInitialize(Boolean newBoolean) {
		if (newBoolean == true) {
			initialize();
		}
		else if (newBoolean == false) {
			System.out.println("Can't initialize GUI if set to false");
		}
		return newBoolean;
	}
}
