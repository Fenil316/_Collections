package java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

public class Main {
	
	public static void main(String[] args) {
		
		String s1 = "HelloWorld!!!!!";
		
		Greeting g1 = new MyGreeting();
		Greeting g2 = () -> {
			System.out.println("Hi");
		};

		printGreetingMessage(g1);
		printGreetingMessage(g2);

		List<Person> personList = createPersons();
		
		System.out.println("-----------------Sorting by Last name:");
		Collections.sort(personList, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}
		});
		personList.forEach(x -> System.out.println(x));
		
		System.out.println("-----------------Sorting by First name:");
		Collections.sort(personList, (x, y) -> x.getFirstName().compareToIgnoreCase(y.getFirstName()));
		personList.forEach(x -> System.out.println(x));
		
		System.out.println("-----------------Sorting by Age(descending):");
		Collections.sort(personList, (x,y) -> y.getAge() - x.getAge());
		personList.forEach(x -> System.out.println(x));
		
		Supplier<String> supplier = () -> {
			return s1;
		};
		
		System.out.println(supplier.get());
	}

	private static List<Person> createPersons() {
		return Arrays.asList(new Person("Fenil", "Shah", 30),
				new Person("Tom", "Cruize", 55),
				new Person("Ryan", "Reynolds", 40));
	}

	public static void printGreetingMessage(Greeting g) {
		g.greet();
	}
}
