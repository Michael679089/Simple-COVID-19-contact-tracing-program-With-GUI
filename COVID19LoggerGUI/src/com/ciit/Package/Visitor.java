package com.ciit.Package;

import java.util.LinkedList;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Visitor {
	
	public static LinkedList<Visitor> visitorList = new LinkedList<>();
	
	private String firstName;
	private String middleName;
	private String lastName;
	private String phoneNumber;
	private LocalDate birthDate;
	private LocalDateTime visitDate;
	private LocalDateTime visitTime;
	
	
	public Visitor(
			String newFirstName,
			String newMiddleName,
			String newLastName,
			String newPhoneNumber,
			LocalDate newBirthDate
			) {
		setFirstName(newFirstName);
		setMiddleName(newMiddleName);
		setLastName(newLastName);
		setPhoneNumber(newPhoneNumber);
		setBirthDate(newBirthDate);
		
		setvisitDate(LocalDateTime.now());
		setvisitTime(LocalDateTime.now());
	}
	
	
	//	Getters and Setters firstName
	public String getFirstName() {
		return firstName;
	}
	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	//	Getters and Setters middleName
	public String getMiddleName() {
		return middleName;
	}
	private void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	//	Getters and Setters lastName
	public String getLastName() {
		return lastName;
	}
	private void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	//	Getters and Setters phoneNumber
	public String getPhoneNumber() {
		return phoneNumber;
	}
	private void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	//	Getters and Setters birthDate
	public LocalDate getBirthDate() {
		return birthDate;
	}
	private void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	//	Getters and Setters visitDate
	public LocalDateTime getvisitDate() {
		return visitDate;
	}
	public String getvisitTime() {
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");
		return visitTime.format(myFormatObj);
	}
	private void setvisitDate(LocalDateTime visitDate) {
		this.visitDate = visitDate;
	}
	private void setvisitTime(LocalDateTime visitTime) {
		this.visitTime = visitTime;
	}
	
	
	//TODO: Make a SEARCHING FUNCTION
	// Searching for either First Name or Last Name
	public static String[][] Search(String newSearchKeyword, SearchType searchType) {
		// Making the temporary display List
		LinkedList<Visitor> resultList = new LinkedList<>();
		
		for (Visitor v : visitorList) {
			switch (searchType) {
			case FirstName:
				if (v.firstName.equalsIgnoreCase(newSearchKeyword)) {
					resultList.add(v);
				}
				break;
			case MiddleName:
				if (v.middleName.equalsIgnoreCase(newSearchKeyword)){
					resultList.add(v);
				}
				break;
			case LastName:
				if (v.lastName.equalsIgnoreCase(newSearchKeyword)) {
					resultList.add(v);
				}
				break;
			default:
				break;
			}
		}
		
		String results[][] = new String[resultList.size()][6];
		for (int i = 0; i < resultList.size(); i++) {
			results[i][0] = resultList.get(i).getLastName();
			results[i][1] = resultList.get(i).getFirstName();
			results[i][2] = resultList.get(i).getMiddleName();
			results[i][3] = resultList.get(i).getBirthDate().toString();
			results[i][4] = resultList.get(i).getvisitDate().toLocalDate().toString();
			results[i][5] = resultList.get(i).getvisitTime();
		}
		
		return results;
	}
	
	//TODO: Searching for visitDate
	public static String[][] Search(LocalDate newSearchDate, SearchType newSearchType) {
		// Making the temporary display List
		LinkedList<Visitor> resultList = new LinkedList<>();
		
		if (newSearchType == SearchType.EntryDate) { 
			for (Visitor v : visitorList) {
				LocalDate visitDate = v.visitDate.toLocalDate();
				
				if (visitDate.equals(newSearchDate)) {
					resultList.add(v);
				}
			}
		}
		
		//TODO BirthDate
		else if  (newSearchType == SearchType.BirthDate) {
			for (Visitor v : visitorList) {
				LocalDate visitDate = v.birthDate;
				
				if (visitDate.equals(newSearchDate)) {
					resultList.add(v);
				}
			}
		}
		
		// Setting the table
		String results[][] = new String[resultList.size()][6];
		for (int i = 0; i < resultList.size(); i++) {
			results[i][0] = resultList.get(i).getLastName();
			results[i][1] = resultList.get(i).getFirstName();
			results[i][2] = resultList.get(i).getMiddleName();
			results[i][3] = resultList.get(i).getBirthDate().toString();
			results[i][4] = resultList.get(i).getvisitDate().toLocalDate().toString();
			results[i][5] = resultList.get(i).getvisitTime();
		}
		
		return results;
	}
}
