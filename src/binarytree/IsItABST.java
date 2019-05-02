package binarytree;


public class IsItABST {
    
    public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insertNode(1, "A");
		tree.insertNode(2, "B");
		tree.insertNode(2, "C");
		tree.insertNode(4, "D");
		tree.insertNode(5, "E");
		tree.insertNode(6, "F");
		tree.insertNode(7, "G");
		System.out.println(tree.checkBST(tree.getRoot()));
	}

}
