/*

Given an n-ary tree, return the preorder traversal of its nodes' values.

For example, given a 3-ary tree:

 
1___4
|\
| 2
3
| \
5   6

 

Return its preorder traversal as: [1,3,5,6,2,4].

 

Note:

Recursive solution is trivial, could you do it iteratively?

*/



/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    List<Integer> pre_ord = new ArrayList();
    
    public void helper(Node root){
            if(root != null){
                int x =  root.val;
                pre_ord.add(x);
                for(int i = 0; i < root.children.size(); i++){
                    preorder(root.children.get(i));
                }
            }
    }
    
    public List<Integer> preorder(Node root) {
        helper(root);
        return pre_ord;
    }
}



/*

Runtime: 1 ms, faster than 100.00% of Java online submissions for N-ary Tree Preorder Traversal.
Memory Usage: 49.7 MB, less than 15.94% of Java online submissions for N-ary Tree Preorder Traversal.

*/
