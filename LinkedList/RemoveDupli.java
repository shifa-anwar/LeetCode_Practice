/*83. Remove Duplicates from Sorted List
Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
Example 1:
Input: head = [1,1,2]
Output: [1,2]

Example 2:
Input: head = [1,1,2,3,3]
Output: [1,2,3]
*/
1.Iterative soln
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
       ListNode curr=head;
        while(curr!=null&&curr.next!=null)
        {
           if(curr.val==curr.next.val)
              curr.next=curr.next.next; 
            else
                curr=curr.next;
        }
        return head;
    }
}
2.Recursive soln
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
      if(head==null)
          return null;
        if(head.next!=null)
        {
            ListNode temp;
            if(head.val==head.next.val)
            {
             temp=head.next;
             head.next=head.next.next;  
             deleteDuplicates(head);   
            }
            else
            {
             deleteDuplicates(head.next);   
            }
        }
        return head;
    }
}