/*

A self-dividing number is a number that is divisible by every digit it contains.

For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

Also, a self-dividing number is not allowed to contain the digit zero.

Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.

Example 1:
Input: 
left = 1, right = 22
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
Note:

The boundaries of each input argument are 1 <= left <= right <= 10000.

*/





class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        
        List<Integer> answer = new ArrayList<Integer>();
        int div_count = 0;
        
        for(int i = left; i <= right; i++){
            String num_str = Integer.toString(i);
            if(!num_str.contains("0")){
                for(int j = 0; j < num_str.length(); j++){
                    int div = Character.getNumericValue(num_str.charAt(j));
                    if(i%div == 0){
                        div_count++;
                    }
                }   
            }
            
            if(div_count == num_str.length()){
                answer.add(i);
            }
            div_count = 0;
            
        }
        return answer;
        
        
    }
}


/*

Runtime: 8 ms, faster than 11.76% of Java online submissions for Self Dividing Numbers.
Memory Usage: 35 MB, less than 56.94% of Java online submissions for Self Dividing Numbers.

*/
