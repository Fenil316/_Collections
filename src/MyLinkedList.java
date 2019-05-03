import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class MyLinkedList {
	
	class Link {
		String name;
		Link next;
		
		Link(String name) {
			this.name = name;
		}
		
	}
	
	public static void main(String[] args) {
		List<String> list1 = new LinkedList<>();
		list1.add("Fenil");
		list1.add("Stavan");
		list1.add("mummy");
		list1.add(1, "Hajmola");
		list1.add(1, "Hajmola2");
		list1.add(3, "udupi");
		list1.remove(0);
		System.out.println(list1);
		
		System.out.println("3rd: " + list1.get(2));
		List<String> list2 = new ArrayList<String>();
		list2.add("Fenil");
		list2.add("Stavan");
		list2.add("mummy");
		list2.add(1, "Hajmola");
		list2.add(3, "udupi");
		
		for(String s: list1) {
			System.out.println(s);
		}
	}
}
