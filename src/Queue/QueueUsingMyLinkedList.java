package Queue;

import linkedlist.MyLinkedList;

public class QueueUsingMyLinkedList<T> {
	
	MyLinkedList<T> llist = new MyLinkedList<T>();
	private int first = 0;
	private int last = llist.size;
	
	public int size() {
		return last;
		
	}
	
	public void enqueue(T x) {
		llist.add(last, x);
		last = llist.size;
	}
	
	public T dequeue() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return null;
		}
		T removed = llist.remove(first);
		if(removed != null) {
			last--;
			return removed;
		}
		return null;
	}
	
	public boolean isEmpty() {
		return (first == last);
	}
	
	public static void main(String[] args) {
		QueueUsingMyLinkedList<Integer> q = new QueueUsingMyLinkedList<>();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
		q.enqueue(7);
		q.enqueue(8);
		
		int x = q.dequeue();
		int y = q.dequeue();
		int z = q.dequeue();
		
		q.enqueue(x);
		q.enqueue(y);
		q.enqueue(z);
		
		System.out.println(q);
	}

	@Override
	public String toString() {
		return "Queue [llist=" + llist + ", last=" + last + "]";
	}
	
	
	
}
