package Stack;

import java.util.Arrays;
import java.util.stream.Collectors;


public class Stack {
	
	private int pointer = -1;
	private int minIndex = 0;
	public int[] stack = new int[5];
	
	public void push(int num) {
		if(pointer == stack.length) {
			System.out.println("Cannot push, stack full..");
			return;
		}
		pointer++;
		stack[pointer] = num;
		if(pointer > 0 && stack[pointer-1] > num) {
			minIndex = pointer;
		}
		System.out.println("Pushed: " + num);
		
	}
	
	public int pop() {
		if(pointer == -1) {
			System.out.println("No elements, push something first!");
			return -1;
		}
		int num = stack[pointer];
		pointer--;
		System.out.println("Popped: " + num);
		return num;
	}
	
	public int popMin() {
		if(pointer == -1) {
			System.out.println("No elements, push something first!");
			return -1;
		}
		int value = stack[minIndex];
		for(int i=minIndex; i< stack.length-1; i++) {
			stack[i] = stack[i+1];
		}
		return value;
	}
	
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(2);
		stack.push(1);
		stack.push(3);
		stack.push(4);
		stack.push(10);
		System.out.println(Arrays.stream(stack.stack).boxed().collect(Collectors.toList()));
		stack.popMin();
		System.out.println(Arrays.stream(stack.stack).boxed().collect(Collectors.toList()));
	}
}
