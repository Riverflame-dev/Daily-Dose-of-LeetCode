/*
Approach 2: Two Pointers
- If we start traversing inwards, from both ends of the input string, we can expect to see the same characters, in the same order.

Time complexity : O(n)
- We traverse over each character at-most once, until the two pointers meet in the middle, or when we break and return early.

Space complexity : O(1)
- No extra space required, at all.

*/

class Solution {
  public boolean isPalindrome(String s) {

    // i is the start pointer, j is the end pointer
    for (int i = 0, j = s.length() - 1; i < j; i++, j--) {

      // move the pointer towards each other as long as they haven't met
      // and ignore the non-alphanumeric characters
      while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
        i++;
      }
      while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
        j--;
      }

      // If the input is palindromic, both the pointers should point to equivalent characters, at all times. 
      if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
        return false;
    }

    return true;
  }
}
