/*

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.

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
    public int maxDepth(TreeNode root) {
        return helper(root,0);
    }
    public int helper(TreeNode root, int count){
        if(root == null){
            return count;
        }
        count++;
        int t1 = helper(root.right, count);
        int t2 = helper(root.left,count);
        if(t1>t2){
            return t1;
        }
        return t2;
    }
}



/*

Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Depth of Binary Tree.
Memory Usage: 38.5 MB, less than 95.24% of Java online submissions for Maximum Depth of Binary Tree.

*/
