/*
Approach 1: Brute Force
The straight-forward solution is to compare every two meetings in the array, and see if they conflict with each other (i.e. if they overlap). Two meetings overlap if one of them starts while the other is still taking place.

Because we have two check every meeting with every other meeting, the total run time is O(n^2). No additional space is used, so the space complexity is O(1).
*/

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        
        // Iterate through all intervals
        for (int i = 0; i < intervals.length; i++) {
            
            // Compare the current interval to all other intervals in the array
            // and check for overlapping
            for (int j = i + 1; j < intervals.length; j++) {
                if (overlap(intervals[i], intervals[j])) return false;
            }
        }
        return true;
    }

    // If the start index of one interval is in between the start&end index of another interval
    // there is an overlap:
    // start2 <= start1 < end2
    // start1 <= start2 < end1
    private boolean overlap(int[] interval1, int[] interval2) {
        return (interval1[0] >= interval2[0] && interval1[0] < interval2[1])
            || (interval2[0] >= interval1[0] && interval2[0] < interval1[1]);
    }
  /*
  Overlap Condition
    The overlap condition in the code above can be written in a more concise way. Consider two non-overlapping meetings. 
    The earlier meeting ends before the later meeting begins. Therefore, the minimum end time of the two meetings (which 
    is the end time of the earlier meeting) is smaller than or equal the maximum start time of the two meetings (which is 
    the start time of the later meeting).
  */  
  public static boolean overlap(int[] interval1, int[] interval2) {
      return (Math.min(interval1[1], interval2[1]) >
              Math.max(interval1[0], interval2[0]));
  }
}


