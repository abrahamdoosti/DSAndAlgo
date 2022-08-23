package com.example.sample;

public class FamilyStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(areFamily("corn", "dpso"));
		//List<String> logins = Arrays.asList(new String[] { "corn", "horn", "dpso", "eqtp", "corn" });
		//List<String> logins = Arrays.asList(new String[] { "ab", "bc", "zz", "aa", "bb", "cc", "cc", "cc", "aa" });
		String[] str1=new String[] { "corn", "horn", "dpso", "eqtp", "corn" };
		String[] str2=new String[] { "ab", "bc", "zz", "aa", "bb", "cc", "cc", "cc", "aa" };
		getFamilyPairs(str1);
		getFamilyPairs(str2);
		

	}
	
	public static int getFamilyPairs(String[] str) {
		int counter = 0;

		for (int i = 0; i < str.length - 1; i++) {
			for (int j = i + 1; j < str.length; j++) {
				if (areFamily(str[i], str[j])) {
					System.out.print("{"+str[i]+" , "+str[j]+"}  ");
					counter++;
				}
			}
		}
		return counter;
	}

	private static boolean areFamily(String str1, String str2) {
		for (int i = 0; i < str1.length(); i++) {
			if ((Math.abs((int) (str1.charAt(i)) - (int) (str2.charAt(i))) != 1)
					&& (Math.abs((int) (str1.charAt(i)) - (int) (str2.charAt(i))) != 25)) {
				return false;
			}
		}
		return true;
	}

}
