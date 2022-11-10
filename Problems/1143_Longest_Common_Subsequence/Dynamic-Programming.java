/*
Approach 3: Dynamic Programming Bottom Up
- In many programming languages, iteration is faster than recursion. 
- Therefore, we often want to convert a top-down memoization approach into a bottom-up dynamic programming one
- Find subproblems such that we can create an optimal solution from the results of those subproblems.
- We could compute the answer based on two cases: 
    - the first character of each string is the same -> 1 + LCS(p1 + 1, p2 + 1)
    - the first character of each string is not the same -> max(LCS(p1 + 1, p2), LCS(p1, p2 + 1))

Time complexity : O(M⋅N)
- We're solving M⋅N subproblems. Solving each subproblem is an O(1) operation.

Space complexity : O(M⋅N)
- We'e allocating a 2D array of size M⋅N to save the answers to subproblems. 
*/

class Solution {

    public int longestCommonSubsequence(String text1, String text2) {    

        // Make a grid of 0's with text2.length() + 1 columns and text1.length() + 1 rows.
        int[][] dpGrid = new int[text1.length() + 1][text2.length() + 1];
        
        // Take text2 as the column
        // Iterate up each column, starting from the last position.
        for (int col = text2.length() - 1; col >= 0; col--) {

            // Take text1 as the row
            // Iterate up each row, starting from the last position.
            for (int row = text1.length() - 1; row >= 0; row--) {

            // Case 1: the first character of each string is the same -> 1 + LCS(p1 + 1, p2 + 1)
            if (text1.charAt(row) == text2.charAt(col)) {
                dpGrid[row][col] = 1 + dpGrid[row + 1][col + 1];

            // Case 2: the first character of each string is not the same -> max(LCS(p1 + 1, p2), LCS(p1, p2 + 1))
            } else {
                dpGrid[row][col] = Math.max(dpGrid[row + 1][col], dpGrid[row][col + 1]);
            }
            }
        }
            
        // The original problem's answer is in dp_grid[0][0]. Return it.
        return dpGrid[0][0];
    }
}
