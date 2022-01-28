
//1.First approach with O(1) space
class BuildFromPermut {
    public int[] buildArray(int[] nums) {
        int n = nums.length;
		
        for (int i = 0; i < n; i++) {
          nums[i] = nums[i] + (n * (nums[nums[i]] % n));
        }
		
        for (int i = 0; i < n; i++) {
          nums[i] = nums[i] / n;
        }
		
        return nums;
    }    
}


/*2.second approach with time complexity O(n)
class Solution {
    public int[] buildArray(int[] nums) {
        int arr[]= new int[nums.length];
       for(int i=0;i<nums.length;i++)
       {   
        arr[i]=nums[nums[i]];   
       }
        return arr;
    }
}
*/