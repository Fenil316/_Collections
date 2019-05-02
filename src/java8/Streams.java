package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(0,10,20,30,15,25,35);
		System.out.println("List of even numbers: " + list.stream().filter(i -> i % 2 == 0).collect(Collectors.toList()));
		System.out.println("List of doubled numbers: " + list.stream().map(i -> i * 2).collect(Collectors.toList()));
		System.out.println("List of (asc) sorted numbers:" + list.stream().sorted().collect(Collectors.toList()));
		System.out.println("List of (desc) sorted numbers:" + list.stream().sorted((x, y) -> y - x).collect(Collectors.toList()));
		System.out.println("Minimum number:" + list.stream().min((x, y) -> x - y).get());
		System.out.println("Maximum number:" + list.stream().max((x, y) -> x - y).get());
		System.out.println("Length of array of numbers:" + list.stream().toArray().length);
		System.out.println("List: ");list.stream().forEach(x -> System.out.print(x + " "));
	}

}
