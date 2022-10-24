/*
Explanation :
1.) Through intution explanation we know that if all the elements are positive or the negative elements are even then ur answer 
    will be product of complete array which u will get in variable l and r at the last iteration.
2.) But if negative elements are odd then u have to remove one negative element and it is sure that it will be either right of 
    max prefix product or left of max suffix product. So u need not to modify anything in your code as u are getting prefix 
    product in l and suffix prduxt in r.
3.) If array also contains 0 then your l and r will become 0 at that point...then just update it to 1(or else u will keep multiplying 
    with 0) to get the product ahead making another subarray.
*/

class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int max_product = Integer.MIN_VALUE;
        int right_product = 1;
        int left_product = 1;

        for (int i = 0; i < nums.length; i++) {
            
            // if any of l or r become 0 then update it to 1
            left_product = left_product==0 ? 1 : left_product;
            right_product = right_product==0 ? 1 : right_product;
            
            // suffix product
            right_product *= nums[nums.length - 1 - i];
            // prefix product
            left_product *= nums[i]; 
            
            // Compare and keep track of the max product
            max_product = Math.max(left_product, Math.max(right_product, max_product));
        }
        return max_product;
    }
}
