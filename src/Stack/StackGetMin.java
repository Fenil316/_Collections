package Stack;


public class StackGetMin {
	int pointer = -1;
	int size = 10;
	int minElem = Integer.MIN_VALUE;
	int[] arr = new int[size];

	private boolean isEmpty() {
		return pointer == -1;
	}

	private void push(int element) {
		if(pointer == size) {
			System.out.println("Stack is full!");
		} else {
			if(isEmpty()) {
				minElem = element;
			} else {
				if(element < minElem) {
					int temp = 2*element - minElem;
					minElem = element;
					element = temp;
				}
			}
			pointer++;
			arr[pointer] = element;
		}
	}

	private int pop() {
		if(isEmpty()) {
			System.out.println("Stack is empty!");
			return Integer.MIN_VALUE;
		} else {
			int popped = arr[pointer];
			if(popped < minElem) {
				int temp = minElem;
				minElem = 2*minElem - popped;
				popped = temp;
			}
			arr[pointer] = 0;
			pointer--;
			return popped;
		}
	}

	private int getMin() {
		return minElem;
	}

	public static void main(String[] args) {
		StackGetMin stack = new StackGetMin();
		stack.push(3);
		stack.push(5);
		stack.push(2);
		stack.push(1);
		stack.push(1);
		stack.push(-1);
		System.out.println("Min element in the stack: " + stack.getMin());
		System.out.println("Popped: " + stack.pop());
		System.out.println("Popped: " + stack.pop());
		System.out.println("Popped: " + stack.pop());
		System.out.println("Popped: " + stack.pop());
		System.out.println("Min element in the stack: " + stack.getMin());
	}
}
