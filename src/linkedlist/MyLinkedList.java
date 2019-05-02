package linkedlist;


public class MyLinkedList<T> {
	Node<T> head;
	public int size;
	
	public boolean add(T item) {
		Node<T> newNode = new Node<T>(item, null);
		Node<T> currentNode = head;
		if(head == null) {
			head = newNode;
			size++;
			return true;
		} else {
			while(currentNode.next != null) {
				currentNode = currentNode.next;
			}
			currentNode.next = newNode;
			size++;
		}
		return true;
	}
	
	public void add(int index, T item) {
		int count = 1;
		Node<T> newNode = new Node<T>(item, null);
		Node<T> currentNode = head;
		Node<T> temp = head;
		if(index > size) {
			throw new IndexOutOfBoundsException();
		} 
		if(index == 0) {
			temp = head;
			head = newNode;
			head.next = temp;
		} else {
				while(count <= index) {
					temp = currentNode;
					currentNode = currentNode.next;
					count++;
				}
			temp.next = newNode;
			newNode.next = currentNode;
		}
		
		size++;
	}
	
	public T remove(int index) {
		T value;
		Node<T> currentNode = head;
		Node<T> prevNode = head;
		int count = 1;
		if(head == null || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		if(index == 0) {
			value = head.value;
			head = head.next;
			size--;
			return value;
		} else {
			currentNode = head.next;
			while(currentNode.next != null) {
				if(count == index) {
					break;
				}
				currentNode = currentNode.next;
				prevNode = prevNode.next;
			}
			value = currentNode.value;
			prevNode.next = currentNode.next;
			size--;
		}
		return value;
	}
	
	@Override
	public String toString() {
		return "MyLinkedList: [head = " + head + ", size = " + size + "]";
	}
	
	public static void main(String args[]) {
		MyLinkedList<String> llist = new MyLinkedList<String>();
		llist.add("Fenil");
		System.out.println(llist);
		llist.add("Rushit");
		System.out.println(llist);
		llist.add("Stavan");
		System.out.println(llist);
		llist.remove(1);
		System.out.println(llist);
		llist.remove(1);
		System.out.println(llist);
		llist.remove(0);
		System.out.println(llist);
		
		llist.add(0, "Fenil");
		System.out.println(llist);
		llist.add(1, "Stavan");
		System.out.println(llist);
		llist.add("Rushit");
		System.out.println(llist);
		
		llist.remove(1);
		System.out.println(llist);
		
		
		Double arr[] = {4.5,4.7,5.8,2.3,6.6,4.8};
		Double arr1[] = new Double[0];
		
/*		List<Double> list1 = Arrays.asList(arr);
		arr1 = list1.toArray(new Double[arr.length]);
		Arrays.sort(arr1);
		System.out.println("Here" + arr1);
		
		
		List<Double> arrList = Arrays.asList(arr);
		System.out.println(arrList);
		Collections.sort(arrList);
		for(int i=0;i<arrList.size() ;i++) {
			System.out.println(arr[i]);
		}
		arrList.toArray(arr1);*/
	}
}
