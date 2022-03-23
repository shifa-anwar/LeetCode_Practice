/*
24. Swap Nodes in Pairs
Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
Example 1:
Input: head = [1,2,3,4]
Output: [2,1,4,3]

Example 2:
Input: head = []
Output: []

Example 3:
Input: head = [1]
Output: [1]
*/
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode curr=head;
        while(curr!=null&&curr.next!=null)
        {
            int temp=curr.val;
            curr.val=curr.next.val;
            curr.next.val=temp;
            curr=curr.next.next;
        }
        return head;
    }
}