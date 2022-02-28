/*
1669. Merge In Between Linked Lists
You are given two linked lists: list1 and list2 of sizes n and m respectively.
Remove list1's nodes from the ath node to the bth node, and put list2 in their place.
The blue edges and nodes in the following figure indicate the result:
Build the result list and return its head.

Example 1:
Input: list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
Output: [0,1,2,1000000,1000001,1000002,5]
Explanation: We remove the nodes 3 and 4 and put the entire list2 in their place. The blue edges and nodes in the above figure indicate the result.

Example 2:
Input: list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
Output: [0,1,1000000,1000001,1000002,1000003,1000004,6]
Explanation: The blue edges and nodes in the above figure indicate the result.
*/
1.
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode curr=list1,prev=null,temp=null,sec=list2;
        int count=1;
        while(curr.next!=null)
        {
           if(count==a)
           {
               prev=curr;
               while(count<=b)
               {
                count++;
                   curr=curr.next;
               }
               temp=curr.next;
               break;
           }
            else
            {
            curr=curr.next;
            }
            count++;
        }
        while(sec.next!=null)
        {
            sec=sec.next;
        }
        prev.next=list2;
        sec.next=temp;
        return list1;
    }
}

2.
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int first=0,last=0;
        ListNode temp=list1,sec=list2;;
        while(first<a-1)
        {
            first++;
            temp=temp.next;
        }
         
         ListNode temp1=list1;
        while(last<b)
        {
            last++;
            temp1=temp1.next;
             
        }
        while(sec.next!=null)
        {
            sec=sec.next;
        }
       temp.next=list2;
        sec.next=temp1.next;
        return list1;
    }
}
