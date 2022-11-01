/*
Approach 1: Pop Count

Time complexity: O(n⋅logn)
- For each integer x, in the worst case, we need to perform O(logn) operations, since the number of bits in xx equals to logx+1 and all the bits can be equal to 1. 
- However, on average, each bit will be set n/2 times, so for each integer x we will perform log(x)/2 operations, therefore, in total, it will cost O(n⋅log(n)/2) operations.

Space complexity: O(1). Since the output array does not count towards the space complexity.
*/

class Solution {
    
    // Method to count '1's in number x
    private int popCount(int x) {
        int count = 0;
        while (x != 0) {
            count += (x%2) & 1;
            x >>>= 1;
        }
        return count;
    }
    
    // Solve the problem for one number at a time.
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for (int i = 0; i <= n; i++) {
            ans[i] = popCount(i);
        }
        return ans;
    }
}
