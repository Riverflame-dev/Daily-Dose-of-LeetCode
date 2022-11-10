/*
Approach 4: Dynamic Programming with Space Optimization
- we only ever looked at the current column and the previous column. After that, previously computed columns are no longer needed 
- We can save a lot of space by instead of keeping track of an entire 2D array, only keeping track of the last two columns.
- We could compute the answer based on two cases: 
    - the first character of each string is the same -> 1 + LCS(p1 + 1, p2 + 1)
    - the first character of each string is not the same -> max(LCS(p1 + 1, p2), LCS(p1, p2 + 1))

Time complexity : O(M⋅N)
- We're solving M⋅N subproblems. Solving each subproblem is an O(1) operation.

Space complexity : O(min(M,N)).
- We've reduced the auxilary space required so that we only use two 1D arrays at a time with length of the shortest input word. - Seeing as the 2 is a constant, we drop it, leaving us with the minimum length out of the two words.
*/

class Solution {
    
    public int longestCommonSubsequence(String text1, String text2) {  

        // Since we store the two columns at runtime, we want to make them as short as possible
        // If text1 doesn't reference the shortest string, swap them.
        if (text2.length() < text1.length()) {
            String temp = text1;
            text1 = text2;
            text2 = temp;
        }
            
        // The previous column starts with all 0's and like before is 1 more than the length of the first word.
        int[] previous = new int[text1.length() + 1];
            
        // Iterate through each column, starting from the last one.
        for (int col = text2.length() - 1; col >= 0; col--) {

            // Create a new array to represent the current column.
            int[] current = new int[text1.length() + 1];  

            // Take text1 as the row
            // Iterate up each row, starting from the last position.
            for (int row = text1.length() - 1; row >= 0; row--) {

                // Case 1: the first character of each string is the same -> 1 + LCS(p1 + 1, p2 + 1)
                if (text1.charAt(row) == text2.charAt(col)) {
                    current[row] = 1 + previous[row + 1];

                // Case 2: the first character of each string is not the same -> max(LCS(p1 + 1, p2), LCS(p1, p2 + 1))
                // previous[row] = dpGrid[row][col + 1], current[row + 1] = dpGrid[row + 1][col]
                } else {
                    current[row] = Math.max(previous[row], current[row + 1]);
                }
            }
            // The current column becomes the previous one.
            previous = current;
        }
            
        // The original problem's answer is in previous[0]. Return it.
        return previous[0];
    }
}
