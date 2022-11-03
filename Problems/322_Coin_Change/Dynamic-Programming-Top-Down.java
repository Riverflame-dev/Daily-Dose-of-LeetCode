/*
Approach 2: Dynamic programming - Top down / Recursion
-  this problem has an optimal substructure property
- build the solution of the problem from top to bottom

Time complexity : O(S∗n)
- where S is the amount, n is denomination count. 
- In the worst case, the recursive tree of the algorithm has height of S and the algorithm solves only S subproblems because it caches precalculated solutions in a table. 
- Each subproblem is computed with n iterations, one by coin denomination. 

Space complexity : O(n)
- We use extra space for the memoization table.

*NOTE:
In the recursion tree, a lot of subproblems were calculated multiple times. For example, F(1) was calculated 13 times. Therefore we should cache the solutions to the subproblems in a table and access them in constant time when necessary.

*/

public class Solution {

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        // Yes you can create a new variable and pass it into a method at the same time!
        return coinChange(coins, amount, new int[amount]); 
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        
        // Base cases 
        if (rem < 0) return -1; // no path worked out
        if (rem == 0) return 0; // done with the current path
        
        // Reuse the calculations already done
        if (count[rem - 1] != 0) return count[rem - 1];
        
        // Assume the min number of coins to be the biggest number possible
        int min = Integer.MAX_VALUE;
        
        // Iterate through all the options (types of coins) to take for the next step
        for (int coin : coins) {
            
            // Going down the path with the next type of coin
            int res = coinChange(coins, rem - coin, count);
            
            // update the min number of coins if we have discovered a new min path
            // +1 is for counting in the current coin
            if (res >= 0 && res < min) min = res + 1;
        }
        
        // Cache the current path
        // if min remains the same with the initialized value, the path didn't work out
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        
        // Reture the result for the top case, where rem = amount
        return count[rem - 1];
    }
}
