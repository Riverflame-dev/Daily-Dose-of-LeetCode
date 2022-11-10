/*
Approach 1: Memoized Recursive
- Recursively break the original problem down into subproblems. 
- Find subproblems such that we can create an optimal solution from the results of those subproblems.
- We could consider and compute the answer for both cases: 
    - the line is part of the optimal solution 
    - the line is not part of the optimal solution.
    
Time complexity : O(M⋅N^2)
- We analyze a memoized-recursive function by looking at how many unique subproblems it will solve, and then what the cost of solving each subproblem is.
- There are MMM possible positions for the first string, and NNN for the second string. 
- Therefore, this gives us M⋅N possible pairs of integers, and is the number of subproblems to be solved.
- Solving each subproblem requires, in the worst case, an O(N) operation; searching for a character in a string of length N. This gives us a total of (M⋅N^2)

Space complexity : O(M⋅N)
- We need to store the answer for each of the M⋅N subproblems. Each subproblem takes O(1) space to store. This gives us a total of O(M⋅N).

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
        return memoSolve(0, 0);
    }

    // The input parameters to the recursive function are a pair of integers; representing a position in each string. 
    private int memoSolve(int p1, int p2) {        
    
    // Check whether or not we've already solved this subproblem.
    // This also covers the base cases where p1 == text1.length or p2 == text2.length.
    if (memo[p1][p2] != -1) return memo[p1][p2];
    
    // Option 1: we don't include text1[p1] in the solution.
    // we proceed to find LCS from p1+1 in text1, p2 in text2
    // option1 = memo[p1+1][p2]
    int option1 = memoSolve(p1 + 1, p2);

    // Option 2: We include text1[p1] in the solution, as long as
    // a match for it in text2 at or after p2 exists.

    // Find the first occurence of text1[p1] in text2, starting the search at position p2
    int firstOccurence = text2.indexOf(text1.charAt(p1), p2);
    // In the case of the letter not being present, no further subproblems are even solved with that particular first string.
    int option2 = 0;
    // If text1[p1] does occur in the rest of text2
    // we find LCS from p1+1 in text1, firstOccurence+1 index in text2
    // and add the pair of text1[p1] and text2[firstOccurence] to the result
    //  option2 = 1 + memo[p1+1][firstOccurence + 1]
    if (firstOccurence != -1) option2 = 1 + memoSolve(p1 + 1, firstOccurence + 1);

    // Add the best answer to the memo before returning it.
    memo[p1][p2] = Math.max(option1, option2);
    return memo[p1][p2];
    }
}
