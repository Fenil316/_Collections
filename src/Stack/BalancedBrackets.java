package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BalancedBrackets {

	static class Stack {
		List<String> list = new ArrayList<>();
		int pointer = -1;

		public void push(String str) {
			pointer++;
			list.add(pointer, str);
		}

		public String pop() {
			String removed = "A";
			if(pointer > -1) {
				removed = list.remove(pointer);
				pointer--;
			}

			return removed;

		}

		public boolean isEmpty() {
			if(pointer >= 0) {
				return false;
			}
			return true;
		}
	}

	public static boolean isBalanced(String expression) {
		boolean result = true;
		Stack stack = new Stack();
		for(int i=0; i< expression.length(); i++) {
			if(expression.charAt(i) == '{' || expression.charAt(i) == '('
					|| expression.charAt(i) == '[') {
				stack.push(String.valueOf(expression.charAt(i)));
			} else {
				String returned = stack.pop();
				if(returned != null) {
					if(returned.equals("{") && expression.charAt(i) == '}' ||
							returned.equals("[") && expression.charAt(i) == ']' ||
							returned.equals("(") && expression.charAt(i) == ')' ) {
					} else {
						return false;
					}
				}
			}
		}

		if(!stack.isEmpty())
			return false;

		return result;
	}

	/* public static boolean isBalanced(String expression) {

    	// Must be even
    	if ((expression.length() & 1) == 1) return false;
    	else {
    	  char[] brackets = expression.toCharArray();
    	  java.util.Stack<Character> s = new java.util.Stack<>();
    	  for (char bracket : brackets)
    	    switch (bracket) {
    	      case '{': s.push('}'); break;
    	      case '(': s.push(')'); break;
    	      case '[': s.push(']'); break;
    	      default :
    	        if (s.empty() || bracket != s.peek())
    	          return false;
    	        s.pop();
    	    }
    	  return s.empty();
    	}

    	}*/

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			String expression = in.next();
			System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
		}
	}    
}
