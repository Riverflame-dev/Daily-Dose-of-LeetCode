/*
Approach 3: Dynamic programming - Bottom up
- For the iterative solution, we think in bottom-up manner. 
- Before calculating F(i), we have to compute all minimum counts for amounts up to i. 
- On each iteration i of the algorithm F(i) is computed as F(i-c_j)+1

Time complexity : O(S∗n)
- where S is the amount, n is denomination count. 
- On each step, the algorithm finds the next F(i) in n iterations, where 1 ≤ i≤ S. 

Space complexity : O(n)
- We use extra space for the dp array.

*/

public class Solution {
    public int coinChange(int[] coins, int amount) {
        
        // dp[] will store minimum counts for each amount up to amount
        // initilaize dp[] with the target amount
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        
        // Base case
        dp[0] = 0;
        
        // Iterate through all the amount up to the target amount
        for (int i = 1; i <= amount; i++) {
            
            // Consider all types of coins
            for (int j = 0; j < coins.length; j++) {
                
                // if the coin value does not exceed the amount
                // we check if the current combination is the minmum count
                // if it is, we update dp[i] with the last dp value + 1 (for the current coin)
                // i.e. dp[i - coins[j]] is the dp value brefore adding the current coin
                if (coins[j] <= i) dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        // if the dp value for the target amount is still the initial value
        // then no min count were found
        // otherwise, the dp value would be the minimum count
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
