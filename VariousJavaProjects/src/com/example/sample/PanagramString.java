package com.example.sample;

import java.util.HashMap;
import java.util.Map;

public class PanagramString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String str="pack my box with five dozen liquor jugs";
		 System.out.println(checkPanagram(str));

	}
	
	private static boolean checkPanagram(String str) {
		Map<Character, Integer> charMap = new HashMap<>();
//		charMap.put('a', 0);
//		charMap.put('b', 0);
//		charMap.put('c', 0);
//		charMap.put('d', 0);
//		charMap.put('e', 0);
//		charMap.put('f', 0);
//		charMap.put('g', 0);
//		charMap.put('h', 0);
//		charMap.put('i', 0);
//		charMap.put('j', 0);
//		charMap.put('k', 0);
//		charMap.put('l', 0);
//		charMap.put('m', 0);
//		charMap.put('n', 0);
//		charMap.put('o', 0);
//		charMap.put('p', 0);
//		charMap.put('q', 0);
//		charMap.put('r', 0);
//		charMap.put('s', 0);
//		charMap.put('t', 0);
//		charMap.put('u', 0);
//		charMap.put('v', 0);
//		charMap.put('w', 0);
//		charMap.put('x', 0);
//		charMap.put('y', 0);
//		charMap.put('z', 0);
		
		for(char i='a';i<='z';i++) {
			charMap.put(i, 0);
		}

		for (int i = 0; i < str.length(); i++) {
			if (charMap.containsKey(str.charAt(i))) {
				charMap.put(str.charAt(i), 1);
			}
		}
		if (charMap.containsValue(0)) {
			return false;
		} else {
			return true;
		}
	}

}
