import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedBracket {
	
	public static void main(String[] args) {
		System.out.println(isBalanced("{{([])}}"));
	}
	
    public static String isBalanced(String s) {
    // Write your code here
    	Map<Character,Character> brackets=new HashMap<>();
    	brackets.put(')', '(');
    	brackets.put('}', '{');
    	brackets.put('}', '[');
		Stack stk = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if (c == '(' || c == '[' || c == '{') {
				stk.push(c);
			} else if (c == ')' || c == ']' || c == '}') {
				if (stk.isEmpty()) {
					return "NO";
				}
				Character pop = (Character) stk.pop();

				if (!pop.equals(brackets.get(c))) {
					return "NO";
				}
			}
		}
		if (!stk.isEmpty()) {
			return "NO";
		} else {
			return "YES";
		}
     
    }
    
    private static Character getOppositeBracket(Character c) {
    	Character rtrnd=null;
    	switch(c) {
    	case(')'):
    		rtrnd= '(';
    		break;
    	case(']'):
    		rtrnd= '[';
    		break;
    	case('}'):
    		rtrnd='{';    		
    	}
    	return rtrnd;
    	
    }

}
