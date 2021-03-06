/*
Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).

The binary search tree is guaranteed to have unique values.

 

Example 1:

Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
Output: 32
Example 2:

Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
Output: 23
 

Note:

The number of nodes in the tree is at most 10000.
The final answer is guaranteed to be less than 2^31.

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
    int sum = 0;
    public int rangeSumBST(TreeNode root, int L, int R){
        if(root !=null && root.val >= L && root.val<= R){
            sum += root.val;
        }
        if(root.left != null){
            rangeSumBST(root.left,L,R);    
        }
        if(root.right != null){
            rangeSumBST(root.right,L,R);    
        }
        
        return sum;
    }
}

/*
Runtime: 1 ms, faster than 70.54% of Java online submissions for Range Sum of BST.
Memory Usage: 43.1 MB, less than 99.57% of Java online submissions for Range Sum of BST.
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
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null){
            return 0;
        }
        else if(root.val >= L && root.val <= R){
            return root.val + rangeSumBST(root.right, L, R) +rangeSumBST(root.left, L, R) ;
        }
        else{
            return rangeSumBST(root.right, L, R) +rangeSumBST(root.left, L, R) ;
        }
        
    }
}



/*

Runtime: 1 ms, faster than 62.91% of Java online submissions for Range Sum of BST.
Memory Usage: 42.5 MB, less than 99.89% of Java online submissions for Range Sum of BST.

*/




