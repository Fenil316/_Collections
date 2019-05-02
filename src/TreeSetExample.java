import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;


public class TreeSetExample {
	
	static class Node {
		Character ch;
		Integer value;
		
		public Node(Character ch, Integer value) {
			this.ch = ch;
			this.value = value;
		}
		
		@Override
		public boolean equals(Object obj) {
			Node other = (Node) obj;
			if(this.value == other.value)
				return true;
			return false;
		}
		
		@Override
		public String toString() {
			return ch + " = " + value;
		}
	}
	
	public static void main(String[] args) {
		/*TreeSet<String> set = new TreeSet<>();
		set.add("V");
		set.add("An");
		set.add("C");
		set.add("Am");
		set.add("T");
		System.out.println("AscSet: " + set);
		
		TreeSet<String> descSet = new TreeSet<>((x,y) -> y.compareTo(x));
		set.forEach(x -> descSet.add(x));
		System.out.println("DescSet: " + descSet);
		System.out.println("Head Set:" + descSet.headSet("C"));
		System.out.println("Tail Set: " + descSet.tailSet("T"));
		System.out.println("Poll first: " + descSet.pollFirst());
		System.out.println("Remove T: " + descSet.remove("T"));
		System.out.println("DescSet: " + descSet);*/
		Node n1 = new Node('a', 3);
		Node n2 = new Node('b', 3);
		Node n3 = new Node('c', 2);
		Node n4 = new Node('d', 1);
		Node n5 = new Node('e', 1);
		TreeSet<Node> set = new TreeSet<TreeSetExample.Node>((x,y) -> y.value - x.value);
		set.add(n1);
		set.add(n2);
		set.add(n3);
		set.add(n4);
		set.add(n5);
		List<Node> list = new ArrayList<>(set);
		System.out.println(list);
	}
}
