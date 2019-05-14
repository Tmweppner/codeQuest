/*

Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.

 

Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 

Note:

1 <= A.length <= 5000
0 <= A[i] <= 5000

*/


class Solution {
    public int[] sortArrayByParity(int[] A) { 
        
        int even_pointer = 0;
        int odd_pointer = A.length-1;
        
        while(odd_pointer != even_pointer && odd_pointer>even_pointer){
            if(A[even_pointer]%2 != 0){
                while(A[odd_pointer]%2 != 0 && odd_pointer > even_pointer){
                    
                    odd_pointer--;
                    System.out.println("odd_pointer: "+odd_pointer);
                }
                int even_temp = A[odd_pointer];
                int odd_temp = A[even_pointer];
                A[odd_pointer] = odd_temp;
                A[even_pointer] = even_temp;
                
            }
            even_pointer++;
        }
        return A;
    }
}





/*

Runtime: 52 ms, faster than 5.01% of Java online submissions for Sort Array By Parity.
Memory Usage: 39.8 MB, less than 93.87% of Java online submissions for Sort Array By Parity.

*/
