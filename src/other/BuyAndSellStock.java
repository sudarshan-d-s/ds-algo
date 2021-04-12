package other;

/**
 * 
 * @author sudarshanshinde
 * <p>See <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">https://leetcode.com/problems/best-time-to-buy-and-sell-stock/</a>
 * <br><br>
 * <h1>Problem Statement :</h1>
 * 
 * <p>You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * <p>You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * <p>
 * <p>Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * <p>
 * <br>
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * <br><br>
 * Example 2:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 *
 */

public class BuyAndSellStock {
	
	/**
	 * Explanation :<br>
	 * <p>Suppose we have original array:
	 * <p>[a0, a1, a2, a3, a4, a5, a6]
	 * <p>what we are given here(or we calculate ourselves) is:
	 * <p>[b0, b1, b2, b3, b4, b5, b6]
	 * <p>where,
	 * <p>b[i] = 0, when i == 0
	 * <p>b[i] = a[i] - a[i - 1], when i != 0
	 * <br>
	 * <p>suppose if a2 and a6 are the points that give us the max difference (a2 < a6)
	 * <p>then in our given array, we need to find the sum of sub array from b3 to b6.
	 * <br>
	 * <p>b3 = a3 - a2
	 * <p>b4 = a4 - a3
	 * <p>b5 = a5 - a4
	 * <p>b6 = a6 - a5
	 * 
	 * <p>adding all these, all the middle terms will cancel out except two
	 * <p>i.e.
	 * <br>
	 * <p>b3 + b4 + b5 + b6 = a6 - a2
	 * <br>
	 * <p>a6 - a2 is the required solution.
	 * <br>
	 * <p>so we need to find the largest sub array sum to get the most profit
	 */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int maxCur = 0;
        
        for(int i = 1; i < n; i++){
            maxCur = Math.max(0, maxCur + prices[i] - prices[i - 1]);
            maxProfit = Math.max(maxProfit, maxCur);
        }
        
        return maxProfit;
    }
}
