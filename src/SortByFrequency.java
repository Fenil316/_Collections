import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;


public class SortByFrequency {
	
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
		char[] arr = {'z','c','d','a','b','e','e','e','f','f','f','c','d','a','a','b','b'};
		Map<Character, Integer> m = new LinkedHashMap<Character, Integer>();
		for(int i=0;i<arr.length;i++) {
			if(!m.containsKey(arr[i])) {
				m.put(arr[i], 1);
			} else {
				int v = m.get(arr[i]);
				v++;
				m.put(arr[i], v);
			}
		}
		List<Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character,Integer>>(m.entrySet());
		
		Collections.sort(list, (x,y) -> y.getValue() - x.getValue());
		System.out.println(list);
		
		int index = 1;
		int count = list.get(0).getValue();
		System.out.println(list.get(0).getKey());
		while(index < list.size()) {
			if(count == list.get(index).getValue()) {
				index++;
			} else {
				System.out.println(list.get(index).getKey());
				count = list.get(index).getValue();
			}
		}
		
		// OR
		List<Entry<Character, Integer>> list2 = new ArrayList<Map.Entry<Character,Integer>>(m.entrySet());
		TreeSet<Node> set = new TreeSet<Node>((x,y) -> y.value - x.value);
		for(Entry<Character, Integer> e: list2) {
			Node node = new Node(e.getKey(), e.getValue());
			set.add(node);
		}
		
		for(Node n: set) {
			System.out.println(n.ch);
		}
		
	}
}
