/*
Lexicographical Numbers
Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.

You must write an algorithm that runs in O(n) time and uses O(1) extra space. 

 

Example 1:

Input: n = 13
Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]
Example 2:

Input: n = 2
Output: [1,2]
*/
(using dfs)
class Solution {
    public List<Integer> lexicalOrder(int n) {
      List<Integer> list = new ArrayList<>();
      for(int i=1;i<=9;i++)
      {
      helper(i,n,list); 
      }
       return list; 
    }
    public void helper(int i,int n,List<Integer> list)
    {
      if(i>n)
      {
        return ;  
      }
      list.add(i);  
      for(int j=0;j<10;j++)
      {
         helper(i*10+j,n,list); 
      }
    }
}