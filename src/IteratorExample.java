import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class IteratorExample {

	List<Integer> intList;
	Map<Integer, String> table = new Hashtable<Integer, String>();

	public IteratorExample() {
		intList = new LinkedList<Integer>();
		//intList = new ArrayList<Integer>();
		intList.add(new Integer(1));
		intList.add(new Integer(2));
		intList.add(new Integer(3));
		intList.add(new Integer(4));
		intList.add(new Integer(5));
		
		table.put(new Integer(1), "One");
		table.put(new Integer(2), "Two");
		table.put(new Integer(3), "Three");
		table.put(new Integer(4), "Four");
		table.put(new Integer(5), "Five");
	}
	
	public static void main(String[] args) {
		IteratorExample ex = new IteratorExample();
		List<Integer> list = new ArrayList<Integer>();
		Iterator<Integer> iterator = ex.intList.iterator();
		
		System.out.println("Iterating thru all the elements:");
		while(iterator.hasNext()){
			Integer value = iterator.next();
			list.add(value);
			System.out.println(value);
		}
		
		Iterator<Integer> it = list.iterator();
		/* If in this loop, one tries to remove element using list.remove(value), the structure of the list
		 * changes and so the iterator throws ConcorrentModificationException since the modeCount for iterator changed.
		 * You can remove the element using it.remove() though.
		 */
		while(it.hasNext()){
			Integer value = it.next();
			if(value == 2)
				it.remove();
		}
		
		System.out.println("Iterating thru new list");
		
		// For using traditional for loop and updating the list does not throw exception though!
		for (int i=0;i<list.size();i++){
			System.out.println(list.get(i));
			if(i==3)
				list.remove(i);
			
		}
		
		// Using special for loop to remove an element from the list in the loop will cause ConcurrentModificationException
/*		for(Integer in: list){
			System.out.println(in);
			if(in == 3)
				list.remove(in);
		}*/
	}
}
