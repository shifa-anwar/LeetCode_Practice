// Kids With the Greatest Number of Candies
class GreatestNumber{
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
       Boolean[] arr = new Boolean[candies.length];
       for(int i=0;i<candies.length;i++) 
       {
          if(candies[i]>max)
          max=candies[i];
       }
        for(int i=0;i<candies.length;i++)
        {
          if(candies[i]+extraCandies>=max)
             arr[i]= true;
            else
            arr[i]=false;    
        }
       List<Boolean> result = new ArrayList<>();
       for (boolean i : arr) {
       result.add(i);
    }
        return result;
}
}


2.without creating boolean array

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
       List<Boolean> result = new ArrayList<>();
       for(int i=0;i<candies.length;i++) 
       {
          if(candies[i]>max)
          max=candies[i];
       }
        for(int i=0;i<candies.length;i++)
        {
          if(candies[i]+extraCandies>=max)
            result.add(true);
            else
            result.add(false);    
        }
    
        return result;
}
}





