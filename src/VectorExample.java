import java.util.Vector;


public class VectorExample {

	public static void main(String[] args) {
		Vector<Integer> vec = new Vector<Integer>();
		vec.add(1);
		vec.add(2);
		vec.add(3);
		vec.add(4);
		vec.add(5);
		
		deleteOdd(vec);
		System.out.println(vec);
	}

	private static void deleteOdd(Vector<Integer> vec) {
		for(int i=0 ;i < vec.size() ; i++) {
			if((vec.get(i) & 1) == 1) {
				vec.remove(i);
			}
		}
	}
}
