/*
61. Rotate List
Given the head of a linked list, rotate the list to the right by k places.

Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Example 2:
Input: head = [0,1,2], k = 4
Output: [2,0,1]
*/
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null)
            return head;
        int length=0;
        ListNode curr=head;
        while(curr!=null)
        {
            length++;
            curr=curr.next;
        }
         k=k%length;
        for(int i=0;i<k;i++)
        {
            ListNode sec=head,prev=null,last=null;
            prev=getNodeBeforeTail(sec);
            last=prev.next;
             prev.next=null;   
            last.next=head;
            head=last;
        }
       return head;
    }
    public ListNode getNodeBeforeTail(ListNode curr)
    {
        while(curr.next.next!=null)
        {
            curr=curr.next;
        }
        return curr;
    }
    
}