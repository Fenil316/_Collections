package binarytree;

public class Node {
	int value;
	String name;
	Node leftChild;
	Node rightChild;
	
	public Node(int value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "[value: " + value + " leftChild: " + leftChild + " rightChild: " + rightChild + "]"; 
	}
}
