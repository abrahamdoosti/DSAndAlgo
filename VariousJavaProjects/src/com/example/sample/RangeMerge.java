package com.example.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * Interview with Clover
 */
public class RangeMerge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[][] arr1=new Integer[][] {{1,3},{2,6},{8,10},{11,13}};
		Integer[][] arr2=new Integer[][] {{1,3},{2,6}};
		List<List<Integer>> l1=new ArrayList<List<Integer>>();
		for(Integer[] a: arr2) {
			l1.add(Arrays.asList(a));
		}
		
		List<List<Integer>> ans=mergeOverlapping(l1);

	}
	
	private static List<List<Integer>> mergeOverlapping(List<List<Integer>> lists){
		List<List<Integer>> answer=new ArrayList<List<Integer>>();
		
		for(int i=0;i<lists.size()-1;i++) {
			if(lists.get(i).get(1)>=lists.get(i+1).get(0)) {
				List<Integer> pair=new ArrayList<Integer>();
				pair.add(lists.get(i).get(0));
				pair.add(lists.get(i+1).get(1));
				answer.add(pair);
				i++;
			}
			else {
				List<Integer> pair=new ArrayList<Integer>();
				pair.add(lists.get(i).get(0));
				pair.add(lists.get(i).get(1));
				answer.add(pair);
				if(i==lists.size()-2) {
					List<Integer> p=new ArrayList<Integer>();
					p.add(lists.get(i+1).get(0));
					p.add(lists.get(i+1).get(1));
					answer.add(pair);
				}
			}

		}
		return answer;
		
	}

}
