/*
Climbin stairs
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 

Constraints:

1 <= n <= 45

*/
class Solution {
    public int climbStairs(int n) {
        if(n<=3)
         return n;   
        int arr[] = new int[n+1];
        arr[1]=1;arr[2]=2;
        for(int i=3;i<arr.length;i++)
        {
           arr[i]=arr[i-1]+arr[i-2]; 
        }
        return arr[n];
    }
}

/*
using Recursion 
Time Complexity :
O(3n)
This time complexity is exponential because for each state, 3 recursion calls are made.

SPACE COMPLEXITY :
O(1)
As no extra space is required, therefore space complexity is constant. However, if we include the space used in the recursive stack then the space complexity is O(n).
*/
