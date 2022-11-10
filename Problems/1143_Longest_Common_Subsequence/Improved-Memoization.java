/*
Approach 2: Improved Memoization
- Recursively break the original problem down into subproblems. 
- Find subproblems such that we can create an optimal solution from the results of those subproblems.
- We could compute the answer based on two cases: 
    - the first character of each string is the same -> 1 + LCS(p1 + 1, p2 + 1)
    - the first character of each string is not the same -> max(LCS(p1 + 1, p2), LCS(p1, p2 + 1))

Time complexity : O(M⋅N)
- This time, solving each subproblem has a cost of O(1).
- There are M⋅N subproblems, and so we get a total time complexity of O(M⋅N).

Space complexity : O(M⋅N)
- We need to store the answer for each of the M⋅N subproblems. Each subproblem takes O(1) space to store. 
*/


class Solution {
    
    // These variables will be accessed by both methods
    private int[][] memo;
    private String text1;
    private String text2;

    public int longestCommonSubsequence(String text1, String text2) {

        // Make the memo big enough to hold the cases where the pointers go over the edges of the strings.
        this.memo = new int[text1.length() + 1][text2.length() + 1];

        // Initialise the memo array to -1's so that we know whether or not a value has been filled in. 
        // Keep the base cases as 0's to simplify the later code a bit.
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
            this.memo[i][j] = -1;
            }
        }
        this.text1 = text1;
        this.text2 = text2;

        // Start recursively solving the problem from the beginning of the strings
        return memoSolve(0, 0);
    }

    private int memoSolve(int p1, int p2) {      

        // Check whether or not we've already solved this subproblem.
        // This also covers the base cases where p1 == text1.length or p2 == text2.length.
        if (memo[p1][p2] != -1) return memo[p1][p2];
        
        // Recursive cases.
        int answer = 0;
        // Case 1: the first character of each string is the same -> 1 + LCS(p1 + 1, p2 + 1)
        if (text1.charAt(p1) == text2.charAt(p2)) {
            answer = 1 + memoSolve(p1 + 1, p2 + 1);
        // Case 2: the first character of each string is not the same -> max(LCS(p1 + 1, p2), LCS(p1, p2 + 1))
        } else {
            answer = Math.max(memoSolve(p1, p2 + 1), memoSolve(p1 + 1, p2));
        }

        // Add the best answer to the memo before returning it.
        memo[p1][p2] = answer;
        return memo[p1][p2];
    }
}
