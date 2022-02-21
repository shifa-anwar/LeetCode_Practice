/*Middle of the Linked List
Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.
Example 1:
Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.*/
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
    public ListNode middleNode(ListNode head) {
       ListNode fast_ptr=head;
        ListNode slow_ptr=head;
        while(fast_ptr!=null&&fast_ptr.next!=null)
        {
            fast_ptr=fast_ptr.next.next;
            slow_ptr=slow_ptr.next;
        }
        return slow_ptr;
        }
}