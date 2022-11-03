/*
Approach 2: Recursion with Memoization
- In this brute force approach we take all possible step combinations i.e. 1 and 2, at every step. 
- Instead of redundantly calculating the result for every step, we can store the result at each step in memo array and directly returning the result from the memo array whenever that function is called again.

Time complexity : O(n)
- In this approach we are pruning recursion tree with the help of memo array and reducing the size of recursion tree upto n.

Space complexity : O(n)
-The depth of the recursion tree can go upto n.

*NOTE: Remember that recursion is NOT CONCURRENT

*/
public class Solution {
    public int climbStairs(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs(0, n, memo);
    }
    
    public int climb_Stairs(int i, int n, int memo[]) {
        
        // It's either a miss
        if (i > n) return 0;
        
        // Or a hit
        if (i == n) return 1;
        
        // e.g. the i+1 path will calculate memo[2] at some point
        //      by the time the i+2 needs memo[2], we already have it
        //      the avoids repeated calling for the same i
        if (memo[i] > 0) return memo[i];
        
        memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
        
        // In the end memo[0] will be returned
        return memo[i];
    }
}
