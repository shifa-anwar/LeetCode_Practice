/*
Increasing Order Search Tree
Given the root of a binary search tree, rearrange the tree in in-order so that the 
leftmost node in the tree is now the root of the tree, and every node has no left 
child and only one right child.
Example 1:
Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

Example 2:
Input: root = [5,1,7]
Output: [1,null,5,null,7]
 

Constraints:
The number of nodes in the given tree will be in the range [1, 100].
0 <= Node.val <= 1000
*/
1.using sentinel node to relink
class Solution {
    TreeNode prev;
    public TreeNode increasingBST(TreeNode root) {
    TreeNode sentinel = new TreeNode(0);
      prev = sentinel;  
      helper(root); 
      return sentinel.right;  
    }
    public void helper(TreeNode node) 
      {
        if(node==null)
        {
          return;
        }
        helper(node.left);
        node.left=null;//make left of current node as null then attach it to right of sentinel node
        prev.right=node;
        prev = node;
        helper(node.right);
    }
}
Time Complexity: O(N), where N is the number of nodes in the given tree.
Space Complexity: O(H) in additional space complexity, where H is the height
of the given tree, and the size of the implicit call stack in our in-order traversal.