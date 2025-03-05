public class Contact {
	private String contactId;
	private String name;
	private String contactNumber;
	private String companyName;
	private String salary;
	private String birthday;

	public Contact() {
	}

	public Contact(String contactId, String name, String contactNumber, String companyName, String salary, String birthday) {
		setContactId(contactId);
		setName(name);
		setContactNumber(contactNumber);
		setCompanyName(companyName);
		setSalary(salary);
		setBirthday(birthday);
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getContactId() {
		return contactId;
	}

	public String getName() {
		return name;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getSalary() {
		return salary;
	}

	public String getBirthday() {
		return birthday;
	}

	public boolean isIdEquals(Contact contact) {
		return contactId.equals(contact.contactId);
	}

	public boolean isNameEquals(Contact contact) {
		return name.equals(contact.name);
	}

	public boolean isContactNumberEquals(Contact contact) {
		return contactNumber.equals(contact.contactNumber);
	}

	public String toString() {
		return contactId + ";" + name + ";" + contactNumber + ";" + companyName + ";" + salary + ";" + birthday;
	}

	public int nameCompareToIgnoreCase(Contact contact) {
		return name.compareToIgnoreCase(contact.name);
	}

	public int nameCompareTo(Contact contact) {
		return name.compareTo(contact.name);
	}

	public int birthdayCompareTo(Contact contact) {
		return birthday.compareTo(contact.birthday);
	}

	public Object[] getContactDetails() {
		Object[] rowData = { contactId, name, contactNumber, companyName, salary, birthday };
		return rowData;
	}
}
