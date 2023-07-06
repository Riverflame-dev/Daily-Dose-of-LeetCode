/*
The line of code System.gc(); is used to suggest that the Java Virtual Machine (JVM) should run the garbage collector.

In Java, memory management is handled automatically by a garbage collector. The garbage collector is responsible for reclaiming 
memory occupied by objects that are no longer in use, freeing up resources and preventing memory leaks.

When you call System.gc();, you're making a suggestion to the JVM to initiate garbage collection. However, it's important to note 
that the garbage collector may or may not run immediately in response to this call. The decision to run the garbage collector ultimately 
lies with the JVM, which takes into consideration various factors such as available system resources and the current state of memory usage.

In general, it's considered good practice to allow the garbage collector to operate automatically without explicit intervention. 
The JVM is typically efficient at managing memory and running the garbage collector when needed. Manual calls to System.gc(); are generally 
unnecessary and can even have a negative impact on performance if used excessively.
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
         for(int i=0 ;i< nums.length;i++)
    {
        for(int j=i+1;j <nums.length;j++)
        {
            if(nums[i] + nums[j] == target)
            {
                System.gc();
                return new int[]{i,j};
            }
        }
    }
    return new int[] {};
    }
}
