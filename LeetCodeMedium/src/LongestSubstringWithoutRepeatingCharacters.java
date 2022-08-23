import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
/**
 * Given a string s, find the length of the longest substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 * @author abrah
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(lengthOfLongestSubstring("abcabcd"));
		long start=System.nanoTime();
		System.out.println(lengthOfLngstSubstrgOptmzd("abcabcbb"));
		System.out.println("my solution took "+(System.nanoTime()-start));
		long start1=System.nanoTime();
		System.out.println(lengthOfLongestSubstringChina("abcabcbb"));
		System.out.println("China solution took "+(System.nanoTime()-start1));

	}
	
	/**
	 * This method uses brute force method , hence not efficient solution.
	 * @param s
	 * @return
	 */
	 public static int lengthOfLongestSubstring(String s) {
	        List<Character> sub=new ArrayList();
	        int currentmax=0;
	        for(int i=0;i<s.length();i++){
	            int max=0;
	            for(int j=i;j<s.length();j++){
	                if(sub.contains(s.charAt(j))){                    
	                    sub.clear();
	                    max=0;
	                    break;
	                }
	                else{
	                    sub.add(s.charAt(j));
	                    max++;
	                    if(max>currentmax){
	                        currentmax=max;
	                    }
	                }
	            }
	            
	        }
	        return currentmax;
	    }
	 
	 /**
	  * The following implementation is optimized with O(n) time complexity
	  */
	public static int lengthOfLngstSubstrgOptmzd(String s) {
		int start = 0;
		int end = 0;
		int result=0;
		Map<Character,Integer> charIndexMap=new HashMap<>(); 
		while(end<s.length()) {
			if(!charIndexMap.containsKey(s.charAt(end))) {
				charIndexMap.put(s.charAt(end), end);
				end++;
				//update result
				result=(end-start)>result?(end-start):result;
			}
			else {
				//update result
				result=(end-start)>result?(end-start):result;
				
				//update start as start = first occurrence of duplicate + 1
				start=charIndexMap.get(s.charAt(end))+1;
				
				//remove all the characters before our new start index and previous start index from hashmap
				
				Iterator<Map.Entry<Character,Integer>> iter=charIndexMap.entrySet().iterator();
				
				while(iter.hasNext()) {
					Map.Entry<Character,Integer> entry=iter.next();
					
					if(entry.getValue()<start) {
						iter.remove();
						
					}
				}
				
				//put the current character with its associated index(end) in to the map
				charIndexMap.put(s.charAt(end),end);
				
				//Finally we increment end again
				end+=1;
			}
		}
		
		return result;
	}
	
	
/**
 * Chinese guy solution from leetcode ,4ms time for all tests in leetcode	
 * @param s
 * @return
 */
	public static int lengthOfLongestSubstringChina(String s) {
		char[] chars = new char[s.length()+1];
		int length = 0;
		int length2 = 0;
		int from = 0;
		for (int i = 0; i < s.length(); i++) {
			while (search(chars, s.charAt(i), from, length)) {
				if (length - from > length2) {

					length2 = length - from;
				}
				from++;
			}
			chars[length++] = s.charAt(i);

		}
		return Math.max(length - from, length2);
	}

	public static boolean search(char[] ar, char c, int from, int length) {
		// boolean flag=false;
		for (int i = from; i < length; i++) {
			if (ar[i] == c) {
				return true;
			}
		}
		return false;
	}
}
