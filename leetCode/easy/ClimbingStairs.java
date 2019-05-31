/*

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

*/



class Solution {
    HashMap<Integer,Integer> cache = new HashMap();
    public int climbStairs(int n) {
        return helper(n);
    }
    public int helper(int n){
        if(cache.containsKey(n)){
            return cache.get(n);
        }
        int temp;
        if(n == 1 || n == 2){
            temp = n;
        }
        else{
            temp = helper(n-1) + helper(n-2);
        }
        cache.put(n,temp);
        return temp;
        
    }
}




/*

Runtime: 1 ms, faster than 43.16% of Java online submissions for Climbing Stairs.
Memory Usage: 32 MB, less than 54.70% of Java online submissions for Climbing Stairs.

*/
