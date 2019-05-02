package java8;
@FunctionalInterface
public interface Greeting {

	public void greet();
	
	default String returnString(){
		return "";
	}
	
}
