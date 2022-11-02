/*
Approach 2: Chronological Ordering
- we separate the two and treat them individually, then the identity of a meeting goes away. 

Time Complexity: O(NlogN)
- because all we are doing is sorting the two arrays for start timings and end timings individually and each of them would contain N elements considering there are N intervals.

Space Complexity: O(N) 
- because we create two separate arrays of size N, one for recording the start times and one for the end times.
*/

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
    // Check for the base case. If there are no intervals, return 0
    if (intervals.length == 0) return 0;
  
    // Get all the start and end time of the meetings
    Integer[] start = new Integer[intervals.length];
    Integer[] end = new Integer[intervals.length];
    for (int i = 0; i < intervals.length; i++) {
      start[i] = intervals[i][0];
      end[i] = intervals[i][1];
    }

    // Sort the end time intervals 
    Arrays.sort(
        end,
        new Comparator<Integer>() {
          public int compare(Integer a, Integer b) {
            return a - b;
          }
        });

    // Sort the start time intervals
    Arrays.sort(
        start,
        new Comparator<Integer>() {
          public int compare(Integer a, Integer b) {
            return a - b;
          }
        });

    // The two pointers in the algorithm: e_ptr and s_ptr.
    int startPointer = 0, endPointer = 0;

    // Variables to keep track of maximum number of rooms used.
    int usedRooms = 0;

    // Iterate over intervals.
    while (startPointer < intervals.length) {

      // If there is a meeting that has ended by the time the meeting at `s_pointer` starts
      // clear a used room for this meeting and move on to the next meeting
      if (start[startPointer] >= end[endPointer]) {
        usedRooms -= 1;
        endPointer += 1;
      }

      // We do this irrespective of whether a room frees up or not
      // If a room got free, then this used_rooms += 1 wouldn't have any effect
      // If no room was free, then this would increase used_rooms
      usedRooms += 1;
      startPointer += 1;

    }

    return usedRooms;
  }
}
