/*
234. Palindrome Linked List
Given the head of a singly linked list, return true if it is a palindrome.
Example 1:
Input: head = [1,2,2,1]
Output: true

Example 2:
Input: head = [1,2]
Output: false
*/
class Solution {
    public boolean isPalindrome(ListNode head)
    {
        if(head==null)
            return false;
        ListNode temp=head;
         ListNode slow=head,fast=head;
        while(fast!=null&&fast.next!=null&&slow!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode temp1=reverse(slow);
        while(temp!=null && temp1!=null)
        {
            if(temp.val!=temp1.val)
            {return false;}
            temp=temp.next;
            temp1=temp1.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head)
    {
     ListNode prev=null,next=null,node=head;
        while(node!=null)
        {
            next=node.next;
            node.next=prev;
            prev=node;
            node=next;
        }
        return prev;
    }
}