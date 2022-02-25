package com.ciit.Package;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.Button;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

import javax.swing.JRadioButton;
import javax.swing.Box;
import javax.swing.ButtonGroup;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import com.github.lgooddatepicker.components.DatePicker;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;

public class AdminPanel {

	private JFrame frmAdminPanel;
	private JTextField txtfieldSearch;
	
	private JTable tblResults;
	
	private String searchResults;
	private LocalDate searchDate;
	private SearchType searchSelection;
	
	
	
	private String column[] = { "Last Name", "First name", "Middle Name", "Birth date", "date of entry" };
	private String data[][] = {};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel window = new AdminPanel();
					window.frmAdminPanel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminPanel = new JFrame();
		frmAdminPanel.setBounds(100, 100, 700, 500);
		frmAdminPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminPanel.getContentPane().setLayout(new BorderLayout(0, 0));
		
		Panel panelSearch = new Panel();
		frmAdminPanel.getContentPane().add(panelSearch, BorderLayout.WEST);
		
		JPanel panelRadioButtons = new JPanel();
		panelRadioButtons.setVisible(false);
		
		JButton btnOption = new JButton("Options");
		btnOption.setFont(new Font("Arial", Font.PLAIN, 11));
		btnOption.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (panelRadioButtons.isVisible() == true) { 
					panelRadioButtons.setVisible(false);
				}
				else if (panelRadioButtons.isVisible() == false) { 
					panelRadioButtons.setVisible(true);
				}
			}
		});
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setFont(new Font("Arial", Font.PLAIN, 11));
		
		txtfieldSearch = new JTextField();
		txtfieldSearch.setFont(new Font("Arial", Font.PLAIN, 12));
		txtfieldSearch.setColumns(10);
		
		DatePicker datePicker = new DatePicker();
		datePicker.getComponentToggleCalendarButton().setEnabled(false);
		datePicker.getComponentDateTextField().setFont(new Font("Arial", Font.PLAIN, 12));
		
		JLabel lblBirthDate_EntryDate = new JLabel("Birthdate & EntryDate");
		lblBirthDate_EntryDate.setFont(new Font("Arial", Font.PLAIN, 11));
		
		JButton btnGo = new JButton("Go");
		btnGo.setFont(new Font("Arial", Font.PLAIN, 11));
		
		JRadioButton rdbtnClearSubmit = new JRadioButton("Clear Submit in login page");
		rdbtnClearSubmit.setFont(new Font("Arial", Font.PLAIN, 9));
		rdbtnClearSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnClearSubmit.isSelected() == true) {
					AdminPasswordAndAdminUsername.setSaveData(true);
				}
				else if (rdbtnClearSubmit.isSelected() == false) {
					AdminPasswordAndAdminUsername.setSaveData(false);
				}
				System.out.println("SearchType.saveData.status: " + AdminPasswordAndAdminUsername.getSaveData());
			}
		});
		
		JButton btnChangeUserName = new JButton("Change Username");
		btnChangeUserName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newUsername = JOptionPane.showInputDialog(frmAdminPanel, "Choose a username:");
				String newPassword = JOptionPane.showInputDialog(frmAdminPanel, "Current password:");
				AdminPasswordAndAdminUsername.setUsername(newUsername, newPassword);
				if (newUsername.contentEquals(AdminPasswordAndAdminUsername.getUsername()) == true) {
					JOptionPane.showMessageDialog(frmAdminPanel, "Username successfully changed." );
				}
				else if (newUsername.contentEquals(AdminPasswordAndAdminUsername.getUsername()) == false) {
					JOptionPane.showMessageDialog(frmAdminPanel, "Error changing username.");
					return;
				}
				else if (newUsername.isEmpty()) {
					JOptionPane.showMessageDialog(frmAdminPanel, "Username or password cannot be null");
					return;
				}
				System.out.println("New Admin Username: " + AdminPasswordAndAdminUsername.getUsername());
			}
		});
		btnChangeUserName.setFont(new Font("Arial", Font.PLAIN, 11));
		
		JButton btnNewButton = new JButton("Change Password");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String currentPassword = JOptionPane.showInputDialog(frmAdminPanel, "Current password:");
				Boolean passwordChanged = AdminPasswordAndAdminUsername.setPassword(currentPassword);
				if (passwordChanged == true) {
					JOptionPane.showMessageDialog(frmAdminPanel, "Password successfully changed.");
				}
				else if (passwordChanged == false) {
					JOptionPane.showMessageDialog(frmAdminPanel, "Error changing password.");
					return;
				}
				System.out.println("New Admin Password: " + AdminPasswordAndAdminUsername.getPassword());
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 11));
		
		JLabel lblDeveloperTools = new JLabel("Developer Tools");
		lblDeveloperTools.setFont(new Font("Arial", Font.PLAIN, 9));
		
		JButton btnClearTable = new JButton("Clear Table");
		btnClearTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Visitor.visitorList.clear();
				System.out.println(Visitor.visitorList);
			}
		});
		btnClearTable.setFont(new Font("Arial", Font.PLAIN, 8));
		
		GroupLayout gl_panelSearch = new GroupLayout(panelSearch);
		gl_panelSearch.setHorizontalGroup(
			gl_panelSearch.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSearch.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelSearch.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelSearch.createSequentialGroup()
							.addComponent(btnOption)
							.addContainerGap(166, Short.MAX_VALUE))
						.addGroup(gl_panelSearch.createSequentialGroup()
							.addComponent(panelRadioButtons, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(157, Short.MAX_VALUE))
						.addGroup(gl_panelSearch.createSequentialGroup()
							.addGroup(gl_panelSearch.createParallelGroup(Alignment.LEADING)
								.addComponent(txtfieldSearch, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
								.addGroup(gl_panelSearch.createSequentialGroup()
									.addComponent(lblSearch)
									.addPreferredGap(ComponentPlacement.RELATED, 104, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelSearch.createSequentialGroup()
									.addComponent(lblBirthDate_EntryDate)
									.addPreferredGap(ComponentPlacement.RELATED, 36, GroupLayout.PREFERRED_SIZE)))
							.addGap(96))
						.addGroup(gl_panelSearch.createSequentialGroup()
							.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(96, Short.MAX_VALUE))
						.addGroup(gl_panelSearch.createSequentialGroup()
							.addComponent(btnGo)
							.addContainerGap(188, Short.MAX_VALUE))
						.addGroup(gl_panelSearch.createSequentialGroup()
							.addGroup(gl_panelSearch.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnChangeUserName, Alignment.LEADING))
							.addContainerGap(112, Short.MAX_VALUE))
						.addGroup(gl_panelSearch.createSequentialGroup()
							.addGroup(gl_panelSearch.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnClearSubmit)
								.addGroup(gl_panelSearch.createSequentialGroup()
									.addComponent(lblDeveloperTools)
									.addPreferredGap(ComponentPlacement.RELATED, 67, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(100, Short.MAX_VALUE))
						.addGroup(gl_panelSearch.createSequentialGroup()
							.addComponent(btnClearTable)
							.addContainerGap(162, Short.MAX_VALUE))))
		);
		gl_panelSearch.setVerticalGroup(
			gl_panelSearch.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSearch.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnOption)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelRadioButtons, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSearch)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtfieldSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblBirthDate_EntryDate)
					.addGap(4)
					.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnGo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnChangeUserName)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblDeveloperTools)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rdbtnClearSubmit)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnClearTable)
					.addContainerGap(27, Short.MAX_VALUE))
		);
		
		JRadioButton rdbtnFirstName = new JRadioButton("First name");
		rdbtnFirstName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtfieldSearch.setEnabled(true);
				datePicker.setEnabled(false);
			}
		});
		rdbtnFirstName.setFont(new Font("Arial", Font.PLAIN, 11));
		panelRadioButtons.add(rdbtnFirstName);
		rdbtnFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		
		JRadioButton rdbtnMiddleName = new JRadioButton("Middle Name");
		rdbtnMiddleName.setFont(new Font("Arial", Font.PLAIN, 11));
		rdbtnMiddleName.setHorizontalAlignment(SwingConstants.CENTER);
		panelRadioButtons.add(rdbtnMiddleName);
		rdbtnMiddleName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtfieldSearch.setEnabled(true);
				datePicker.setEnabled(false);
			}
		});
		
		JRadioButton rdbtnLastName = new JRadioButton("Last Name");
		rdbtnLastName.setFont(new Font("Arial", Font.PLAIN, 11));
		rdbtnLastName.setHorizontalAlignment(SwingConstants.CENTER);
		panelRadioButtons.add(rdbtnLastName);
		rdbtnLastName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtfieldSearch.setEnabled(true);
				datePicker.setEnabled(false);
			}
		});
		
		JRadioButton rdbtnBirthDate = new JRadioButton("Birthdate");
		rdbtnBirthDate.setFont(new Font("Arial", Font.PLAIN, 11));
		panelRadioButtons.add(rdbtnBirthDate);
		rdbtnBirthDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datePicker.setEnabled(true);
				txtfieldSearch.setEnabled(false);
			}
		});
		
		JRadioButton rdbtnEntryDate = new JRadioButton("Entry Date");
		rdbtnEntryDate.setFont(new Font("Arial", Font.PLAIN, 11));
		panelRadioButtons.add(rdbtnEntryDate);
		panelSearch.setLayout(gl_panelSearch);
		rdbtnEntryDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datePicker.setEnabled(true);
				txtfieldSearch.setEnabled(false);
			}
		});
		
		//Set Default Buttons
		rdbtnFirstName.setSelected(true);
		rdbtnMiddleName.setSelected(false);
		rdbtnLastName.setSelected(false);
		rdbtnBirthDate.setSelected(false);
		rdbtnEntryDate.setSelected(false);
		txtfieldSearch.setEnabled(true);
		datePicker.setEnabled(false);
		
		
		// ButtonGroup so that one rdbtn is chosen each time.
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnFirstName);
		buttonGroup.add(rdbtnMiddleName);
		buttonGroup.add(rdbtnLastName);
		buttonGroup.add(rdbtnBirthDate);
		buttonGroup.add(rdbtnEntryDate);
			
		JScrollPane scrollPaneTable = new JScrollPane();
		scrollPaneTable.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneTable.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		// Button Go Action Listener
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchResults = txtfieldSearch.getText();
				searchDate = datePicker.getDate();
				
				if (rdbtnFirstName.isSelected()) {
					searchSelection = SearchType.FirstName;
					data = Visitor.Search(searchResults, searchSelection);
				}
				else if (rdbtnMiddleName.isSelected()) {
					searchSelection = SearchType.MiddleName;
					data = Visitor.Search(searchResults, searchSelection);
				}
				else if (rdbtnLastName.isSelected()) {
					searchSelection = SearchType.LastName;
					data = Visitor.Search(searchResults, searchSelection);
				}
				else if (rdbtnBirthDate.isSelected()) {
					searchSelection = SearchType.BirthDate;
					data = Visitor.Search(searchDate, searchSelection);
				}
				else if (rdbtnEntryDate.isSelected()) {
					searchSelection = SearchType.EntryDate;
					data = Visitor.Search(searchDate, searchSelection);
				}
				
				// RedrawTable
				RedrawTable(data, scrollPaneTable);
				
				// Checks if there's results
				System.out.println(data.length);
				System.out.print("hasSearchResults: ");
				System.out.println(data.length > 0);
				if (data.length <= 0) {
					JOptionPane.showMessageDialog(frmAdminPanel, "SearchType: " + searchSelection + " | No Search Results found");
				}
			}
		});
		
		Panel panelTitleArea = new Panel();
		frmAdminPanel.getContentPane().add(panelTitleArea, BorderLayout.NORTH);
		panelTitleArea.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTime = new JLabel("COVID-19 Logger");
		lblTime.setFont(new Font("Arial", Font.BOLD, 14));
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitleArea.add(lblTime, BorderLayout.CENTER);
		
		Button btnLogOut = new Button("< Log Out");
		btnLogOut.setName("btnLogOut");
		panelTitleArea.add(btnLogOut, BorderLayout.WEST);
		btnLogOut.setFont(new Font("Arial", Font.PLAIN, 12));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(btnLogOut.getName() + " is clicked.");
				AdminLogin newAdminLogin = new AdminLogin();
				newAdminLogin.setVisible(true);
				frmAdminPanel.setVisible(false);
				frmAdminPanel.dispose();
			}
		});
		
		JLabel lblLiveDate = new JLabel("Month day, year - HH:MM");
		lblLiveDate.setFont(new Font("Arial", Font.PLAIN, 11));
		lblLiveDate.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitleArea.add(lblLiveDate, BorderLayout.SOUTH);
		
		Component horizontalStrut = Box.createHorizontalStrut(53);
		panelTitleArea.add(horizontalStrut, BorderLayout.EAST);
		
		Home newHome = new Home();
		newHome.liveDate(lblLiveDate);
		
		frmAdminPanel.getContentPane().add(scrollPaneTable, BorderLayout.CENTER);
	}
	
	// custom Methods
		protected void RedrawTable(String[][] data, JScrollPane scrollPane) {
			tblResults = new JTable(data, column);
			tblResults.setFont(new Font("Arial", Font.PLAIN, 11));
			tblResults.getTableHeader().setResizingAllowed(true);
			tblResults.getTableHeader().setReorderingAllowed(false);
			tblResults.setEnabled(false);
			scrollPane.setViewportView(tblResults);
		}
		
		
		public void setVisible(boolean isVisible) {
			frmAdminPanel.setVisible(isVisible);
		}
}
