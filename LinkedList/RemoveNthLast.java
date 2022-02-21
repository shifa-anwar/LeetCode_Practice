/* Remove Nth Node From End of List
Given the head of a linked list, remove the nth node from the end of the list and return its head.
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Input: head = [1], n = 1
Output: []
*/
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)
          return head;
        ListNode fast=head,slow=head,prev=null;
        for(int i=1;i<n;i++)
            fast=fast.next;
        while(fast.next!=null)
        {
            prev=slow;
            slow=slow.next;
            fast=fast.next;
        }
        if(prev==null)
        {
         head=head.next;   
        }
        else
        {
        prev.next=slow.next;
        }
       return head;
    }
}