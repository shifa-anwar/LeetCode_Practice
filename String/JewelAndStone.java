class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int c=0;
        for(int j:jewels.toCharArray())
        {
          for(int i:stones.toCharArray())
          {
             if(j==i)
              c++;   
          }
        }
        return c;
    }
}