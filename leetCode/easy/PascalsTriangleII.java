/*

Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 3
Output: [1,3,3,1]
Follow up:

Could you optimize your algorithm to use only O(k) extra space?

*/




class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> tri_row = new ArrayList<Integer>();
        if(rowIndex == 0){
            tri_row.add(1);
            return tri_row;
        }
        else if(rowIndex == 1){
            tri_row.add(1);
            tri_row.add(1);
            return tri_row;
        }
        tri_row.add(1);
        tri_row.add(1);
        return helper(tri_row, rowIndex);
    }
    public List<Integer> helper(List<Integer> tri_row, int rowIndex){
        if(tri_row.size() == rowIndex+1){
            return tri_row;
        }
        int temp1 = 0;
        int temp2 = 0;
        for(int i = 0; i < tri_row.size()-1; i++){
            if(i == 0){
                temp1 = tri_row.get(i);
                temp2 = tri_row.get(i+1);
                tri_row.set(i+1, temp1+temp2);
            }
            else{
                temp1 = temp2;
                temp2 = tri_row.get(i+1);
                tri_row.set(i+1, temp1+temp2);
            }
                        
        }
        tri_row.add(1);
        return helper(tri_row, rowIndex);
    }
}



/*

Runtime: 1 ms, faster than 85.64% of Java online submissions for Pascal's Triangle II.
Memory Usage: 33 MB, less than 38.12% of Java online submissions for Pascal's Triangle II.

*/
