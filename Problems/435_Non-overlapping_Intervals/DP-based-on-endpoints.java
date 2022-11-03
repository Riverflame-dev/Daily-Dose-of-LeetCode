/*
Complexity Analysis

Time complexity : O(n^2)
- Two nested loops are required to fill dp array.

Space complexity : O(n)
- dp array of size n is used.

*/

class Solution {
      class myComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
              return a[1] - b[1];
            }
        }

      // Method to check for overlapping
      public boolean isOverlapping(int[] i, int[] j) {
        // It's overlapping if the end time is after another meeting's start time
        return i[1] > j[0];
      }
    
      public int eraseOverlapIntervals(int[][] intervals) {
          
        // Check for the base case. If there are no intervals, return 0
        if (intervals.length == 0) return 0;
        
        // Sort the meetings by end time
        Arrays.sort(intervals, new myComparator());
          
        // dp[i] stores the maximum number of valid intervals that can be included in the final list 
        // if the intervals upto the i^{th} interval only are considered
        int dp[] = new int[intervals.length];
        dp[0] = 1;
        int ans = 1;
        
        // Iterate over remaining intervals
        for (int i = 1; i < dp.length; i++) {
          int max = 0;
        
          // iterate backwards for all the meetings before intervals[i]
          // dp[i+1]=max(dp[j])+1, where dp[j] is an interval before intervals[i]
          for (int j = i - 1; j >= 0; j--) {
              
            // Skip the overlapped intervals
            // find the maxinum of valid interval number for the non overlapped intervals 
            if (!isOverlapping(intervals[j], intervals[i])) {
                max = dp[j]; 
                break;
            }
          }
            
          // Two cases: 
          // 1. The current interval needs to be included in the final list
          //    we can stop the traversal as soon as we hit the first non-overlapping interval 
          //    and use its dp[j] + 1 to fill in dp[i+1], since dp[j] will be the element storing 
          //    the maximum number of intervals that can be included considering elements upto j^{th} index.
          // 2. The current interval needs to be removed from the final list 
          //    the current element won't be included in the final list. So, the count of intervals to be               
          //    included upto (i+1)^{th} is the same as the count of intervals upto the i^{th}. 
          dp[i] = Math.max(max + 1, dp[i - 1]);
          ans = Math.max(ans, dp[i]);
        }
          
        // The final result will be the total number of intervals given less the result just obtained
        return intervals.length - ans;
      }
}
