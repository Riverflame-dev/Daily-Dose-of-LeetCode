/*
Approach 6: Divide and Conquer
- If we know the majority element in the left and right halves of an array, we can determine which is the global majority element in linear time.
- Apply a classical divide & conquer approach that recurses on the left and right halves of an array until an answer can be trivially achieved for a length-1 array.

Time complexity : O(nlgn)
- Each recursive call to majority_element_rec performs two recursive calls on subslices of size n/2 and two linear scans of length n. 

Space complexity : O(lgn)O(lgn)
- divide & conquer  uses a non-constant amount of additional memory in stack frames due to recursion. 
- Because the algorithm "cuts" the array in half at each level of recursion, it follows that there can only be O(lgn) "cuts" before the base case of 1 is reached. 
- It follows from this fact that the resulting recursion tree is balanced, and therefore all paths from the root to a leaf are of length O(lgn). 
- Because the recursion tree is traversed in a depth-first manner, the space complexity is therefore equivalent to the length of the longest path O(lgn).

*/

class Solution {
    
    // Returns the occurrences of num in nums[lo-hi]
    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    // Devide input array into left and right half recursively
    // After the base case returns an element from nums[] for both left and right,
    // Return the one that has the most occurrences
    private int majorityElementRec(int[] nums, int lo, int hi) {
        
        // base case; the only element in an array of size 1 is the majority
        // element.
        if (lo == hi) {
            return nums[lo];
        }

        // recurse on left and right halves of this slice.
        int mid = (hi-lo)/2 + lo;
        int left = majorityElementRec(nums, lo, mid);
        int right = majorityElementRec(nums, mid+1, hi);

        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
            
        } 
        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);
        
        return leftCount > rightCount ? left : right;
    }

    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length-1);
    }
}

/*
example num = [1,4,2,1,1,1]:

[1,4,2,1,1,1], 0, 5 -> lo != hi, mid = (5-0)/2 = 2 
left = 0 , 2 -> [1,4,2] -> mid = (2-0)/2 = 1 -> left = 2
	- left = 0, 1 -> [1,4] -> mid = (1-0)/2 = 0 -> left = 4
		left = 0, 0 -> return 1
		right = 1, 1 -> return 4
		L = count for 4 in num[0-1] = 1
		R = count for 1 in num[0-1] = 1
		L = R so return R = 4
	- right = 2, 2 -> right = 2
	- L = count for 4 in num[0-2] = 1
	  R = count for 2 in num[0-2] = 1
	  L = R so return 2
right = 3, 5 -> [1, 1, 1] -> right = 1

L = count for 2 in num[0-5] = 1
R = count for 1 in num[0-5] = 4

L < R so return 1
*/
