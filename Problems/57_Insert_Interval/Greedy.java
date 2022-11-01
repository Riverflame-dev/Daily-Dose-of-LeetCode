/*
Approach #1 Greedy
- Add to the output all the intervals starting before newInterval.
- Add to the output newInterval. Merge it with the last added interval if newInterval starts before the last added interval.
- Add the next intervals one by one. Merge with the last added interval if the current interval starts before the last added interval.

Time Complexity: O(n)
- since it's one pass along the input array.

Space Complexity: O(n) 
- Since we declared extra memeory propotional to the input size n
*/

class Solution {
  public int[][] insert(int[][] intervals, int[] newInterval) {
      
    /*-----------Initialization-------------- */
      
    // get the start and end of the newInterval
    int newStart = newInterval[0], newEnd = newInterval[1];
      
    // index for iterating through all intervals
    int idx = 0, n = intervals.length;
      
    // A data structure to store all the merged intervals
    // Since we don't know how many merged intervals there will be
    // A dynamic array is ideal
    LinkedList<int[]> output = new LinkedList<int[]>();

    /*-----------Step 1-------------- */
      
    // add all intervals starting before the start of newInterval
    while (idx < n && newStart > intervals[idx][0])
      output.add(intervals[idx++]);

    /*-----------Step 2-------------- */
      
    // check the end of the last interval added against the start of the newInterval
    // if there is no overlap, just add the newInterval
    if (output.isEmpty() || output.getLast()[1] < newStart) output.add(newInterval);
      
    // if there is an overlap, merge with the last interval
    // Pick the bigger end value to extend the last interval in the list
    else output.getLast()[1] = Math.max(output.getLast()[1], newEnd);
    
    /*-----------Step 3-------------- */
      
    // add the rest of the intervals, merge with newInterval if needed
    while (idx < n) {
      int start = intervals[idx][0], end = intervals[idx][1];
        
      // if there is no overlap, just add the interval
      if (output.getLast()[1] < start) output.add(intervals[idx]);
        
      // if there is an overlap, merge with the last added interval
      else output.getLast()[1] = Math.max(output.getLast()[1], end);
      idx++;
    }
      
    // convert LinkedList to array
    return output.toArray(new int[output.size()][2]);
  }
}
