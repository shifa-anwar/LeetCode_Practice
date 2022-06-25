/*
Balanced binary tree
*/
class Solution {
    public boolean isBalanced(TreeNode root) {
     if(root==null)
     {
       return true;  
     }
      int ls = height(root.left);
      int rs = height(root.right);
      if(Math.abs(ls-rs)>1)
         return false;
      boolean left = isBalanced(root.left);
      boolean right = isBalanced(root.right);
      if(!left||!right)
          return false; 
        return true;
    }
    public int height(TreeNode root)
    {
      if(root==null)
      {
       return 0;   
      }
       int ls = height(root.left);
       int rs = height(root.right);
       int ht = Math.max(ls,rs)+1;
       return ht; 
    }
}
Time Complexity:O(n^2)
Space:O(n^2)

2.
class Solution {
    public boolean isBalanced(TreeNode root) {   
        return checkHeight(root)==-1?false:true;
    }
    public int checkHeight(TreeNode root)
    {
     if(root==null)
     {
       return 0;  
     }
        int left = checkHeight(root.left);
        int right= checkHeight(root.right);
        if(left==-1||right==-1||Math.abs(left-right)>1)
        return -1;
        return Math.max(left,right)+1;
    }
}
Time:O(n)
Spac:O(n)

