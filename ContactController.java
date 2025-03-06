import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ContactController {
    public static boolean addContact(Contact contact) throws IOException {
        FileWriter fileWriter = new FileWriter("Contact.txt", true);
        fileWriter.write(contact.toString() + "\n");
        fileWriter.close();
        return true;
    }

    public static ContactsList getContactsList() throws IOException {
        ContactsList contactsList = new ContactsList();
        FileReader fileReader = new FileReader("Contact.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String contactData = bufferedReader.readLine();
        while (contactData != null) {
            String[] rowData = contactData.split(";");
            Contact contact = new Contact(rowData[0], rowData[1], rowData[2], rowData[3], rowData[4], rowData[5]);
            contactsList.add(contact);
            contactData = bufferedReader.readLine();
        }
        bufferedReader.close();
        return contactsList;
    }

    public static Contact getLastContact() throws IOException {
        ContactsList contactsList = getContactsList();
        return contactsList.getContact(contactsList.size() - 1);
    }

    public static Contact searchByNameOrContactNo(String nameOrContactNo) throws IOException {
        ContactsList contactsList = getContactsList();
        Contact dummyContact = new Contact(null, nameOrContactNo, nameOrContactNo, null, null, null);
        for (int i = 0; i < contactsList.size(); i++) {
            Contact contact = contactsList.getContact(i);
            if (contact.isNameEquals(dummyContact) || contact.isContactNumberEquals(dummyContact)) {
                return contact;
            }
        }
        return null;
    }

    public static boolean updateContact(Contact contact) throws IOException {
        ContactsList contactsList = getContactsList();
        int index = contactsList.indexOf(contact);
        if (index != -1) {
            boolean isSet = contactsList.setContact(index, contact);
            writeToFile(isSet, contactsList);
            return isSet;
        }
        return false;
    }

    public static boolean deleteContact(String contactId) throws IOException{
        ContactsList contactsList = getContactsList();
        int index = contactsList.indexOf(new Contact(contactId,null,null,null,null,null));
        if (index != -1) {
            boolean isRemoved = contactsList.remove(index);
            writeToFile(isRemoved, contactsList);
            return isRemoved;
        }
        return false;
    }

    public static void writeToFile(boolean isUpdatdOrDeleted, ContactsList contactsList) throws IOException{
        if (isUpdatdOrDeleted) {
            FileWriter fileWriter = new FileWriter("Contact.txt");
            for (int i = 0; i < contactsList.size(); i++) {
                fileWriter.write(contactsList.getContact(i).toString() + "\n");
            }
            fileWriter.close();
        }
    }
}