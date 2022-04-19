/*
Next Greater Node In Linked List
You are given the head of a linked list with n nodes.
For each node in the list, find the value of the next greater node. That is, for each node, find the value of the first node that is next to it and has a strictly larger value than it.
Return an integer array answer where answer[i] is the value of the next greater node of the ith node (1-indexed). If the ith node does not have a next greater node, set answer[i] = 0.

Example 1:
Input: head = [2,1,5]
Output: [5,5,0]

Example 2:
Input: head = [2,7,4,3,5]
Output: [7,0,5,5,0]
*/
class Solution {
    public int countNode(ListNode head)
    {
     int c = 0;
     while(head!=null)
     {
      c++;
         head=head.next;
     }
        return c;
    }
    public int[] nextLargerNodes(ListNode head) {
        ListNode curr=head;
        int length = countNode(curr);
        int arr[]= new int[length];
        int idx =0;
        Stack<Integer> s1 = new Stack<>();//to store index
        Stack<Integer> s2 = new Stack<>();//to store element
       while(head!=null)
       {
        if(s1.isEmpty()&&s2.isEmpty())//if stack is empty then just push value
        {
         s1.push(idx++);
         s2.push(head.val);   
        }
           else
           {
             if(s2.peek()>=head.val)
             {
              s1.push(idx++);
              s2.push(head.val);   
             }
               else
               {
                 while(!s2.isEmpty()&&s2.peek()<head.val)
                /*if peek of stack is less than head value
                  then we'll pop from stack and add in array the nge
                  which is current head
                */   
                 {
                  arr[s1.pop()]=head.val;
                  s2.pop(); 
                 }
                 s1.push(idx++);
                   s2.push(head.val);   
               }
           }
           head = head.next;
       }
       return arr; 
    }
}