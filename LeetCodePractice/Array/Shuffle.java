class Shuffle {
    public int[] shuffle(int[] nums, int n) {
        int arr[] = new int[nums.length];
        int j=1;
        for(int i=0;i<nums.length;i++)
        {
          if((i^1)>i)
          arr[i]= nums[i/2];
            else
            { 
            arr[i]=nums[n+j-1]; 
             j++;
            }
        }
        return arr;
    }
}