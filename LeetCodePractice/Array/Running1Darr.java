//1. Time:O(n2)
    class Running1Darr {
    public int[] runningSum(int[] nums) {
    int arr[]=new int[nums.length];
     for(int i=0;i<nums.length;i++)
     {
         arr[i]= Sum(nums,i);
     }
     return arr;
    }
    public static int Sum(int arr[],int j)
    {
        int sum=0;
        for(int i=0;i<=j;i++)
        {
            sum+=arr[i];
        }
        return sum;
    }    
}

2. Time -O(n)
    class Solution {
    public int[] runningSum(int[] nums) {
        int sums = 0;
        int n  = nums.length;
        int arr[] =  new int[n];
        for(int i = 0 ; i < n ; i++)
        {
        arr[i] = sums + nums[i];
        sums += nums[i];
        }
        return arr;
    }
}