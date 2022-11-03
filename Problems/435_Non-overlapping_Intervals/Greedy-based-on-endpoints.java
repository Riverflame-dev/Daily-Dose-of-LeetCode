/*
Approach #5 Using Greedy Approach based on end points
- While traversing, if there is no overlapping between the previous interval and the current interval, we need not remove any interval. 
- But, if an overlap exists between the previous interval and the current interval, we always drop the current interval.

Time complexity : O(nlog(n))
- Because of the Sorting.

Space complexity : O(1)
- No extra space is used.

*/

class Solution {
      class myComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
              return a[1] - b[1];
        }
      }

      public int eraseOverlapIntervals(int[][] intervals) {
          
        // Check for the base case. If there are no intervals, return 0
        if (intervals.length == 0) return 0;
        
        // Sort the meetings by end time
        Arrays.sort(intervals, new myComparator());
          
        int end = intervals[0][1];
        int keep = 1;
          
        // Iterate over remaining intervals
        for (int i = 1; i < intervals.length; i++) {
            
          // if the current interval starts at or after the previous interval ends, there is no overlapping
          // update the number of intervals we will keep and move on to the next interval
          // otherwise, we will always discard the current interval and keep the prev end as it is
          if (intervals[i][0] >= end) {
            end = intervals[i][1];
            keep++;
          }
        }
        return intervals.length - keep;
      }
}
