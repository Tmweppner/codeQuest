/*

Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.

 

Example 1:

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Example 2:

Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 

Note:

1 <= A.length <= 10000
-10000 <= A[i] <= 10000
A is sorted in non-decreasing order.

*/


class Solution {
    public int[] sortedSquares(int[] A) {
        for(int i = 0; i < A.length; i++){
            if(A[i] < 0){
                int temp = (-1)*(A[i]);
                A[i] = temp;
            }
        }
        
        java.util.Arrays.sort(A);
        
        for(int i = 0; i < A.length; i++){
            int temp = (A[i])*(A[i]);
            A[i] = temp;    
        }
        
        return A;
    }
}



/*

Runtime: 3 ms, faster than 74.52% of Java online submissions for Squares of a Sorted Array.
Memory Usage: 39.8 MB, less than 99.10% of Java online submissions for Squares of a Sorted Array.

*/
