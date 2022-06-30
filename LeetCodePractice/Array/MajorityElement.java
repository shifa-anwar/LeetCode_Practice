/*
Majority Element
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than [n/2] times. You may assume that the majority element always exists in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2
 
Constraints:
n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
*/
1.Using Hashmap
class Solution {
    public int majorityElement(int[] nums) {
    int length = nums.length/2,res=0;
    HashMap<Integer,Integer> map = new HashMap<>();
    for(int i=0;i<nums.length;i++)
    {
     int count = map.getOrDefault(nums[i],0);   
     map.put(nums[i],count+1); 
     if(map.get(nums[i])>length)
     {
       res = nums[i];  
     }
    }
     return res;   
    }
}
Time:O(n)
space:O(n)

2.Boyer Moore voting algorithm
/*
When the elements are the same as the candidate element, votes are 
incremented when some other element is found not equal to the candidate
element. We decreased the count. This actually means that we are decreasing 
the priority of winning ability of the selected candidate, since we know that 
if the candidate is a majority it occurs more than N/2 times and the remaining 
elements are less than N/2. We keep decreasing the votes since we found some 
different element than the candidate element. When votes become 0, this actually
means that there are the same number of different elements, which should not be 
the case for the element to be the majority element. So the candidate element cannot 
be the majority, so we choose the present element as the candidate and continue the 
same till all the elements get finished. The final candidate would be our majority 
element. We check using the 2nd traversal to see whether its count is greater than N/2.
 If it is true, we consider it as the majority element.
*/
class Solution
{
    static int majorityElement(int a[], int size)
    {
        // your code here
        int count=0;
        int candidate = -1;
        for(int i=0;i<size;i++)
        {
        if(count==0)
        {
        candidate = a[i];        
        }
        count += a[i]==candidate?1:-1;
        }
        count=0;
        for(int i=0;i<size;i++)
 /*if the candidate occurs more than n/2 times then it is 
   present in array else there is no majority element */
        {
        if(a[i]==candidate)
        {
         count++;   
        }
        }
        return count>size/2?candidate:-1;
    }
}
Time :O(n)
Space:O(1)