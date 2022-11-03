/*
Approach #4 Using Greedy Approach based on starting points
- While considering the intervals in the ascending order of starting points, we make use of a pointer prev
  pointer to keep track of the interval just included in the final list. While traversing, we can encounter 3
  possibilities

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
          
        int prev = 0, count = 0;
          
        // Iterate over remaining intervals
        for (int i = 1; i < intervals.length; i++) {
            
          // if the prev interval ends after the current interval starts
          // there is overlapping
          if (intervals[prev][1] > intervals[i][0]) {
            
            // if the prev interval includes the current interval
            // we remove the prev interval and treat the current interval as the next prev interval
            if (intervals[prev][1] > intervals[i][1]) prev = i;
              
            // if the prev interval does not include the current interval
            // we just remove the current interval and the prev point remains the same
            count++;
              
          // if the prev interval ends before the current interval starts
          // there is no overlapping, we keep the prev interval so count remains the same
          // we treat the current interval as the next prev interval
          } else {
            prev = i;
          }  
        }
        return count;
      }
}
