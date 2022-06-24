class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
        {
         return 0;   
        }
        int ld = diameterOfBinaryTree(root.left);
        int rd = diameterOfBinaryTree(root.right);
        int f = height(root.left)+height(root.right)+2;
        int dia = Math.max(f,Math.max(ld,rd));
        return dia;
    }
    public int height(TreeNode root)
    {
        if(root==null)
        {
           return -1; 
        }
        int l = height(root.left);
        int r = height(root.right);
        int th = Math.max(l,r)+1;
        return th;
    }
}