import java.util.Stack;

/**
 * 
 * @author abrah Given a string s containing just the characters '(', ')', '{',
 *         '}', '[' and ']', determine if the input string is valid.
 * 
 *         An input string is valid if:
 * 
 *         Open brackets must be closed by the same type of brackets. Open
 *         brackets must be closed in the correct order.
 * 
 * 
 *         Example 1: * 
 *         Input: s = "()" Output: true 
 *         
 *         Example 2: * 
 *         Input: s = "()[]{}" Output: true 
 *         
 *         Example 3: * 
 *         Input: s = "(]" Output: false
 * 
 * 
 *         Constraints:
 * 
 *         1 <= s.length <= 104 s consists of parentheses only '()[]{}'.
 */
public class ValidParenthesis {

	public static void main(String[] args) {

		System.out.println(checkParnthesisOrder("({[]})"));
		System.out.println(checkParnthesisOrder("((()))"));
		System.out.println(checkParnthesisOrder("()[{}]"));
		System.out.println(checkParnthesisOrder("()[{}]{]"));
		System.out.println(checkParnthesisOrder("(){}}{"));
		System.out.println(checkParnthesisOrder("(])"));

	}

	public static boolean checkParnthesisOrder(String string) {
		Stack<Character> prnthsisStck = new Stack<Character>();

		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(0) != '(' && string.charAt(0) != '{' && string.charAt(0) != '[') {
				return false;
			}

			if (string.charAt(i) == '(' || string.charAt(i) == '{' || string.charAt(i) == '[') {
				prnthsisStck.push(string.charAt(i));
			} else if (string.charAt(i) == ')' && !prnthsisStck.isEmpty() && prnthsisStck.peek() == '(') {
				prnthsisStck.pop();
			} else if (string.charAt(i) == '}' && !prnthsisStck.isEmpty() && prnthsisStck.peek() == '{') {
				prnthsisStck.pop();

			} else if (string.charAt(i) == ']' && !prnthsisStck.isEmpty() && prnthsisStck.peek() == '[') {
				prnthsisStck.pop();
			} else {
				return false;
			}
		}
		return prnthsisStck.isEmpty();
	}

}
