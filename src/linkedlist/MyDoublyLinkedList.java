package linkedlist;

public class MyDoublyLinkedList<T> {
	Node<T> head;
	int size;
	
	public boolean add(T value) {
		Node<T> newNode = new Node<T>(value, null, null);
		Node<T> currentNode = head;
		if(head == null) {
			head = newNode;
			head.setValue(value);
			size++;
			return true;
		} else {
			while(currentNode.getNext() != null) {
				currentNode = currentNode.next;
			}
			newNode.prev = currentNode;
			System.out.println(newNode.prev);
			currentNode.next = newNode;
		}
		size++;
		return true;
	}
	
	public boolean add(int index, T value) {
		Node<T> newNode = new Node<T>(value, null, null);
		Node<T> currentNode = head;
		Node<T> nextNode;
		int count = 0;
		if(index > size) {
			throw new IndexOutOfBoundsException();
		} else {
			while(index - 1 > count) {
				currentNode = currentNode.next;
				count++;
			}
			nextNode = currentNode.next;
			newNode.prev = currentNode;
			newNode.next = currentNode.next;
			currentNode.next = newNode;
			nextNode.prev = newNode;
			size++;
		}
		
		return true;
	}
	
	public boolean remove(int index) {
		Node<T> currentNode = head;
		int count = 0;
		if(size == 0) {
			throw new IndexOutOfBoundsException();
		}
		if(index == 0) {
			head = head.next;
			size--;
			return true;
		}
		if(index > size - 1) {
			throw new IndexOutOfBoundsException();
		} else {
			while(index > count) {
				currentNode = currentNode.next;
				count++;
			}
			System.out.println("Prev node: " + currentNode.prev);
			System.out.println("Next node: " + currentNode.next);
			currentNode.prev.next = currentNode.next;
			size--;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return "MyLinkedList: [head = " + head + ", size = " + size + "]";
	}
	
	public static void main(String[] args) {
		MyDoublyLinkedList<String> list1 = new MyDoublyLinkedList<String>();
		list1.add("Fenil");
		System.out.println(list1);
		list1.add("Stavan");
		System.out.println(list1);
		list1.add("Rinkle");
		System.out.println(list1);
		list1.add("mummy");
		System.out.println(list1);
		list1.add(1, "Hajmola");
		System.out.println(list1);
		list1.add(1, "Hajmola2");
		System.out.println(list1);
		list1.add(3, "udupi");
		System.out.println(list1);
		list1.remove(0);
		System.out.println(list1);
		list1.remove(3);
		System.out.println(list1);
	}
}
