/*

Given an n-ary tree, return the postorder traversal of its nodes' values.

For example, given a 3-ary tree:

 1___4
|\
| 2
3
| \
5   6

Return its postorder traversal as: [5,6,3,2,4,1].

 
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
    List<Integer> post_ord = new ArrayList();
    
    public void helper(Node root){
            if(root != null){
                for(int i = 0; i < root.children.size(); i++){
                    postorder(root.children.get(i));
                }
                int x =  root.val;
                post_ord.add(x);
            }
    }
    
    public List<Integer> postorder(Node root) {
        helper(root);
        return post_ord;
    }
}




/*

Runtime: 1 ms, faster than 100.00% of Java online submissions for N-ary Tree Postorder Traversal.
Memory Usage: 48.9 MB, less than 22.99% of Java online submissions for N-ary Tree Postorder Traversal.

*/
