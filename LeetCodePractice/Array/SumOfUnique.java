    class SumOfUnique {
        public int sumOfUnique(int[] nums) {
            int hash[] = new int[101];
            int sum=0;
            for(int i=0;i<nums.length;i++)
            {
             hash[nums[i]]++;   
            }   
            for(int j=0;j<hash.length;j++)
            {
              if(hash[j]==1)
                sum= sum+j;  
            }
            return sum;
        }
    }