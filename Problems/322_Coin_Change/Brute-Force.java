/*
Approach 1: Brute force
- enumerate all subsets of coin frequencies that satisfy the constraints above, compute their sums and return the minimum among them.
-  the algorithm uses backtracking technique to generate all combinations of coin frequencies
- It makes a sum of the combinations and returns their minimum or -1−1 in case there is no acceptable combination.

Time complexity : O(S^n)
- In the worst case, complexity is exponential in the number of the coins n. 
- The reason is that every coin denomination c_i could have at most S/c_i values. 

Space complexity : O(n)
- In the worst case, the maximum depth of recursion is n. 
- Therefore we need O(n) space used by the system recursive stack.

*/

public class Solution {

  public int coinChange(int[] coins, int amount) {
    return coinChange(0, coins, amount);
  }

  private int coinChange(int idxCoin, int[] coins, int amount) {
    if (amount == 0) return 0;
      
    if (idxCoin < coins.length && amount > 0) {
        
      // maximum number of coins (of the current type) that can be used
      int maxVal = amount/coins[idxCoin];
      // assume minCost to be the lowest possible number
      int minCost = Integer.MAX_VALUE;
        
      // iterate through all possible usage of the current coin type
      for (int x = 0; x <= maxVal; x++) {
          
        // As long as there are remaining amount to be filled
        if (amount >= x * coins[idxCoin]) {
        
          // Call the same method on the next type of coin to make up the remaining amount
          // to get the number of coins (of other type) that can be used 
          // for each possible usage of the current coin type
          int res = coinChange(idxCoin + 1, coins, amount - x * coins[idxCoin]);
          
          // if the remaining can be made up by using the next coin type
          // update the minCost with the number of other coins used + the number of current coins used
          // minCost will remain to be the lowest possible number if no combination worked out
          if (res != -1) minCost = Math.min(minCost, res + x);
        }
      }
      // if no combination worked out, return -1 
      return (minCost == Integer.MAX_VALUE)? -1: minCost;
    }
    return -1;
  }
}

// Time Limit Exceeded
