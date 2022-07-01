/*
Kth Largest Element in an Array
Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 
Constraints:
1 <= k <= nums.length <= 104
-104 <= nums[i] <= 104
*/
1. Priority Queue
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++)
        {
            if(i<k)
            {
              pq.add(nums[i]);  
            }
            else
            {
              if(pq.peek()<nums[i])
              {
                pq.remove();
                pq.add(nums[i]);  
              }
            }
        }
       return pq.peek();
    }
}
Time:O(n)
Space:O(n)

2.sorting
class Solution {
    public int findKthLargest(int[] nums, int k) {
       Arrays.sort(nums);
        return nums[nums.length-k];
    }
}