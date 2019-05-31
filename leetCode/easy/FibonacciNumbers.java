/*

The Fibonacci numbers, commonly denoted F(n) form a sequence, 
called the Fibonacci sequence, such that each number is the sum 
of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), for N > 1.
Given N, calculate F(N).

 

Example 1:

Input: 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
Example 2:

Input: 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
Example 3:

Input: 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 

Note:

0 ≤ N ≤ 30.

*/



class Solution {
    HashMap<Integer,Integer> known = new HashMap();
    public int fib(int N) {
        if(known.containsKey(N)){
            return known.get(N);
        }
        int result;
        if(N == 0 || N == 1){
            result = N;
        }
        else{
            result = fib(N-1) + fib(N-2);
        }
        known.put(N,result);
        return result;
    }
}



/*

Runtime: 0 ms, faster than 100.00% of Java online submissions for Fibonacci Number.
Memory Usage: 32.1 MB, less than 54.15% of Java online submissions for Fibonacci Number.

*/
