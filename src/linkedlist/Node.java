package linkedlist;

public class Node<T> {
	T value;
	Node<T> prev;
	Node<T> next;
	
	public Node (T value, Node<T> next) {
		this.value = value;
		this.next = next;
	}
	
	public Node(T value, Node<T> prev, Node<T> next) {
		this.value = value;
		this.prev = prev;
		this.next = next;
	}
	
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public Node<T> getPrev() {
		return prev;
	}
	public void setPrev(Node<T> prev) {
		this.prev = prev;
	}
	public Node<T> getNext() {
		return next;
	}
	public void setNext(Node<T> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + ", next=" + next
				+ "]";
	}
	
}
