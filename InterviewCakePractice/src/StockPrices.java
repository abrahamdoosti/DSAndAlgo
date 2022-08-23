import java.util.logging.Level;
import java.util.logging.Logger;

public class StockPrices {
	private static final Logger LOGGER = Logger.getLogger("stock.prices");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] stockPrices = new int[] { 10, 7, 5, 8, 11, 9 };
		int[] stockPrices = new int[] { 35, 11, 30, 7, 4, 12 };
		System.out.println(getMaxProfit(new int[] { 10, 7, 5, 8, 11, 9 }));
		System.out.println(getMaxProfit(new int[] { 35, 11, 30, 7, 4, 12 }));
		try {
			System.out.println(getMaxProfit(new int[] {}));
		} catch (IllegalArgumentException e) {
			// e.printStackTrace();
			LOGGER.log(Level.SEVERE, "Exception thrown", e);
		}
		try {
			System.out.println(getMaxProfit(new int[] { 14 }));
		} catch (IllegalArgumentException e) {
			// e.printStackTrace();
			LOGGER.log(Level.SEVERE, "Exception thrown", e);
		}

	}

	private static int getMaxProfit(int[] stockPrices) {
		if (stockPrices.length < 2) {
			throw new IllegalArgumentException("Atleast two stock prices needed to buy and sell");
		}
		int minPrice = stockPrices[0];
		int maxProfit = stockPrices[1] - stockPrices[0];

		for (int i = 1; i < stockPrices.length; i++) {
			int currentPrice = stockPrices[i];

			int currentProfit = stockPrices[i] - minPrice;

			maxProfit = Math.max(currentProfit, maxProfit);

			minPrice = Math.min(currentPrice, minPrice);

		}
		return maxProfit;
	}

	private static int getMaxProfitN2(int[] stockPrices) {
		int profit = 0;
		if (stockPrices == null) {
			return 0;
		}
		if (stockPrices.length == 1) {
			return stockPrices[0];
		}
		for (int i = 0; i < stockPrices.length - 1; i++) {
			for (int j = i + 1; j < stockPrices.length; j++) {
				if (stockPrices[j] - stockPrices[i] > profit) {
					profit = stockPrices[j] - stockPrices[i];
				}
			}

		}
		return profit;
	}

}
