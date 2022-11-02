/*
Approach 2: Sorting
The idea here is to sort the meetings by starting time. Then, go through the meetings one by one and make sure that each meeting ends before the next one starts.

Time complexity: O(nlogn). 
- The time complexity is dominated by sorting. 
- Once the array has been sorted, only O(n) time is taken to go through the array and determine if there is any overlap.

Space complexity: O(1). 
- Since no additional space is allocated.
*/

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        
        // Arrays.sort() takes an Array of Objects and a function that can be used to compare two of the objects.
        // Sort the intervals by their start value.
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Iterate through all intervals
        for (int i = 0; i < intervals.length - 1; i++) {
            
            // Compare the current interval to the next intervals 
            // and make sure that each meeting ends before the next one starts
            if (intervals[i][1] > intervals[i+1][0]) return false;
        }
        return true;
    }
}
