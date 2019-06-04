/*

Given the root node of a binary search tree (BST) and a value to be inserted into the tree, insert the value into the BST. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

For example, 

Given the tree:
        4
       / \
      2   7
     / \
    1   3
And the value to insert: 5
You can return this binary search tree:

         4
       /   \
      2     7
     / \   /
    1   3 5
This tree is also valid:

         5
       /   \
      2     7
     / \   
    1   3
         \
          4

*/




/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode top = root;
        root = helper(top,val);
        return top;
    
    }
   
    
    public TreeNode helper(TreeNode root, int val) {
        if(root.val > val){
            if(root.left == null){
                TreeNode add = new TreeNode(val);
                root.left = add;
                return root;    
            }
            return helper(root.left, val);
        }
        else{
            if(root.right == null){
                TreeNode add = new TreeNode(val);
                root.right = add;
                return root;    
            }
            return helper(root.right, val);
        }
    }

}



/*

Runtime: 0 ms, faster than 100.00% of Java online submissions for Insert into a Binary Search Tree.
Memory Usage: 38.1 MB, less than 100.00% of Java online submissions for Insert into a Binary Search Tree.

*/
