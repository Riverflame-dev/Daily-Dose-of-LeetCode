/*
Approach 1: Brute Force Recursion
- In this brute force approach we take all possible step combinations i.e. 1 and 2, at every step. 
- At every step we are calling the function climbStairs for step 1 and 2, and return the sum of returned values of both functions.

Time complexity : O(2^n)
- Size of recursion tree will be 2^n

Space complexity : O(n)
-The depth of the recursion tree can go upto n.

*NOTE: Remember that recursion is a TREE!!!

*/

public class Solution {
    public int climbStairs(int n) {
        return climb_Stairs(0, n);
    }
    public int climb_Stairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        
        // We devide the problem into two possible steps recurively 
        // untill they hit the base case to return answers backwards along the path they took
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }
}
