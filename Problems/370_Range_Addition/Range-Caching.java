/* 
Video Explanation: https://www.youtube.com/watch?v=b9gMT2sqeJI

Apporach:
  We update the value at start index, because it will be used in the future when we are adding up the values for the sum at each index 
  between start index and end index (both inclusive). We update the negative value at the end index + 1, because the positive value of 
  it should be only added at its previous indices (from start index to end index). Thus, when we accumulate the sum at the end for each 
  index, we will get the correct values for each index. If the end index is the last index in the resulting array, we don't have to do 
  the end index + 1 part, because there is no more index after the last index and there will be no error when we accumulate the sum.

Time complexity : O(n + k). 
- Each of the k update operations is done in constant O(1) time. 
- The final cumulative sum transformation takes O(n) time always.

Space complexity : O(1). 
- No extra space required.
*/ 

class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        
        int[] result = new int[length];
        
        // Edge cases
        if(updates == null || updates.length == 0) return result;
        
        // Iterate through all updates
        for(int i = 0; i < updates.length; i++){
            
            // Add the Increment at every startindex
            result[updates[i][0]] += updates[i][2];
            
            // Subtract the Increment at every endindex + 1
            if(updates[i][1] < length-1){
                result[updates[i][1]+1] -=updates[i][2];
            }
        }

        // Update result[] by doing result[i] += result[i-1]
        // This will make every -Increment at endindex+1 cancel 
        // the effect of +Increment carried over from startindex
        int v=0;
        for(int i=0; i<length; i++){
            v += result[i];
            result[i]=v;
        }

        return result;
    }
}
