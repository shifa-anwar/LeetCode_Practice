/*
328. Odd Even Linked List
Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
The first node is considered odd, and the second node is even, and so on.
Note that the relative order inside both the even and odd groups should remain as it was in the input.
You must solve the problem in O(1) extra space complexity and O(n) time complexity.
Example 1:
Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]

Example 2:
Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]
*/
class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode evens=null,odds=null,even_end=null,odd_end=null,curr=head;
       int count=1;
        while(curr!=null)
        {
            
            if((count&1)==1)
            {
               if(odds==null)
               {
                odds=curr;
                odd_end=odds;   
               }
                else
                {
                   odd_end.next=curr;
                   odd_end=odd_end.next; 
                }
            }
             else
             {
                 if(evens==null)
                 {
                     evens=curr;
                     even_end=evens;
                 }
                 else
                 {
                    even_end.next=curr;
                    even_end=even_end.next; 
                 }
             }
            count++;
            curr=curr.next;
        }
        if(odds==null||evens==null)
            return head;
        odd_end.next=evens;
        even_end.next=null;
        head=odds;
        return head;
    }
}