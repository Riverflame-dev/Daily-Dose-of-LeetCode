/*
The time complexity of adding an element in a heap of size k is O(logk), 
and we do it N times that means O(Nlogk) time complexity for the algorithm.

This algorithm improves time complexity, but one pays with O(k) space complexity to store the heap elements.
*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        // k+1 size priority queue in ascending order (min heap)
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k+1);
        
        for (int i : nums) {
            pq.add(i);
            
            // keep the kth largest element at the top of the queue
            if (pq.size()>k) {
                pq.poll();
            }
        }
        return pq.poll();
    }
}
