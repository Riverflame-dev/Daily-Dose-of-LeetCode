/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        // Linked list to return
        ListNode ans_head = new ListNode(0);
        ListNode l3 = ans_head;
        
        // Store the carry-over for each summation
        int carry = 0;
        
        while (l1 != null || l2 != null || carry != 0) {
            
            // Exact value for each node 
            // Assume 0 if list ended
            int n = (l1 !=null) ? l1.val : 0;
            int m = (l2 !=null) ? l2.val : 0;
            
            // Perform summation and update the carry
            int current_sum = n + m + carry;
            carry = current_sum / 10;
            
            // Extract single digit to add to l3
            ListNode new_node = new ListNode(current_sum % 10);
            l3.next = new_node;
            
            // Proceed to next node or a null node
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            l3 = l3.next;
        }
        
        return ans_head.next;
    }
}
