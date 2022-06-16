/*
Merge Sorted Array
*/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = nums1.length;
        while(m!=0&&n!=0)
        {
           if(nums1[m-1]<=nums2[n-1])
           {
             nums1[l-1]= nums2[n-1];
               n--;
           }
            else
            {
              nums1[l-1]=nums1[m-1]; 
                m--;
            }
            l--;
        }
        while(m!=0)
        {
         nums1[l-1]=nums1[m-1];
            m--;
            l--;
        }
        while(n!=0)
        {
         nums1[l-1]=nums2[n-1];
            n--;
            l--;
        }
    }
}