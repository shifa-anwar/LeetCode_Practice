/*
Binary Tree Preorder Traversal
Given the root of a binary tree, return the preorder traversal of its nodes' values.

 

Example 1:


Input: root = [1,null,2,3]
Output: [1,2,3]
Example 2:

Input: root = []
Output: []
Example 3:

Input: root = [1]
Output: [1]
 

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
*/
//Recursive Solution
class Solution {
    List<Integer> path = new ArrayList<>(); 
    public List<Integer> preorderTraversal(TreeNode root) {
      if(root==null)
     {
       return path;  
     }
      path.add(root.val);
     preorderTraversal(root.left);
     preorderTraversal(root.right); 
      return path;  
    }
    }
  //iterative soln using stack
 class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        
     List<Integer> path = new ArrayList<>(); 
      if(root==null)
       {
         return path;  
       }
    Stack<TreeNode> st = new Stack<>();
    st.push(root);   
     while(st.size()>0)
     {
       TreeNode top = st.pop();  
      if(top.right!=null)
      {
       st.push(top.right);   
      }
      if(top.left!=null)
      {
       st.push(top.left);   
      } 
         path.add(top.val);  
     }   
    return path;
    }
}
    