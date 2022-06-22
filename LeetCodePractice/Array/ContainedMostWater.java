/*
Container With Most Water
You are given an integer array height of length n. There are n vertical lines drawn 
such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that 
the container contains the most water.Return the maximum amount of water
a container can store.
Notice that you may not slant the container.
Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Example 2:
Input: height = [1,1]
Output: 1
Constraints:
n == height.length
2 <= n <= 105
0 <= height[i] <= 104
*/
1.Brute force
class Solution {
    public int maxArea(int[] height) {
       int area = 0;
       for(int left=0;left<height.length;left++)
       {
       for(int right=left+1;right<height.length;right++)
       {
        int width= right-left;
        area= Math.max(area, Math.min(height[left],height[right]) * width);   
       }   
       }
        return area;
    }
}
 
 Time Complexity:O(n2)
 Space Complexity:O(1)

2.Greedy approach
class Solution {
    public int maxArea(int[] height) {
       int area = 0,maxArea=0,i=0,j=height.length-1;
       int length=0,width=0; 
       while(i<j)
       {
         area=(j-i)*Math.min(height[i],height[j]);
         if(height[i]>height[j])
         {
           j--;  
         }
         else
         {
          i++;   
         }
        if(area>maxArea)
        {
            maxArea=area;
        }
       }
        return maxArea;
}
}
  Time complexity:O(n)
  Space Complexity:O(1)        