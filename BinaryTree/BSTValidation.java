/*
Validate Binary Search Tree
*/
1.inorder check

class Solution {
    Integer prev=null;
    boolean res=true;
    public boolean isValidBST(TreeNode root) {
    inorder(root);
    return res;    
    }
    public void inorder(TreeNode root)
    {
      if(root.left!=null)
      {
        inorder(root.left);  
      }
      if(prev!=null)
      {
        if(prev>=root.val)
        {
          res=false;
        }
      }
       prev = root.val;
      if(root.right!=null)
      {
       inorder(root.right);   
      }
    }
}
Time Complexity:O(n)
Space Complexity:O(n)

2. Min max range
 class Solution {
    public boolean isValidBST(TreeNode root) {
        return checkBst(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean checkBst(TreeNode root,long min,long max)
    {
      if(root==null)
      {
         return true; 
      }
        if(root.val>=max||root.val<=min)
        {
          return false;  
        }
      return checkBst(root.left,min,root.val)&&checkBst(root.right,root.val,max);  
    }
}

Time Complexity:O(n)
Space Complexity:O(n)