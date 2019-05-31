/*

Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

*/




class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> tri = new ArrayList<List<Integer>>();
        
        //this is stupid for time but since im only doing this for the 
        //recursion practice this doesnt matter\
        //
        //populated the triangle with the proper amount of numbers
        //with -1 being the filler
        for(int i = 0; i < numRows; i++){
            List<Integer> gen = new ArrayList<Integer>();
            for(int j = 0; j <= i; j++){    
                if(j == 0){
                    gen.add(1);   
                }
                else{
                    gen.add(-1);    
                }
            }
            tri.add(gen);
        }
        System.out.println(tri);
        
        for(int i = 0; i < numRows; i++){
            //List<Integer> bottom = new ArrayList<Integer>();
            
            tri = helper(numRows-1,i,tri);
        }
        return tri;
        
    }
    
    //i->row | j->col
    //this should work assuming that the tri is populated with null arrays;
    public List<List<Integer>> helper(int row, int col, List<List<Integer>> tri){
        //base case
        if(col == 0 || row == col){
            tri.get(row).set(col,1);
            return tri;
        }
        //if neither has been calculated
        if(tri.get(row-1).get(col-1) == -1 && tri.get(row-1).get(col) == -1){
            tri = helper(row-1,col-1,tri);
            tri = helper(row-1,col,tri);
        }
        //if only the above right has been calculated
        else if(tri.get(row-1).get(col-1) == -1 && tri.get(row-1).get(col) != -1){
            tri = helper(row-1,col-1,tri);
            int temp = tri.get(row-1).get(col) + tri.get(row-1).get(col-1);
            tri.get(row).set(col,temp);
            return tri;
        }
        //if only the above left has been calculated
        else if(tri.get(row-1).get(col-1) != -1 && tri.get(row-1).get(col) == -1){
            tri = helper(row-1,col,tri);
            int temp = tri.get(row-1).get(col) + tri.get(row-1).get(col-1);
            tri.get(row).set(col,temp);
            return tri;
        }
        //if both above have already been calculated
        else{
            int temp = tri.get(row-1).get(col) + tri.get(row-1).get(col-1);
            tri.get(row).set(col,temp);
            return tri;
        }
        return tri;
    }
}



/*

NOT VERY GOOD
Runtime: 2 ms, faster than 17.70% of Java online submissions for Pascal's Triangle.
Memory Usage: 33.3 MB, less than 37.15% of Java online submissions for Pascal's Triangle.

*/
