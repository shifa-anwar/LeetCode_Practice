/*
Broken Calculator
There is a broken calculator that has the integer startValue on its display initially. In one operation, you can:

multiply the number on display by 2, or
subtract 1 from the number on display.
Given two integers startValue and target, return the minimum number of operations needed to display target on the calculator.

 

Example 1:

Input: startValue = 2, target = 3
Output: 2
Explanation: Use double operation and then decrement operation {2 -> 4 -> 3}.
Example 2:

Input: startValue = 5, target = 8
Output: 2
Explanation: Use decrement and then double {5 -> 4 -> 8}.
Example 3:

Input: startValue = 3, target = 10
Output: 3
Explanation: Use double, decrement and double {3 -> 6 -> 5 -> 10}.
Constraints:

1 <= startValue, target <= 109
*/
1.using recursion
class Solution {
    int count=0;
    public int brokenCalc(int start, int target) { 
      return helper(start,target);   
    }
    public int helper(int s,int t)
    {
     if(s==t)
     {
      return 0;
     }  
      if(s>t)
      {
        count+= s-t;
        return count;  
      } 
     if(t%2==0)
     {
      count+= helper(s,t/2);   
     }
       else
       {
        count+=helper(s,t+1);
       }
        count+=1;
        return count;
}
}

2.iterative
class Solution {
    public int brokenCalc(int start, int target) { 
      int count=0;
      while(start<target)
      {
       count++;
       if((target&1)==1)
       {
        target=target+1;   
       }
       else
       {
         target=target/2;  
       }
      }
        return start-target+count;
}
}
time:O(log target)
space:O(1) 
