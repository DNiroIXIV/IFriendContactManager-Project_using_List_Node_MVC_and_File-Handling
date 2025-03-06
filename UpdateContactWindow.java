import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.text.*;

public class UpdateContactWindow extends JFrame {
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

	private JButton btnUpdate;
	private JButton btnCancel;
	private JButton btnBackToHomePage;
	private JButton btnSearch;

	public UpdateContactWindow() {
		setSize(1100, 750);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);

		JPanel northPanel = new JPanel(new GridLayout(2, 1));

		JLabel lblUpdateContact = new JLabel("UPDATE CONTACT", SwingConstants.CENTER);
		lblUpdateContact.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblUpdateContact.setOpaque(true);
		lblUpdateContact.setBackground(new Color(150, 210, 255));
		lblUpdateContact.setPreferredSize(new Dimension(0, 60));
		northPanel.add(lblUpdateContact);

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
		lblContactId.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblContactId.setPreferredSize(new Dimension(280, 50));
		contactIdPanel.add(lblContactId);

		txtContactId = new JFormattedTextField();
		txtContactId.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
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
		lblName.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblName.setPreferredSize(new Dimension(280, 50));
		namePanel.add(lblName);

		txtName = new JFormattedTextField();
		txtName.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		txtName.setMargin(new Insets(5, 10, 5, 0));
		txtName.setColumns(20);
		txtName.setName("nameTextField");
		txtName.setInputVerifier(new TextFieldInputVerifier());
		namePanel.add(txtName);

		midPanel.add(namePanel);

		JPanel contactNumberPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblContactNumber.setPreferredSize(new Dimension(280, 50));
		contactNumberPanel.add(lblContactNumber);

		txtContactNumber = getFormattedTextFieldWithMask("##########", '_');
		txtContactNumber.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		txtContactNumber.setMargin(new Insets(5, 10, 5, 0));
		txtContactNumber.setColumns(8);
		txtContactNumber.setName("contactNoTextField");
		txtContactNumber.setFocusLostBehavior(JFormattedTextField.COMMIT);
		txtContactNumber.setInputVerifier(new TextFieldInputVerifier());
		contactNumberPanel.add(txtContactNumber);

		midPanel.add(contactNumberPanel);

		JPanel companyNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		lblCompanyName = new JLabel("Company");
		lblCompanyName.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblCompanyName.setPreferredSize(new Dimension(280, 50));
		companyNamePanel.add(lblCompanyName);

		txtCompanyName = new JFormattedTextField();
		txtCompanyName.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		txtCompanyName.setMargin(new Insets(5, 10, 5, 0));
		txtCompanyName.setColumns(20);
		txtCompanyName.setName("companyTextField");
		txtCompanyName.setInputVerifier(new TextFieldInputVerifier());
		companyNamePanel.add(txtCompanyName);

		midPanel.add(companyNamePanel);

		JPanel salaryPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblSalary.setPreferredSize(new Dimension(280, 50));
		salaryPanel.add(lblSalary);

		txtSalary = new JFormattedTextField();
		txtSalary.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		txtSalary.setMargin(new Insets(5, 10, 5, 0));
		txtSalary.setColumns(20);
		txtSalary.setName("salaryTextField");
		DecimalFormat salaryFormat = new DecimalFormat();
		salaryFormat.setMinimumFractionDigits(2);
		salaryFormat.setMaximumFractionDigits(2);
		NumberFormatter salaryFormatter = new NumberFormatter(salaryFormat);
		salaryFormatter.setAllowsInvalid(false);
		salaryFormatter.setCommitsOnValidEdit(true);
		txtSalary.setFormatterFactory(new DefaultFormatterFactory(salaryFormatter));
		txtSalary.setInputVerifier(new TextFieldInputVerifier());
		salaryPanel.add(txtSalary);

		midPanel.add(salaryPanel);

		JPanel birthdayPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		lblBirthday = new JLabel("Birthday");
		lblBirthday.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		lblBirthday.setPreferredSize(new Dimension(280, 50));
		birthdayPanel.add(lblBirthday);

		txtBirthday = getFormattedTextFieldWithMask("####-##-##", '_');
		txtBirthday.setFont(new Font("Trebuchet MS", Font.PLAIN, 25));
		txtBirthday.setMargin(new Insets(5, 10, 5, 0));
		txtBirthday.setColumns(8);
		txtBirthday.setName("birthdayTextField");
		txtBirthday.setFocusLostBehavior(JFormattedTextField.COMMIT);
		txtBirthday.setInputVerifier(new TextFieldInputVerifier());
		birthdayPanel.add(txtBirthday);

		midPanel.add(birthdayPanel);

		add(midPanel, BorderLayout.CENTER);

		JPanel southPanel = new JPanel(new GridLayout(2, 1, 0, 30));
		southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

