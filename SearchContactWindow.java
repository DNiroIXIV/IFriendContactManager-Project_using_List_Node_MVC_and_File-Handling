import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class SearchContactWindow extends JFrame {
	private JLabel lblContactId;
	private JLabel lblName;
	private JLabel lblContactNumber;
	private JLabel lblCompanyName;
	private JLabel lblSalary;
	private JLabel lblBirthday;

	private JFormattedTextField txtContactId;
	private JFormattedTextField txtName;
	private JFormattedTextField txtContactNumber;
	private JFormattedTextField txtCompanyName;
	private JFormattedTextField txtSalary;
	private JFormattedTextField txtBirthday;
	private JFormattedTextField txtSearch;

	private JButton btnSearch;
	private JButton btnBackToHomePage;

	public SearchContactWindow() {
		setSize(1100, 750);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);

		JPanel northPanel = new JPanel(new GridLayout(2, 1));

		JLabel lblSearchContact = new JLabel("SEARCH CONTACT", SwingConstants.CENTER);
		lblSearchContact.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblSearchContact.setOpaque(true);
		lblSearchContact.setBackground(new Color(150, 210, 255));
		lblSearchContact.setPreferredSize(new Dimension(0, 60));
		northPanel.add(lblSearchContact);

		JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 80, 20));

		txtSearch = new JFormattedTextField();
		txtSearch.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		txtSearch.setMargin(new Insets(5, 10, 5, 10));
		txtSearch.setColumns(20);
		txtSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				clearTextFields();
				loadContactDetails();
			}
		});
		searchPanel.add(txtSearch);

		btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Arial", Font.BOLD, 25));
		btnSearch.setBackground(new Color(216, 216, 215));
		btnSearch.setPreferredSize(new Dimension(160, 40));
		btnSearch.setBorder(BorderFactory.createRaisedBevelBorder());
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				clearTextFields();
				loadContactDetails();
			}
		});

		searchPanel.add(btnSearch);

		northPanel.add(searchPanel);

		add(northPanel, BorderLayout.NORTH);

		JPanel midPanel = new JPanel(new GridLayout(6, 1));
		midPanel.setBorder(BorderFactory.createEmptyBorder(0, 80, 10, 80));

		JPanel contactIdPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		lblContactId = new JLabel("Contact ID");
		lblContactId.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblContactId.setPreferredSize(new Dimension(300, 50));
		contactIdPanel.add(lblContactId);

		txtContactId = new JFormattedTextField();
		txtContactId.setFont(new Font("Verdana", Font.PLAIN, 30));
		txtContactId.setForeground(new Color(67, 72, 87));
		txtContactId.setMargin(new Insets(5, 10, 5, 0));
		txtContactId.setColumns(8);
		txtContactId.setOpaque(true);
		txtContactId.setEditable(false);
		txtContactId.setBorder(null);
		txtContactId.setName("contactIdTextField");
		contactIdPanel.add(txtContactId);

		midPanel.add(contactIdPanel);

		JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		lblName = new JLabel("Name");
		lblName.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblName.setPreferredSize(new Dimension(300, 50));
		namePanel.add(lblName);

		txtName = new JFormattedTextField();
		txtName.setFont(new Font("Verdana", Font.PLAIN, 30));
		txtName.setMargin(new Insets(5, 10, 5, 0));
		txtName.setForeground(new Color(67, 72, 87));
		txtName.setColumns(20);
		txtName.setOpaque(true);
		txtName.setEditable(false);
		txtName.setBorder(null);
		txtName.setName("nameTextField");
		namePanel.add(txtName);

		midPanel.add(namePanel);

		JPanel contactNumberPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblContactNumber.setPreferredSize(new Dimension(300, 50));
		contactNumberPanel.add(lblContactNumber);

		txtContactNumber = new JFormattedTextField();
		txtContactNumber.setFont(new Font("Verdana", Font.PLAIN, 30));
		txtContactNumber.setMargin(new Insets(5, 10, 5, 0));
		txtContactNumber.setForeground(new Color(67, 72, 87));
		txtContactNumber.setColumns(8);
		txtContactNumber.setOpaque(true);
		txtContactNumber.setEditable(false);
		txtContactNumber.setBorder(null);
		txtContactNumber.setName("contactNoTextField");
		contactNumberPanel.add(txtContactNumber);

		midPanel.add(contactNumberPanel);

		JPanel companyNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		lblCompanyName = new JLabel("Company");
		lblCompanyName.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblCompanyName.setPreferredSize(new Dimension(300, 50));
		companyNamePanel.add(lblCompanyName);

		txtCompanyName = new JFormattedTextField();
		txtCompanyName.setFont(new Font("Verdana", Font.PLAIN, 30));
		txtCompanyName.setMargin(new Insets(5, 10, 5, 0));
		txtCompanyName.setForeground(new Color(67, 72, 87));
		txtCompanyName.setColumns(20);
		txtCompanyName.setOpaque(true);
		txtCompanyName.setEditable(false);
		txtCompanyName.setBorder(null);
		txtCompanyName.setName("companyTextField");
		companyNamePanel.add(txtCompanyName);

		midPanel.add(companyNamePanel);

		JPanel salaryPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblSalary.setPreferredSize(new Dimension(300, 50));
		salaryPanel.add(lblSalary);

		txtSalary = new JFormattedTextField();
		txtSalary.setFont(new Font("Verdana", Font.PLAIN, 30));
		txtSalary.setMargin(new Insets(5, 10, 5, 0));
		txtSalary.setForeground(new Color(67, 72, 87));
		txtSalary.setColumns(20);
		txtSalary.setOpaque(true);
		txtSalary.setEditable(false);
		txtSalary.setBorder(null);
		txtSalary.setName("salaryTextField");
		salaryPanel.add(txtSalary);

		midPanel.add(salaryPanel);

		JPanel birthdayPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		lblBirthday = new JLabel("Birthday");
		lblBirthday.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblBirthday.setPreferredSize(new Dimension(300, 50));
		birthdayPanel.add(lblBirthday);

		txtBirthday = new JFormattedTextField();
		txtBirthday.setFont(new Font("Verdana", Font.PLAIN, 30));
		txtBirthday.setMargin(new Insets(5, 10, 5, 0));
		txtBirthday.setForeground(new Color(67, 72, 87));
		txtBirthday.setColumns(8);
		txtBirthday.setOpaque(true);
		txtBirthday.setEditable(false);
		txtBirthday.setBorder(null);
		txtBirthday.setName("birthdayTextField");
		birthdayPanel.add(txtBirthday);

		midPanel.add(birthdayPanel);

		add(midPanel, BorderLayout.CENTER);

		JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 50, 30));

		btnBackToHomePage = new JButton("Back To HomePage");
		btnBackToHomePage.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnBackToHomePage.setPreferredSize(new Dimension(400, 50));
		btnBackToHomePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dispose();
				IFriendContactManager.getHomePageWindow().setVisible(true);
			}
		});
		southPanel.add(btnBackToHomePage);

		add(southPanel, BorderLayout.SOUTH);

		addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent evt) {
				IFriendContactManager.getHomePageWindow().setVisible(true);
			}
		});

		setVisible(true);
	}

	public void loadContactDetails() {
		String searchText = txtSearch.getText();
		try {
			Contact contact = ContactController.searchByNameOrContactNo(searchText);
			if (contact != null) {
				txtContactId.setText(contact.getContactId());
				txtName.setText(contact.getName());
				txtContactNumber.setText(contact.getContactNumber());
				txtCompanyName.setText(contact.getCompanyName());
				txtSalary.setText(contact.getSalary());
				txtBirthday.setText(contact.getBirthday());
			} else {
				JOptionPane.showMessageDialog(SearchContactWindow.this, "Contact \"" + searchText + "\" could not be found!", "", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (IOException ex) {
			// handle exception
		}
	}

	public JFormattedTextField[] getTextFieldList() {
		JFormattedTextField[] textFieldList = { txtContactId, txtName, txtContactNumber, txtCompanyName, txtSalary,
				txtBirthday };
		return textFieldList;
	}

	public void clearTextFields() {
		JFormattedTextField[] textFieldList = getTextFieldList();
		for (JFormattedTextField textField : textFieldList) {
			if (textField != null) {
				switch (textField.getName()) {
					case "contactIdTextField":
					case "nameTextField":
					case "contactNoTextField":
					case "companyTextField":
					case "salaryTextField":
					case "birthdayTextField": {
						textField.setText("");
					}
				}
			}
		}
	}
}