package com.ciit.Package;

import javax.swing.JOptionPane;

public class AdminPasswordAndAdminUsername {
	private static Boolean saveData = false;
	
	private static String username = "Admin";
	private static String password = "password";
	
	// Custom Methods
	
	public static String getUsername() {
		return username;
	}
	
	public static String getPassword() {
		return password;
	}
	
	public static Boolean getSaveData() {
		return saveData;
	}
	
	// Setters
	public static void setSaveData (Boolean newBoolean) {
		saveData = newBoolean;
	}
	
	public static void setUsername (String newUsername, String currentPassword) {
		// Check if newUsername is empty 
		if (newUsername.isEmpty() || newUsername.isBlank()) {
			JOptionPane.showMessageDialog(null, newUsername + "Warning: username is empty");
			System.out.println("Username is empty");
		}
		
		if (currentPassword.contentEquals(password) == true) {
			if ( (newUsername.isEmpty() || newUsername.isBlank()) == false ) {
				username = newUsername;
			}
		}
		else if (currentPassword.contentEquals(password) == false)  {
			System.out.println("Password incorrect");
		}
	}
	
	public static Boolean setPassword (String currentPassword) {
		Boolean passwordChanged = false;
		
		if (currentPassword.contentEquals(password) == true) {
			// Confirm Password
			String newPassword = JOptionPane.showInputDialog(null, "Enter your new password:");
			String confirmPassword = JOptionPane.showInputDialog(null, "Confirm password:");
			
			// Check if the password is empty
			if (newPassword.isBlank() || newPassword.isEmpty()){
				JOptionPane.showMessageDialog(null, "Password is empty");
				passwordChanged = false;
				return passwordChanged;
			}
			
			//TODO If NewPassword == confirmPassword then change the password = newPassword
			if (newPassword.contentEquals(confirmPassword) == true) {
				password = newPassword;
				passwordChanged = true;
			}
			else if (newPassword.contentEquals(confirmPassword) == false) {
				passwordChanged = false;
			}
		}
		else if (currentPassword.contentEquals(password) == false){
			System.out.println("Password incorrect");
			passwordChanged = false;
		}
		
		return passwordChanged;
	}
}
