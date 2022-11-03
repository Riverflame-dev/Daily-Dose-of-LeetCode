/*
Approach 3: Dynamic Programming
- In the above approach we have used dp array where dp[i]=dp[i-1]+dp[i-2]. 
- It can be easily analysed that dp[i]dp[i] is nothing but i^{th} fibonacci number: Fib(n)=Fib(n-1)+Fib(n-2)

Time complexity : O(n)
- Single loop upto n is required to calculate n^{th} fibonacci number.

Space complexity : O(1)
- Constant space is used.

*/
public class Solution {
    public int climbStairs(int n) { 
        
        if (n == 1) return 1;

        // int[] dp = new int[n + 1];
        //dp[1] = 1;
        //dp[2] = 2;
        
        // We no longer need a dp[] array because we can just use two variables 
        int first = 1;
        int second = 2;
        
        // Construct the answer "from bottom up", instead of "down to bottom"
        // (we start with the base case rather than starting with the end case and 
        //  decomposing the problem down to the base case, i.e. the recursive solutions)
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }
}
