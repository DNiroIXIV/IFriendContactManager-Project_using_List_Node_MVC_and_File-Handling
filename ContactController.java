import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ContactController {
    public static boolean addContact(Contact contact) throws IOException{
        FileWriter fileWriter = new FileWriter("Contact.txt",true);
        fileWriter.write(contact.toString()+"\n");
        fileWriter.close();
        return true;
    }

    public static ContactsList getContactsList() throws IOException{
        ContactsList contactsList = new ContactsList();
        FileReader fileReader = new FileReader("Contact.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String contactData = bufferedReader.readLine();
        while (contactData != null) {
            String[] rowData = contactData.split(";");
            Contact contact= new Contact(rowData[0],rowData[1],rowData[2],rowData[3],rowData[4],rowData[5]);
            contactsList.add(contact);
            contactData = bufferedReader.readLine();
        }
        bufferedReader.close();
        return contactsList;
    }

    public static Contact getLastContact() throws IOException{
        ContactsList contactsList = getContactsList();
        return contactsList.getContact(contactsList.size()-1);
    }
}
