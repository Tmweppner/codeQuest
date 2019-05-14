/*

In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.

Return the element repeated N times.

 

Example 1:

Input: [1,2,3,3]
Output: 3
Example 2:

Input: [2,1,2,5,3,2]
Output: 2
Example 3:

Input: [5,1,5,2,5,3,5,4]
Output: 5
 

Note:

4 <= A.length <= 10000
0 <= A[i] < 10000
A.length is even

*/


class Solution {
    public int repeatedNTimes(int[] A) {
        int N = (A.length)/2;
        HashMap<Integer,Integer> answer = new HashMap();
        
        for(int i = 0; i < A.length; i++){
            if(answer.containsKey(A[i])){
                int temp = answer.get(A[i]) +1;
                answer.replace(A[i], temp);
                if(temp == N){
                    return A[i];
                }
            }
            else{
                answer.put(A[i],1);
            }
        }
        return 0;
    }
}



/*

Runtime: 19 ms, faster than 27.51% of Java online submissions for N-Repeated Element in Size 2N Array.
Memory Usage: 38.3 MB, less than 98.38% of Java online submissions for N-Repeated Element in Size 2N Array.

*/
