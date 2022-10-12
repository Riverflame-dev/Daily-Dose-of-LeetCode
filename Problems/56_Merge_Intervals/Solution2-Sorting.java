/*
Approach 2: Sorting
We sort the intervals by their start value, then each set of intervals that can be merged will appear as a contiguous "run" in the sorted list.

Time Complexity: O(nlogn)
- Other than the sort invocation, we do a simple linear scan of the list
- so the runtime is dominated by the O(nlogn) complexity of sorting.

Space Complexity: O(n) 
- Since we declared extra memeory propotional to the input size n
- The sorting itself takes O(logn) space. Otherwise, we must allocate linear space to store a copy of intervals and sort that.
*/

class Solution {
    public int[][] merge(int[][] intervals) {
        // Arrays.sort() takes an Array of Objects and a function that can be used to compare two of the objects.
        // Sort the intervals by their start value.
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        // A data structure to store all the merged intervals
        // Since we don't know how many merged intervals there will be
        // A dynamic array is ideal
        // Hence, a linked list of integer arrays
        LinkedList<int[]> merged = new LinkedList<>();
        
        //
        for (int[] interval: intervals) {
            
            // Add the first interval to the linkedlist to start with
            // For the each interval [start, end],
            // interval[0] - start, interval[0] - end
            // We check the start and end of two intervals to see if they are overlapping
            // If the end of the last interval added to the list is before the start of the current interval (like 5 < 6)
            // not overlapping so we add the current interval to the list
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                
                // interval does not overlap with the previous, simply append it.
                merged.add(interval);
            } else {
                
                // If there is overlap, we merge the current and previous
                // Pick the bigger end value to extend the last interval in the list
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        
        // Convert the Linkedlist to a 2D array and return it
        return merged.toArray(new int[merged.size()][]);
    }
}
