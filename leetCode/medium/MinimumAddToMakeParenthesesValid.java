/*

Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any positions ) so that the resulting parentheses string is valid.

Formally, a parentheses string is valid if and only if:

It is the empty string, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.

*/




class Solution {
    public int minAddToMakeValid(String S) {
        //-go through with a counter
        //--if it ends with a positive number, add that many )'s to it
        //--if at any point it goes negative, add a ( to the poisiton 
        //in front of the current position 
        int ans = 0;
        int counter = 0;
        
        if(S.length() == 0){
            return 0;
        }
        else if(S.length() == 1){
            return 1;
        }
        
        for(int i = 0; i<S.length(); i++){
            if(S.charAt(i) == '('){
                counter++;
            }
            else{
                counter--;
                if(counter < 0){
                    ans++;
                    counter++;
                }
            }
            
        }
        return ans + counter;
    }
}



/*

Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Add to Make Parentheses Valid.
Memory Usage: 33.7 MB, less than 100.00% of Java online submissions for Minimum Add to Make Parentheses Valid.

*/
