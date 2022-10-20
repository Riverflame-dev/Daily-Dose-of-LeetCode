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
