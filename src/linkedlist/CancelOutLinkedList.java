package linkedlist;


public class CancelOutLinkedList {
	public static void main(String[] args) {
		//{6, -6, 8, 4, -12, 9, 8, -8}
		//{4, 6, -10, 8, 9, 10, -19, 10, -18, 20, 25}
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		list.add(6);
		list.add(-6);
		list.add(8);
		list.add(4);
		list.add(-12);
		list.add(9);
		list.add(8);
		list.add(-8);
		System.out.println(findCancelledList(list));
		
		MyLinkedList<Integer> list2 = new MyLinkedList<Integer>();
		list2.add(4);
		list2.add(6);
		list2.add(-10);
		list2.add(8);
		list2.add(9);
		list2.add(10);
		list2.add(-19);
		list2.add(10);
		list2.add(-18);
		list2.add(20);
		list2.add(25);
		
		System.out.println(findCancelledList(list2));
	}

	private static MyLinkedList<Integer> findCancelledList(
			MyLinkedList<Integer> list) {
		Node<Integer> tail = list.head;
		int sum = 0;
		
		while(tail != null) {
			while(tail != null && tail.getValue() > 0) {
				sum += tail.getValue();
				tail = tail.next;
				if(tail == null) {
					return list;
				}
			}
			if(sum + tail.getValue() == 0) {
				sum = 0;
				tail = tail.next;
				while(list.head != tail) {
					list.head = list.head.next;
					list.size--;
				}
			} else if(sum + tail.getValue() > 0) {
				sum = sum + tail.getValue();
				if(sum == list.head.getValue()) {
					list.head.next = tail.next;
				}
				tail = tail.next;
			}
		}
		
		return list;
	}
}
