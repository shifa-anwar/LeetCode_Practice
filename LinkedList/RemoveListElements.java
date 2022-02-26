/*203. Remove Linked List Elements
Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
Example 1:
Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]

Example 2:
Input: head = [], val = 1
Output: []

Example 3:
Input: head = [7,7,7,7], val = 7
Output: []
*/
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null)
        return null;
        ListNode sentinel=new ListNode(0,head);
      ListNode temp=sentinel;
        while(head!=null)
        {
         if(head.val==val)
         {
             temp.next=head.next;
              head=head.next;
         }
            else
            {
        temp=temp.next;
        head=head.next;  
            }
        }
        return sentinel.next;
    }
}