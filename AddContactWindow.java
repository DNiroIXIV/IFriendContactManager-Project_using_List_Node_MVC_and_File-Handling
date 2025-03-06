import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.text.*;

public class AddContactWindow extends JFrame {
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

	private JButton btnAddContact;
	private JButton btnCancel;
	private JButton btnBackToHomePage;

	public AddContactWindow() {
		setSize(1100, 750);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);

		JPanel northPanel = new JPanel(new GridLayout(2, 1));

		JLabel lblAddContact = new JLabel("ADD CONTACT", SwingConstants.CENTER);
		lblAddContact.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblAddContact.setOpaque(true);
		lblAddContact.setBackground(new Color(150, 210, 255));
		lblAddContact.setPreferredSize(new Dimension(0, 80));
		northPanel.add(lblAddContact);

		JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		idPanel.setBorder(BorderFactory.createEmptyBorder(10, 60, 0, 0));

		lblContactId = new JLabel("Contact ID - ");
		lblContactId.setFont(new Font("Tahoma", Font.BOLD, 30));
		idPanel.add(lblContactId);

		txtContactId = new JFormattedTextField();
		txtContactId.setFont(new Font("Tahoma", Font.BOLD, 30));
		txtContactId.setOpaque(true);
		txtContactId.setEditable(false);
		txtContactId.setBorder(null);
		txtContactId.setText(generateContactId());
		idPanel.add(txtContactId);

		northPanel.add(idPanel);

		add(northPanel, BorderLayout.NORTH);

		JPanel midPanel = new JPanel(new GridLayout(5, 1));
		midPanel.setBorder(BorderFactory.createEmptyBorder(0, 60, 10, 60));

		JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		lblName = new JLabel("Name");
		lblName.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblName.setPreferredSize(new Dimension(280, 50));
		namePanel.add(lblName);

		txtName = new JFormattedTextField();
		txtName.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		txtName.setMargin(new Insets(5, 10, 5, 0));
		txtName.setColumns(20);
		txtName.setName("nameTextField");
		txtName.setInputVerifier(new TextFieldInputVerifier());
		namePanel.add(txtName);

		midPanel.add(namePanel);

		JPanel contactNumberPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblContactNumber.setPreferredSize(new Dimension(280, 50));
		contactNumberPanel.add(lblContactNumber);

		txtContactNumber = getFormattedTextFieldWithMask("##########", '_');
		txtContactNumber.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		txtContactNumber.setMargin(new Insets(5, 10, 5, 0));
		txtContactNumber.setColumns(8);
		txtContactNumber.setName("contactNoTextField");
		txtContactNumber.setFocusLostBehavior(JFormattedTextField.COMMIT);
		txtContactNumber.setInputVerifier(new TextFieldInputVerifier());
		contactNumberPanel.add(txtContactNumber);

		midPanel.add(contactNumberPanel);

		JPanel companyNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		lblCompanyName = new JLabel("Company");
		lblCompanyName.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblCompanyName.setPreferredSize(new Dimension(280, 50));
		companyNamePanel.add(lblCompanyName);

		txtCompanyName = new JFormattedTextField();
		txtCompanyName.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		txtCompanyName.setMargin(new Insets(5, 10, 5, 0));
		txtCompanyName.setColumns(20);
		txtCompanyName.setName("companyTextField");
		txtCompanyName.setInputVerifier(new TextFieldInputVerifier());
		companyNamePanel.add(txtCompanyName);

		midPanel.add(companyNamePanel);

		JPanel salaryPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblSalary.setPreferredSize(new Dimension(280, 50));
		salaryPanel.add(lblSalary);

		txtSalary = new JFormattedTextField();
		txtSalary.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
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
		lblBirthday.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblBirthday.setPreferredSize(new Dimension(280, 50));
		birthdayPanel.add(lblBirthday);

		txtBirthday = getFormattedTextFieldWithMask("####-##-##", '_');
		txtBirthday.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
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

		btnAddContact = new JButton("ADD Contact");
		btnAddContact.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnAddContact.setPreferredSize(new Dimension(280, 50));
		btnAddContact.addActionListener(new ActionListener() {
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
						boolean isAdded = ContactController.addContact(contact);
						if (isAdded) {
							JOptionPane.showMessageDialog(AddContactWindow.this, "Contact Saved Successfully...", "Success", JOptionPane.INFORMATION_MESSAGE);
							clearTextFields();
							txtContactId.setText(generateContactId());
						} else {
							JOptionPane.showMessageDialog(AddContactWindow.this, "Contact Not Saved!", "Error!", JOptionPane.ERROR_MESSAGE);
						}
						txtName.requestFocusInWindow();
					} catch (IOException ex) {
						//
					}
				}
			}
		});
		upperPanel.add(btnAddContact);

		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnCancel.setPreferredSize(new Dimension(190, 50));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				clearTextFields();
				txtName.requestFocusInWindow();
			}
		});
		upperPanel.add(btnCancel);

		southPanel.add(upperPanel);

		JPanel lowerPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 30, 0));

		btnBackToHomePage = new JButton("Back To HomePage");
		btnBackToHomePage.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnBackToHomePage.setPreferredSize(new Dimension(500, 50));
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
		txtName.requestFocusInWindow();
	}

	private String generateContactId() {
		try {
			Contact lastContact = ContactController.getLastContact();
			if (lastContact == null) {
				return "C0001";
			}
			String lastContactId = lastContact.getContactId();
			int lastContactIdNumber = Integer.parseInt(lastContactId.substring(1));
			return String.format("C%04d", (lastContactIdNumber + 1));
		} catch (IOException ex) {
			return "";
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

	public JFormattedTextField[] getTextFieldList() {
		JFormattedTextField[] textFieldList = { txtName, txtContactNumber, txtCompanyName, txtSalary, txtBirthday };
		return textFieldList;
	}

	public void clearTextFields() {
		JFormattedTextField[] textFieldList = getTextFieldList();
		for (JFormattedTextField textField : textFieldList) {
			if (textField != null) {
				switch (textField.getName()) {
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
		String[] labelNameList = { "Name", "Contact Number", "Company", "Salary", "Birthday" };
		for (int i = 0; i < textFieldList.length; i++) {
			if (textFieldList[i] != null) {
				String text = textFieldList[i].getText();
				switch (textFieldList[i].getName()) {
					case "nameTextField":
					case "companyTextField":
					case "salaryTextField": {
						if (text.isEmpty()) {
							JOptionPane.showMessageDialog(AddContactWindow.this, labelNameList[i] + " field cannot be empty!", "Empty Field Error", JOptionPane.INFORMATION_MESSAGE);
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
							JOptionPane.showMessageDialog(AddContactWindow.this, labelNameList[i] + " field cannot be empty!", "Empty Field Error", JOptionPane.INFORMATION_MESSAGE);							
							textFieldList[i].requestFocusInWindow();
							return true;
						}
					}
						break;
					case "birthdayTextField": {
						if (text.equals("____-__-__")) {
							JOptionPane.showMessageDialog(AddContactWindow.this, labelNameList[i] + " field cannot be empty!", "Empty Field Error", JOptionPane.INFORMATION_MESSAGE);
							textFieldList[i].requestFocusInWindow();
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}