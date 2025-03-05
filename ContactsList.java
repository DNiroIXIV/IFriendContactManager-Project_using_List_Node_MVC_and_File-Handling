public class ContactsList{
	private Contact[] contactsArray;
	private int nextIndex;
	private double loadFactor;
	private int initSize;
	
	public ContactsList(int initSize, double loadFactor){
		contactsArray = new Contact[initSize];
		nextIndex = 0;
		this.initSize = initSize;
		this.loadFactor = loadFactor;	
	}
	
	//---------- add contact to last of the contactsArray ----------------
	public void add(Contact contact){
		if(nextIndex >= contactsArray.length){
			extendsArray();
		}
		contactsArray[nextIndex++] = contact;		
	}	
	
	public boolean add(int index, Contact contact){
		if(nextIndex >= contactsArray.length){
			extendsArray();
		}
		if(index>=0 && index<=nextIndex){
			for(int i = nextIndex-1; i >= index; i--){
				contactsArray[i+1] = contactsArray[i];
			}
			contactsArray[index] = contact;
			nextIndex++;
			return true;
		}
		return false;
	}
	
	private void extendsArray(){
		Contact[] tempContactsArray = new Contact[(int)(contactsArray.length*(1+loadFactor))];
		for(int i = 0; i < contactsArray.length; i++){
			tempContactsArray[i] = contactsArray[i];
		}
		contactsArray = tempContactsArray;
	}
		
	//---------- remove the last contact of the contactsArray ----------------
	public void remove(){
		if(!isEmpty()){
			nextIndex--;
		}
	}
	
	public boolean remove(int index){
		if(index>=0 && index<nextIndex){
			for(int i = index; i < nextIndex-1; i++){
				contactsArray[i] = contactsArray[i+1];
			}			
			nextIndex--;
			return true;
		}
		return false;
	}
	
	public boolean remove(Contact contact){
		int index = indexOf(contact);
		return remove(index);
	}
	
	public int indexOf(Contact contact){
		for(int i = 0; i < nextIndex; i++){
			if(contact.isIdEquals(contactsArray[i])){
				return i;				
			}
		}
		return -1;
	}
	
	public boolean searchByContactId(Contact contact){
		return indexOf(contact) != -1;		
	}
	
	public int searchByNameOrContactNo(Contact contact){
		for(int i = 0; i < nextIndex; i++){
			if(contact.isNameEquals(contactsArray[i]) || contact.isContactNumberEquals(contactsArray[i])){
				return i;
			}			
		}
		return -1;
	}
	
	public boolean setContact(int index, Contact contact){
		if(index>=0 && index<nextIndex){
			contactsArray[index] = contact;
			return true;
		}
		return false;
	}
	
	public Contact getContact(int index){
		if(index>=0 && index<nextIndex){
			return contactsArray[index];
		}
		return null;
	}	
	
	public Contact[] getAllContacts(){
		Contact[] tempContactsArray = new Contact[nextIndex];
		for(int i = 0; i < nextIndex; i++){
			tempContactsArray[i] = contactsArray[i];
		}
		return tempContactsArray;
	}	
	
	public boolean isEmpty(){
		return nextIndex<=0;
	}
	
	public int size(){
		return nextIndex;
	}

	public void clear(){
		contactsArray = new Contact[initSize];
		nextIndex = 0;
	}
}
