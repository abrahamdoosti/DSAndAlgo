/**
 * 
 * @author abrah Given an integer x, return true if x is palindrome integer.
 * 
 *         An integer is a palindrome when it reads the same backward as
 *         forward.
 * 
 *         For example, 121 is a palindrome while 123 is not.
 * 
 * 
 *         Example 1:
 * 
 *         Input: x = 121 Output: true Explanation: 121 reads as 121 from left
 *         to right and from right to left. 
 *         
 *         Example 2: 
 *         Input: x = -121 Output: false Explanation: From left to right, it
 *         reads -121. From right to left, it becomes 121-. Therefore it is not
 *         a palindrome. 
 *         
 *         Example 3:
 *         Input: x = 10 Output: false Explanation: Reads 01 from right to left.
 *         Therefore it is not a palindrome.
 * 
 * 
 *         Constraints:
 * 
 *         -231 <= x <= 231 - 1
 * 
 * 
 *         Follow up: Could you solve it without converting the integer to a
 *         string?
 *
 */
public class Palindrome {

	public static void main(String[] args) {

		System.out.println(isPalindromeOptimized(12321));
		System.out.println(isPalindromeOptimized(0));
		System.out.println(isPalindromeOptimized(1232));
		System.out.println(isPalindromeOptimized(1221));
		System.out.println(isPalindromeOptimized(12321));

	}

	public static boolean isPalindrome1(int x) {
		int num = x;
		int i = 0;
		while (num > 0) {
			i++;
			num = num / 10;
		}
		num = x;
		int[] digits = new int[i];
		int j = 0;
		while (num > 0) {
			digits[j] = num % 10;
			j++;
			num = num / 10;
		}
		int reverse = 0;
		int power = 1;
		for (int k = digits.length - 1; k >= 0; k--) {
			reverse = reverse + digits[k] * power;
			power = power * 10;
		}
		return (reverse == x);

	}

	public static boolean isPalindromeOptimized(int x) {
		int num = x;

		if (num < 0 || (num % 10 == 0 && num != 0)) {
			return false;
		}
		int reverse = 0;
		while (num > 0) {
			reverse = reverse * 10 + num % 10;
			num /= 10;
		}
		return (reverse == x);

	}

}
