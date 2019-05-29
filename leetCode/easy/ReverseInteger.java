/*

Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could 
only store integers within the 32-bit signed integer 
range: [−231,  231 − 1]. For the purpose of this problem, 
assume that your function returns 0 when the reversed 
integer overflows.

*/



class Solution {
    public int reverse(int x) {
        String num = Integer.toString(x);
        String new_num = "";
        if(num.charAt(0) == '-'){
            new_num += "-";
            for(int i = num.length()-1; i > 0; i--){
                new_num += num.charAt(i);
            }
        }
        else{
            for(int i = num.length()-1; i >= 0; i--){
                new_num += num.charAt(i);
            }
        }
        try{
            return Integer.parseInt(new_num);    
        }
        catch (Exception e) {
            return 0;
        }
        
    }
}



/*

Runtime: 2 ms, faster than 57.36% of Java online submissions for Reverse Integer.
Memory Usage: 33.3 MB, less than 59.31% of Java online submissions for Reverse Integer.

*/
