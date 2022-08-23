
public class ConsecutiveZeroOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// If two consecutive characters are 0 and 1, then remove them both
		// from the string and keep applying the same logic to the remaining string
		// and return the length of the smallest remaining string
		String s1 = "111000"; // 0

		String s2 = "01010";// 1
		String s3 = "111*000";// 7

		System.out.println(removeConsecutive(s1));		
		System.out.println(removeConsecutive(s2));
		System.out.println(removeConsecutive(s3));

	}

	public static char[] removeConsecutive(String s) {
		if (s.length() == 0) {
			return new char[0];
		} else if (s.length() == 1) {
			return s.toCharArray();
		}
		char[] charArr = new char[s.length()];
		int j = 0;
		int i = 1;
		while (i < s.length()) {
			if ((s.charAt(i - 1) == '1' && s.charAt(i) == '0') || (s.charAt(i - 1) == '0' && s.charAt(i) == '1')) {
				if (i + 2 == s.length()) {
					charArr[j] = s.charAt(i + 1);
					i++;
				} else {
					i = i + 2;
				}
			} else {
				charArr[j] = s.charAt(i - 1);
				j++;
				if (i == s.length() - 1) {
					charArr[j] = s.charAt(i);
				}
				i++;
			}

		}
		return charArr;

	}

}
