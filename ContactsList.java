public class ContactsList {
	private Node firstNode;

	public ContactsList() {
		firstNode = null;
	}

	public boolean addFirst(Contact contact) {// add to the first
		Node node = new Node(contact);
		node.nextNode = firstNode;
		firstNode = node;
		return true;
	}

	public boolean addLast(Contact contact) {// add to the last/Insertion order
		if (isEmpty()) {
			return addFirst(contact);
		} else {
			Node node = new Node(contact);
			Node lastNode = firstNode;
			while (lastNode.nextNode != null) {
				lastNode = lastNode.nextNode;
			}
			lastNode.nextNode = node;
		}
		return true;
	}

	public boolean add(Contact contact) {// add per insertion order
		return addLast(contact);
	}

	public boolean add(int index, Contact contact) {
		if (index >= 0 && index <= size()) {
			if (index == 0) {
				return addFirst(contact);
			} else {
				Node node = new Node(contact);
				int i = 0;
				Node tempNode = firstNode;
				while (i < index - 1) {
					tempNode = tempNode.nextNode;
					i++;
				}
				node.nextNode = tempNode.nextNode;
				tempNode.nextNode = node;
				return true;
			}
		}
		return false;
	}

	public int indexOf(Contact contact) {
		int index = 0;
		Node tempNode = firstNode;
		while (tempNode != null) {
			if (contact.isIdEquals(tempNode.contact)) {
				return index;
			}
			tempNode = tempNode.nextNode;
			index++;
		}
		return -1;
	}

	public boolean search(Contact contact) {
		return indexOf(contact) != -1;
	}

	public boolean remove(int index) {
		if (index >= 0 && index < size() && !isEmpty()) {
			if (index == 0) {
				return removeFirst();
			}else{
				Node tempNode = firstNode;
				int i = 0;
				while (i < index-1) {
					tempNode = tempNode.nextNode;
					i++;
				}
				tempNode.nextNode = tempNode.nextNode.nextNode;
				return true;
			}
		}
		return false;
	}

	public boolean removeFirst() {
		if (!isEmpty()) {
			firstNode = firstNode.nextNode;
			return true;
		}
		return false;
	}	

	public boolean remove(Contact contact){
		return remove(indexOf(contact));
	}

	public Contact getContact(int index){
		if (index >= 0 && index < size() && !isEmpty()) {
			Node tempNode = firstNode;
			int i = 0;
			while (i < index) {
				tempNode = tempNode.nextNode;
				i++;
			}
			return tempNode.contact;
		}
		return null;
	}

	public boolean setContact(int index, Contact contact){
		if (index >= 0 && index < size() && !isEmpty()) {
			Node tempNode = firstNode;
			int i = 0;
			while (i < index) {
				tempNode = tempNode.nextNode;
				i++;
			}
			tempNode.contact = contact;
			return true;
		}
		return false;
	}

	public int size() {
		int count = 0;
		Node tempNode = firstNode;
		while (tempNode != null) {
			count++;
			tempNode = tempNode.nextNode;
		}
		return count;
	}

	public boolean isEmpty() {
		return firstNode == null;
	}

	public String toString(){
		Node tempNode = firstNode;
		String contactData = "";
		for (int i = 0; i < size(); i++) {
			contactData += "["+tempNode.contact.toString()+"]\n";
			tempNode = tempNode.nextNode;
		}
		return isEmpty()? "[empty]" : contactData;
	}

	public void printContactsList(){
		System.out.println(toString());
	}

	public Contact[] toArray(){
		Contact[] contactsArray = new Contact[size()];
		Node tempNode = firstNode;
		for (int i = 0; i < contactsArray.length; i++) {
			contactsArray[i] = tempNode.contact;
			tempNode = tempNode.nextNode;
		}
		return contactsArray;
	}

	public class Node {
		private Contact contact;
		private Node nextNode;

		public Node(Contact contact) {
			this.contact = contact;
		}
	}
}