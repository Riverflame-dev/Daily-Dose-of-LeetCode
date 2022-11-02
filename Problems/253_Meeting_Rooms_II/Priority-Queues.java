/*
Approach 1: Priority Queues
- keep all the rooms in a min heap where the key for the min heap would be the ending time of meeting.
- every time we want to check if any room is free or not, simply check the topmost element of the min heap as that would be the room that would get free the earliest out of all the other rooms currently occupied.
- If the room we extracted from the top of the min heap isn't free, then no other room is. So, we can save time here and simply allocate a new room.

Time Complexity: O(NlogN)
- There are two major portions that take up time here. Sorting takes O(NlogN) 
- min-heap in any case has N heap.add(). In the worst case has N heap.poll() as well. Overall complexity being O(NlogN) since heap.poll() takes O(logN).

Space Complexity: O(N) 
- The min-heap can contain N elements in the worst case.
*/


class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
    // Check for the base case. If there are no intervals, return 0
    if (intervals.length == 0) return 0;

    // Min heap to keep track of the rooms in use
    // the key for the min heap would be the ending time of meeting
    PriorityQueue<Integer> allocator =
        new PriorityQueue<Integer>(intervals.length,
                                   new Comparator<Integer>() {
                                      public int compare(Integer a, Integer b) {
                                        return a - b;
                                      }
                                    });

    // Sort the intervals by start time
    Arrays.sort(
        intervals,
        new Comparator<int[]>() {
          public int compare(final int[] a, final int[] b) {
            return a[0] - b[0];
          }
        });

    // Add the first meeting's end time to a new room
    allocator.add(intervals[0][1]);

    // Iterate over remaining intervals
    for (int i = 1; i < intervals.length; i++) {

      // If the room due to free up the earliest is free
      // clear the exisiting room and assign that room to this meeting in the next step
      if (intervals[i][0] >= allocator.peek()) allocator.poll();

      // If a new room is to be assigned, add the new meeting's end time to the heap
      allocator.add(intervals[i][1]);
    }

    // The size of the heap tells us the minimum rooms required for all the meetings.
    return allocator.size();
  }
}