		JPanel upperPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 30, 0));

		btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnUpdate.setPreferredSize(new Dimension(200, 40));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (!hasEmptyField()) {
					String contactId = txtContactId.getText();
					String name = txtName.getText();
					String contactNumber = txtContactNumber.getText();
					String companyName = txtCompanyName.getText();
					String salary = txtSalary.getText();
					String birthday = txtBirthday.getText();

					Contact contact = new Contact(contactId, name, contactNumber, companyName, salary, birthday);
					try {
						boolean isUpdated = ContactController.updateContact(contact);
						if (isUpdated) {
							JOptionPane.showMessageDialog(UpdateContactWindow.this, "Contact Updated Successfully...","Success", JOptionPane.INFORMATION_MESSAGE);
							txtSearch.setText("");
							clearTextFields();
						} else {
							JOptionPane.showMessageDialog(UpdateContactWindow.this,"Conatct \"" + txtSearch.getText() + "\" Updation Failed!", "Error",JOptionPane.ERROR_MESSAGE);
						}
					} catch (IOException ex) {
						// handle exception
					}
				}
			}
		});
		upperPanel.add(btnUpdate);

		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnCancel.setPreferredSize(new Dimension(180, 40));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				clearTextFields();
				txtSearch.requestFocusInWindow();
			}
		});
		upperPanel.add(btnCancel);

		southPanel.add(upperPanel);

		JPanel lowerPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 30, 0));

		btnBackToHomePage = new JButton("Back To HomePage");
		btnBackToHomePage.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnBackToHomePage.setPreferredSize(new Dimension(410, 40));
		btnBackToHomePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dispose();
				IFriendContactManager.getHomePageWindow().setVisible(true);
			}
		});
		upperPanel.add(btnBackToHomePage);

		lowerPanel.add(btnBackToHomePage);

		southPanel.add(lowerPanel);

		add(southPanel, BorderLayout.SOUTH);

		addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent evt) {
				IFriendContactManager.getHomePageWindow().setVisible(true);
			}
		});

		setVisible(true);
	}

	public JFormattedTextField[] getTextFieldList() {
		JFormattedTextField[] textFieldList = { txtContactId, txtName, txtContactNumber, txtCompanyName, txtSalary, txtBirthday };
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
					case "birthdayTextField": {
						textField.setText("");
					}
						break;
					case "salaryTextField": {
						textField.setValue(null);
					}
				}
			}
		}
	}

	public boolean hasEmptyField() {
		JFormattedTextField[] textFieldList = getTextFieldList();
		String[] labelNameList = { "Contact ID", "Name", "Contact Number", "Company", "Salary", "Birthday" };
		for (int i = 0; i < textFieldList.length; i++) {
			if (textFieldList[i] != null) {
				String text = textFieldList[i].getText();
				switch (textFieldList[i].getName()) {
					case "contactIdTextField": {
						if (text.isEmpty()) {
							JOptionPane.showMessageDialog(UpdateContactWindow.this,"Contact has not been loaded to update!", "Warning!", JOptionPane.WARNING_MESSAGE);
							return true;
						}
					}
						break;
					case "nameTextField":
					case "companyTextField":
					case "salaryTextField": {
						if (text.isEmpty()) {
							JOptionPane.showMessageDialog(UpdateContactWindow.this,labelNameList[i] + " field cannot be empty!", "Empty Field Error",JOptionPane.INFORMATION_MESSAGE);
							textFieldList[i].requestFocusInWindow();
							return true;
						}
					}
						break;
					case "contactNoTextField": {
						String emptyField = "";
						for (int j = 0; j < 10; j++) {
							emptyField += "_";
						}

						if (text.equals(emptyField)) {
							JOptionPane.showMessageDialog(null, labelNameList[i] + " field cannot be empty!","Empty Field Error", JOptionPane.INFORMATION_MESSAGE);
							textFieldList[i].requestFocusInWindow();
							return true;
						}
					}
						break;
					case "birthdayTextField": {
						if (text.equals("____-__-__")) {
							JOptionPane.showMessageDialog(null, labelNameList[i] + " field cannot be empty!","Empty Field Error", JOptionPane.INFORMATION_MESSAGE);
							textFieldList[i].requestFocusInWindow();
							return true;
						}
					}
				}
			}
		}
		return false;
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
				JOptionPane.showMessageDialog(UpdateContactWindow.this,"Contact \"" + searchText + "\" could not be found!", "", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (IOException ex) {
			// handle exception
		}
	}

	private JFormattedTextField getFormattedTextFieldWithMask(String maskFormat, char placeHolder) {
		JFormattedTextField formattedTextField = new JFormattedTextField();

		try {
			MaskFormatter maskFormatter = new MaskFormatter(maskFormat);
			maskFormatter.setPlaceholderCharacter(placeHolder);
			formattedTextField = new JFormattedTextField(maskFormatter);
		} catch (ParseException ex) {
			// handle exception
		}
		return formattedTextField;
	}
}