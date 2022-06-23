/*
Binary Tree Paths
Given the root of a binary tree, return all root-to-leaf paths in any order.
A leaf is a node with no children.
Example 1:
Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]

Example 2:
Input: root = [1]
Output: ["1"]

Constraints:
The number of nodes in the tree is in the range [1, 100].
-100 <= Node.val <= 100
*/
class Solution {
   List<String> path = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
      String str="";  
      sendPath(root,str);
      return path;  
    }
    public void sendPath(TreeNode root,String s)
    {
        if(root==null) //we'll reach this condition even if one side is present in case when we are calling left side and there is right sde but no left side
        {
          return;  
        }
        if(root.left==null&&root.right==null)//leaf node
        {
         s+=root.val;   
          path.add(s);  
        }
      sendPath(root.left,s+root.val+"->");
      sendPath(root.right,s+root.val+"->");
    }
}