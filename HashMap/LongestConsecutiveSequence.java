/*
Longest Consecutive Sequence
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
*/
class Solution {
    public int longestConsecutive(int[] nums) {
      HashMap<Integer,Boolean> map = new HashMap<>();  
     for(int i=0;i<nums.length;i++)
     {
       map.put(nums[i],true);  
     }
      for(int i=0;i<nums.length;i++)
     {
        if(map.containsKey(nums[i]-1))  
       map.put(nums[i],false);  
     }
         int ml=0;
         for(int i=0;i<nums.length;i++)
         {
          int st = 0;
          int val = nums[i];
          if(map.get(val)==true)
          {
          while(map.containsKey(val+st))
              st++;
           if(st>ml)
           {
            ml= st;   
           }
          }   
         }
        return ml;
    }
}
time :O(n)
Sapce:O(n)
Although the time complexity appears to be quadratic due to the while loop 
nested within the for loop, closer inspection reveals it to be linear. 
Because the while loop is reached only when currentNum marks the beginning 
of a sequence (i.e. currentNum-1 is not present in nums), the while loop can 
only run for nn iterations throughout the entire runtime of the algorithm. 
This means that despite looking like O(n \cdot n)O(n⋅n) complexity, the nested
loops actually run in O(n + n) = O(n)O(n+n)=O(n) time. All other computations 
occur in constant time, so the overall runtime is linear.

2. using sorting
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)
        {
         return 0;   
        }
        Arrays.sort(nums);
        int max_length=1,current_length=1;
        for(int i=1;i<nums.length;i++)
        {
         if(nums[i]!=nums[i-1])
         {
          if(nums[i]==nums[i-1]+1)
          {
           current_length++;   
          }
          else
          {
          max_length = Math.max(current_length,max_length);
           current_length=1;   
          }   
         }
        }
        return Math.max(current_length,max_length);
    }
}
Time Complexity:O(nlogn)
Space Complexity:O(1) or O(n)  
For the implementations provided here, the space complexity is constant because
we sort the input array in place. If we are not allowed to modify the input array,
we must spend linear space to store a sorted copy.