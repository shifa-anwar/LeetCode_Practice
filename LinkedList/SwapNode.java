/*
1721. Swapping Nodes in a Linked List
You are given the head of a linked list, and an integer k.
Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).
Example 1:
Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]

Example 2:
Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
Output: [7,9,6,6,8,7,3,0,9,5]
*/
1.using floyd's cycle
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast=head,slow=head,curr=head; //floyd's cycle
        for(int i=1;i<k;i++)
        {
         curr=curr.next;
        }
        fast=curr;
        while(fast.next!=null)
        {
          slow=slow.next;
          fast=fast.next;
        }
        int temp=slow.val;
        slow.val=curr.val;
        curr.val=temp;
        return head;
}
}

2.in one loop
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp1=head,temp2=head,curr=head;
        int c=1;
        while(curr.next!=null)
        {
            if(c<k)
            {
                temp1=temp1.next;
            }
            else
            {
                temp2=temp2.next;
            }
            c++;
            curr=curr.next;
        }
        int temp=temp1.val;
        temp1.val=temp2.val;
        temp2.val=temp;
        return head;
}
}
3.using two loops
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        if(head==null||head.next==null)
            return head;
        ListNode temp1=head,temp2=head,curr=head;
        int length=getLength(curr);
        int last=length-k+1;
        int c=1,s=1;
        while(temp1!=null && c<k)
        {
            c++;
            temp1=temp1.next;
        }
        
        while(temp2!=null && s<last)
        {
            s++;
            temp2=temp2.next;
        }
        if(temp1==null||temp2==null)
            return head;
        int temp=temp1.val;
        temp1.val=temp2.val;
        temp2.val=temp;
   return head;
    }
    public int getLength(ListNode curr)
    {
        int length=0;
        while(curr!=null)
        {
            length++;
            curr=curr.next;
        }
        return length;
    }
}