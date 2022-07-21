/*
Given the head of a singly linked list and two integers left and right where left <= right,
reverse the nodes of the list from position left to position right, and return the
reversed list.

Example 1:
Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]

Example 2:
Input: head = [5], left = 1, right = 1
Output: [5]
 
Constraints:
The number of nodes in the list is n.
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n
Follow up: Could you do it in one pass?
*/
1.my soln
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null||head.next==null)
        {
          return head;  
        }
        if(right==left)
        {
           return head; 
        }
      ListNode temp1 = null,temp=head;
        int count=1;
       while(temp!=null)
       {
        if(count==left-1)
        {
           temp1 = temp; 
        }
         if(count == right+1)
         {
          break;   
         }
         temp=temp.next;
         count++; 
       }
        ListNode curr = head,tail=null,next=null,prev=null;
        count=1;
          while(count<left)
          {
          curr=curr.next;
          count++;    
          }
        while(curr!=null&&count<=right)
        {
            if(count==left)
            {
              tail=curr;  
            }
            next = curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            count++;
        }
         if(temp1==null)
         {
          tail.next= temp; 
         head = prev;
         }    
        else
        {
        temp1.next =prev;
        tail.next= temp;    
        }
        
        return head;
  }
}
2.iterative soln
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null||head.next==null)
        {
          return head;  
        }
        ListNode prev = null,curr=head;
        while(left!=1)
        {
         prev = curr;
         curr=curr.next;
         left--;right--;   
        }
        ListNode conn =prev,tail=curr,next=null;
        while(right!=0)
        {
         next = curr.next;
         curr.next = prev;
         prev = curr;
         curr=next;   
          right--;  
        }
        if(conn!=null)
            conn.next =prev;
        else
            head = prev;
        tail.next =curr;
        return head;
    }
}
Time :O(n)
Space:O(1)