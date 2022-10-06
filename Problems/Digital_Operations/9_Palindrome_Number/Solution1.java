/*
Reverse only half of the digits to compare with the first half.
*/
class Solution {
    public boolean isPalindrome(int x) {
        
        // Edge cases:
        // when x < 0, x is not a palindrome.
        // when last digit = 0, only 0 itself can be palindrome.
        // 0-9 is always palindrome.
        if (x >=0 && x <= 9) return true;
        if(x < 0 || x % 10 == 0) return false;
        
        // Get last digit by x % 10
        // Get next last digit by x / 10 then x % 10
        // Build reversed by [last digit] * 10 + [next last digit]
        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        
        // Get rid of the middle digit by revertedNumber/10 when x length is odd
        // The middle digit doesn't matter in palidrome (it will always equal to itself)
        return x == revertedNumber || x == revertedNumber/10;
        
    }
}
