class Solution {
   int min = Integer.MAX_VALUE,secmin= Integer.MAX_VALUE;
   boolean check =false;
    public int findSecondMinimumValue(TreeNode root) {
    if(root==null)
    {
       return -1; 
    }
    if(root.val<min)
    {
      min = root.val;  
    }
    if(root.val>min&&root.val<=secmin)
    {
     check = true;   
     secmin = root.val;   
    }
     findSecondMinimumValue(root.left);   
     findSecondMinimumValue(root.right);
     return check==false?-1:secmin;  
}
}
    