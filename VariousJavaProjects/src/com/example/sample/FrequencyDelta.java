package com.example.sample;

import java.util.ArrayList;
import java.util.List;

public class FrequencyDelta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start=System.currentTimeMillis();
		System.out.println("MAX Frequency Delta = "+getMaxFreqDelta("aaaaadaacccccbbbbdddddddddddddyyyyyyyyyyyyyyyyaaaaadaacccccbbbbdddddddddddddyyyyyyyyyyyyyyyy"));
		long end=System.currentTimeMillis();
		System.out.println("Time taken ="+(end-start)+"ms");
		
		start=System.currentTimeMillis();
		System.out.println("MAX Frequency Delta = "+getMaxFreqDeltaOptimized("aaaaadaacccccbbbbdddddddddddddyyyyyyyyyyyyyyyyaaaaadaacccccbbbbdddddddddddddyyyyyyyyyyyyyyyy"));
		end=System.currentTimeMillis();
		System.out.println("Time taken ="+(end-start)+"ms");

	}
	
	private static int getMaxFreqDelta(String str) {
		//List<String> subs = getSubStrings("aaaccbddddd");
		List<String> subs = getSubStrings(str);
		int maxFreqDelta = 0;
		for (String s : subs) {
			maxFreqDelta = Math.max(maxFreqDelta, getLowHigh(s));
		}
		return maxFreqDelta;
	}
	private static int getMaxFreqDeltaOptimized(String str) {
		//List<String> subs = getSubStrings("aaaccbddddd");
		List<String> subs = getSubStrings(str);
		int maxFreqDelta = 0;
		for (String s : subs) {
			maxFreqDelta = Math.max(maxFreqDelta, getLowHighOptimized(s));
		}
		return maxFreqDelta;
	}
	
	/*
	 * "abcd"-> [a, ab, abc, abcd, b, bc, bcd, c, cd, d]
	 */
	private static List<String> getSubStrings(String str) {
		List<String> strs = new ArrayList<String>();
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j <= str.length(); j++) {
				strs.add(str.substring(i, j));
			}
		}
		return strs;
	}
	
	private static int getLowHigh(String str) {
		// returns highest consecutive freq-lowest consecutive freq
		// aaacca->3-1=2
		// aabb->2-2=0
		int min = str.length();
		int max = 0;
		int counter = 0;
		System.out.println(str );

		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				counter++;
				if (i == str.length() - 2) {
					counter++;
					max = Math.max(counter, max);
					min = Math.min(counter, min);
				}
			} else {
				counter++;
				max = Math.max(counter, max);
				min = Math.min(counter, min);
				counter = 0;
				if (i == str.length() - 2) {
					max = Math.max(1, max);
					min = Math.min(1, min);
				}
			}

		}

		return max - min;

	}
	
	private static int getLowHighOptimized(String str) {
		// returns highest consecutive freq - lowest consecutive freq
		// aaacca->3(a)-1(a)=2
		// aabb->2(a)-2(b)=0
		int min = str.length();
		int max = 0;
		char c = str.charAt(0);
		int counter = 1;

		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == c) {
				counter++;
			} else {
				max = Math.max(counter, max);
				min = Math.min(counter, min);
				counter = 1;
				c = str.charAt(i);
			}
			if (i == str.length() - 1) {
				max = Math.max(counter, max);
				min = Math.min(counter, min);
			}

		}

		return max - min;

	}

}
