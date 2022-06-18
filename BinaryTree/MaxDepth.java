/*
Max depth of Binary Tree
*/
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)
        {
          return 0;  
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        int h = Math.max(l,r)+1;
        return h;
}
}