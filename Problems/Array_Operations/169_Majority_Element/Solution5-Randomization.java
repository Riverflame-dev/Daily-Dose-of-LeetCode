/*
Approach 5: Randomization
Because more than n/2 array indices are occupied by the majority element, a random array index is likely to contain the majority element.
Because a given index is likely to have the majority element, we can just select a random index, check whether its value is the majority element, 
return if it is, and repeat if it is not. The algorithm is verifiably correct because we ensure that the randomly chosen value is the majority
element before ever returning.

Time complexity : O(∞)
- It is technically possible for this algorithm to run indefinitely, so the worst possible runtime is unbounded. 
- However, the expected runtime is far better - linear, in fact. 

Space complexity : O(1)
- Much like the brute force solution, the randomized approach runs with constant additional space.

*/

class Solution {
    
    // Returns a random int in [min, max] range
    private int randRange(Random rand, int min, int max) {
        // Random.nextInt(n) returns a random int in [0,n)
        return rand.nextInt(max - min) + min;
    }

    // Counts the occurence of num in num[]
    private int countOccurences(int[] nums, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    public int majorityElement(int[] nums) {
        Random rand = new Random();

        while (true) {
            // Get a num from num[] at a random index
            int candidate = nums[randRange(rand, 0, nums.length)];
            // Check if the num is a Majority Element
            if (countOccurences(nums, candidate) > nums.length/2) {
                return candidate;
            }
        }
    }
}
