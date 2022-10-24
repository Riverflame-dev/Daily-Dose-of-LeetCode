// 我们可以在窗口内元素之和大于等于 0 时扩大窗口，在窗口内元素之和小于 0 时缩小窗口，在每次移动窗口时更新答案。

class Solution {
  public int maxSubArray(int[] nums) {
      int left = 0, right = 0;
      int windowSum = 0, maxSum = Integer.MIN_VALUE;
      while(right < nums.length){
          // 扩大窗口并更新窗口内的元素和
          windowSum += nums[right];
          right++;

          // 更新答案
          maxSum = windowSum > maxSum ? windowSum : maxSum;

          // 判断窗口是否要收缩
          while(windowSum < 0) {
              // 缩小窗口并更新窗口内的元素和
              windowSum -=  nums[left];
              left++;
          }
      }
      return maxSum;
  }
}
