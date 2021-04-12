package dynamicprogramming;

import java.util.Arrays;

/**
 * 
 * @author sudarshanshinde
 * <p>See <a href="https://leetcode.com/problems/coin-change/">https://leetcode.com/problems/coin-change/</a>
 * <br><br>
 * <h1>Problem Statement :</h1>
 * 
 * <p>You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * <br>
 * <p>Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * <br>
 * <p>You may assume that you have an infinite number of each kind of coin.
 * 
 * <br><br><br>
 * Example 1:
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * 
 * <br><br>
 * Example 2:
 * Input: coins = [2], amount = 3
 * Output: -1
 */

public class MinCoins {
	public int coinChange(int[] coins, int amount) {
		int n = coins.length;
		int dp[] = new int[amount + 1];

		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int i = 1; i <= n; i++) {
			for (int a = 1; a <= amount; a++) {
				if (a >= coins[i - 1] && dp[a - coins[i - 1]] != Integer.MAX_VALUE) {
					dp[a] = Math.min(dp[a], 1 + dp[a - coins[i - 1]]);
				}
			}
		}

		return (dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount];
	}
}
