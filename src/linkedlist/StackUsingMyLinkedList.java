package linkedlist;

public class StackUsingMyLinkedList {

	MyLinkedList<Integer> llist = new MyLinkedList<Integer>();
	private int pointer = 0;
	
	public void push(Integer i) {
		llist.add(pointer, i);
		pointer++;
	}
	
	public Integer pop() {
		if(pointer == 0) {
			System.out.println("No element in the stack");
			return -1;
		}
		pointer--;
		return llist.remove(pointer);
	}
	
	@Override
	public String toString() {
		return "StackUsingLinkedList: [" + llist + " pointer: " + pointer + "]";
	}
	
	public static void main(String[] args) {
		StackUsingMyLinkedList stack = new StackUsingMyLinkedList();
		stack.push(1);
		System.out.println("Pushed 1:");
		stack.push(2);
		System.out.println("Pushed 2:");
		System.out.println("Poped " + stack.pop());
		stack.push(3);
		System.out.println("Pushed 3:");
		stack.push(4);
		System.out.println("Pushed 4:");
		System.out.println("Poped " + stack.pop());
		System.out.println("Poped " + stack.pop());
		System.out.println("Poped " + stack.pop());
		System.out.println("Poped " + stack.pop());
		System.out.println("Poped " + stack.pop());
		stack.push(5);
		System.out.println("Pushed 5:");
		System.out.println(stack);
		
	}
}
