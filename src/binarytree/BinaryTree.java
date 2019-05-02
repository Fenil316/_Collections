package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {

	class Node {
		int value;
		String name;
		Node left;
		Node right;

		Node(int value, String name) {
			this.value = value;
			this.name = name;
		}
	}

	Node root;

	public void insert(int value, String name) {
		Node newNode = new Node(value, name);
		if(root == null) {
			root = newNode;
			return;
		}

		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(q.size() != 0) {
			Node dq = q.poll();
			if(dq.left != null) {
				q.add(dq.left);
			} else {
				dq.left = newNode;
				return;
			}
			if(dq.right != null) {
				q.add(dq.right);
			} else {
				dq.right = newNode;
				return;
			}
		}
	}

	private void displayZigZag(Node root) {
		Node current = root;
		if(root == null) {
			System.out.println("Nothing to display");
			return;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.offer(root);
		int level = 0;
		System.out.println("Node: "+ current.value);
		while(!q.isEmpty()) {
			level++;
			int loop = q.size();
			for(int i=0; i<loop; i++) {
				current = q.poll();
				if(level % 2 != 0) {
					if(current.left != null) {
						System.out.println(current.left.value);
					} if(current.right != null) {
						System.out.println(current.right.value);
					}

					if(current.right != null) {
						q.offer(current.right);
					} if(current.left != null) {
						q.offer(current.left);
					}

				} else {
					if(current.right != null) {
						System.out.println(current.right.value);
					}
					if(current.left != null) {
						System.out.println(current.left.value);
					}

					if(current.left != null) {
						q.offer(current.left);
					}
					if(current.right != null) {
						q.offer(current.right);
					}
				}
			}
		}
	}

	public void displayBFS(Node root) {
		if(root == null) {
			System.out.println("Nothing to display");
			return;
		}

		int level=1;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()) {
			int i = 0;
			int qSize = q.size();
			List<Node> list = new ArrayList<Node>();
			while(i < qSize) {
				Node dq = q.poll();
				System.out.print(dq.value + ", " + dq.name + "   ");
				if(dq.left != null) {
					list.add(dq.left);
				}
				if(dq.right != null) {
					list.add(dq.right);
				}
				i++;
			}
			q.addAll(list);
			System.out.println("<- Level:" + level);
			level++;
		}
	}

	public void inOrder(Node root) {
		if(root.left != null) inOrder(root.left);
		System.out.print(root.value + " ");
		if(root.right != null) inOrder(root.right);
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.insert(10, "A");
		bt.insert(12, "B");
		bt.insert(14, "C");
		bt.insert(15, "D");
		bt.insert(16, "E");
		bt.insert(17, "F");
		bt.insert(18, "G");
		bt.insert(19, "H");
		//bt.inOrder(bt.root);
		bt.displayBFS(bt.root);
		System.out.println("**********************************Zig-Zag");
		bt.displayZigZag(bt.root);
	}

}
