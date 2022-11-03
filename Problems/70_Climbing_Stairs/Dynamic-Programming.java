/*
Approach 3: Dynamic Programming
- This problem contains the optimal substructure property i.e. its optimal solution can be constructed efficiently from optimal solutions of its subproblems, we can use dynamic programming to solve this problem.
- Let dp[i]denotes the number of ways to reach on i^{th} step: dp[i] = dp[i-1] + dp[i-2]

Time complexity : O(n)
- Single loop upto n.

Space complexity : O(n)
- dp array of size n is used.

*NOTE: Remember that recursion is a TREE!!!

*/
public class Solution {
    public int climbStairs(int n) { 
        
        if (n == 1) return 1;
        
        // size is n+1 since we will need to reference dp[n]
        int[] dp = new int[n + 1];
        
        // Base cases
        dp[1] = 1;
        dp[2] = 2;
        
        // Construct the answer "from bottom up", instead of "down to bottom"
        // (we start with the base case rather than starting with the end case and 
        //  decomposing the problem down to the base case, i.e. the recursive solutions)
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
