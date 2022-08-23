package com.example.sample;

import java.util.Arrays;
import java.util.List;

public class MaxConsecSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> ints = Arrays.asList(new Integer[] { 4, 3, -2, 9, -4, 2, 7 });
		System.out.println(getMaxProfit(ints, 3));
		System.out.println(getMaxProfitOptimized(ints, 3));
		System.out.println(getMaxProfitOptimized(ints, 6));
	}

	public static long getMaxProfitOptimized(List<Integer> pnl, int k) {

		Integer starting = pnl.get(0);
		Integer maxConsecProfit = pnl.get(0);
		Integer currentConsecProfit = pnl.get(0);
		Integer limitTracker = 2;
		for (int i = 1; i < pnl.size(); i++) {
			currentConsecProfit += pnl.get(i);

			if (limitTracker == k) {
				maxConsecProfit = Math.max(currentConsecProfit, maxConsecProfit);
				// remove current starting from profit sum
				currentConsecProfit = currentConsecProfit - starting;
				// move current starting one step ahead
				starting = pnl.get(i - k + 2);
			} else {
				limitTracker++;
			}

		}
		return maxConsecProfit;

	}

	public static long getMaxProfit(List<Integer> pnl, int k) {
		// Write your code here
		Integer maxProfit = pnl.get(0);
		for (int i = 0; i <= pnl.size() - k; i++) {
			Integer profit = 0;
			for (int j = i; j < i + k; j++) {
				profit = profit + pnl.get(j);
			}
			maxProfit = Math.max(profit, maxProfit);

		}
		return maxProfit;

	}

}
