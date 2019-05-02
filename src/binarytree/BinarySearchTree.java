package binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Queue.QueueUsingMyLinkedList;

public class BinarySearchTree {

	private Node root;



	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public void insertNode(int value, String name) {
		System.out.println("Adding: " + value );
		Node newNode = new Node(value);
		newNode.name = name;
		Node parent = root;
		Node focus = root;
		boolean isLeft = false;

		if(root == null) {
			root = newNode;
		} else {
			while(focus != null) {
				parent = focus;
				if(value > focus.value) {
					isLeft = false;
					focus = parent.rightChild;
				} else {
					isLeft = true;
					focus = parent.leftChild;
				}
			}

			focus = newNode;
			if(isLeft) {
				parent.leftChild = focus;
			} else {
				parent.rightChild = focus;
			}

		}

	}

	public void breadthFirstTraversal(Node root) {
		List<List<Integer>> nodesAtEachLevel = new ArrayList<>();
		QueueUsingMyLinkedList<Node> q = new QueueUsingMyLinkedList<>();
		if(root != null) {
			Node current = root;
			q.enqueue(current);
			while(!q.isEmpty()) {
				List<Integer> nodesAtLevel = new ArrayList<Integer>();
				int tempSize = q.size();
				for(int i=0; i < tempSize; i++) {
					current = q.dequeue();
					System.out.println(current.value);
					nodesAtLevel.add(current.value);
					if(current.leftChild != null) {
						q.enqueue(current.leftChild);
					}
					if(current.rightChild != null) {
						q.enqueue(current.rightChild);
					}
				}
				nodesAtEachLevel.add(nodesAtLevel);
			}
			System.out.println("Children of the tree, level wise: " + nodesAtEachLevel);

		}

	}

	public void inOrderTraversal(Node root) {
		if(root.leftChild != null) inOrderTraversal(root.leftChild);
		System.out.println(root.value + " ");
		if(root.rightChild != null) inOrderTraversal(root.rightChild);
	}

	public void preOrderTraversal(Node root) {
		System.out.println(root.value);
		if(root.leftChild != null) {
			preOrderTraversal(root.leftChild);
		}
		if(root.rightChild != null) {
			preOrderTraversal(root.rightChild);
		}
	}

	public void postOrderTraversal(Node root) {
		if(root.leftChild != null) {
			postOrderTraversal(root.leftChild);
		}
		if(root.rightChild != null) {
			postOrderTraversal(root.rightChild);
		}
		System.out.println(root.value);
	}

	private static List<Integer> extractValuesHelper(Node n) {
		List<Integer> result = new ArrayList<>();

		extractValues(n, result);
		return result;
	}

	// Fill up list in post-order traversal:
	private static void extractValues(Node n, List<Integer> result) {
		if (n.leftChild != null) {
			extractValues(n.leftChild, result);
		}

		if (n.rightChild != null) {
			extractValues(n.rightChild, result);
		}

		result.add(n.value);
	}

	// Fill up list in in-order traversal:
	void inOrderTraversal(Node root, List<Integer> valueList) {
		if(root.leftChild != null) inOrderTraversal(root.leftChild, valueList);
		valueList.add(root.value);
		if(root.rightChild != null) inOrderTraversal(root.rightChild, valueList);
	}

	boolean checkBST(Node root) {
		List<Integer> valueList = new ArrayList<>();
		inOrderTraversal(root, valueList);
		for(int i=0; i< valueList.size() - 1; i++) {
			if(valueList.get(i) == valueList.get(i+1) || valueList.get(i) > valueList.get(i+1))
				return false;
		}
		return true;
	}
	
	public void searchKClosestNodes(Node root, List<Integer> list, int k, int target) {
		if(root.leftChild != null) searchKClosestNodes(root.leftChild, list, k, target);
		if(list.size() < k) list.add(root.value);
		else {
			if(target - list.get(0) > root.value - target) {
				list.remove(0);
				list.add(root.value);
			}
		}
		if(root.rightChild != null) searchKClosestNodes(root.rightChild, list, k, target);
	}
	
	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insertNode(10, "A");
		tree.insertNode(6, "B");
		tree.insertNode(12, "C");
		tree.insertNode(6, "D");
		tree.insertNode(5, "E");
		tree.insertNode(8, "F");
		tree.insertNode(11, "G");
		System.out.println(tree);
		System.out.println("**************BreadthFirst Traversal**********************");
		tree.breadthFirstTraversal(tree.root);
		System.out.println("**************In-Order**********************");
		tree.inOrderTraversal(tree.root);
		System.out.println("**************Pre-Order**********************");
		tree.preOrderTraversal(tree.root);
		System.out.println("**************Post-Order**********************");
		tree.postOrderTraversal(tree.root);
		Integer[] values = extractValuesHelper(tree.root).toArray(new Integer[] {});
		System.out.println(Arrays.asList(values));
		List<Integer> kClosestNodes = new ArrayList<Integer>();
		tree.searchKClosestNodes(tree.root, kClosestNodes, 3, 100);
		System.out.println("*********************K closest nodes********************");
		System.out.println(kClosestNodes);
	}



	public String toString() {
		return "[Tree: " + root + "]";
	}
}
