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
			}else{
				Node node = new Node(contact);
				int i = 0;
				Node tempNode = firstNode;
				while (i < index-1) {
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

	public int size(){
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

	public class Node {
		private Contact contact;
		private Node nextNode;

		public Node(Contact contact) {
			this.contact = contact;
		}
	}
}