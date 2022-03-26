/*
496. Next Greater Element I
The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.
Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

Example 1:
Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
Output: [-1,3,-1]
Explanation: The next greater element for each value of nums1 is as follows:
- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
*/
1.Brute force
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int arr[]= new int[nums1.length];
        for(int i=0;i<arr.length;i++)
            arr[i]=-1;//make all element of new array as -1
        for(int i=0;i<nums1.length;i++)
        {
            
         for(int j=0;j<nums2.length;j++)
         {
             if(nums1[i]==nums2[j]) 
        /*
        if there is any element which is same in both array
         then we will check from index after that element
         */
             {
             for(int k=j+1;k<nums2.length;k++)
             {
              if(nums2[k]>nums2[j])
              {
                arr[i]=nums2[k];  
                break;  
              }
             }
             }
         }
        }
        return arr;
    }
}
Time complexity:O(n^3)
space complexity:O(n)

2. using hashing
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
       int map[]= new int[10001];
        for(int i=0;i<nums2.length;i++)
          map[nums2[i]]=i;//store the index of each num
        for(int i=0;i<nums1.length;i++)
        {
        int index=map[nums1[i]]; //get the index of current element
           boolean flag=false;
         for(int j=index+1;j<nums2.length;j++) //start the loop after one element after current index
         {
           if(nums1[i]<nums2[j])
           {
            nums1[i]=nums2[j];
            flag=true;
             break;  
           }
         }
         if(!flag) //if the greater no is not found then make it as -1
          nums1[i]=-1;   
        }
        return nums1;
    }
}

Time Complexity:O(n^2)
space complexity:O(n)

3.using stack and hashmap
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
      Stack<Integer> stack = new Stack<Integer>();
      HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums2.length;i++)
        {
          while(!stack.isEmpty()&&nums2[stack.peek()]<nums2[i]) 
        /*if stack contains element and if the peek is less than current 
          element then pop index from stack of previous value and add in map
           with value pair as the current greater element
          */           
          {
            int index=stack.pop();
              map.put(nums2[index],nums2[i]);
          }
            stack.push(i); //push index in stack
        }
        int res[]=new int[nums1.length];
        int k=0;
        for(int j=0;j<nums1.length;j++)
        {
         if(map.containsKey(nums1[j]))
         { res[k++]=map.get(nums1[j]);}
            else
            { res[k++]=-1;}   
        }
        return res;
    }
}