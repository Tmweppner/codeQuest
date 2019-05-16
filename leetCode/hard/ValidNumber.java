/*

Validate if a given string can be interpreted as a decimal number.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
" -90e3   " => true
" 1e" => false
"e3" => false
" 6e-1" => true
" 99e2.5 " => false
"53.5e93" => true
" --6 " => false
"-+3" => false
"95a54e53" => false

Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one. However, here is a list of characters that can be in a valid decimal number:

Numbers 0-9
Exponent - "e"
Positive/negative sign - "+"/"-"
Decimal point - "."
Of course, the context of these characters also matters in the input.

*/


class Solution {
    private boolean isNum(String s, int i){
        if((int)s.charAt(i) > 47 && (int)s.charAt(i) < 58){
             return true;
        }
        else{
            return false;
        }
    }
     
    //e might need a flag for repeating e's
    private boolean isE(String s, int i, int e_flag){
        if(e_flag == 1){
            return false;
        }
        else if(i == 0){
            return false;
        }
        else if(i == s.length() - 1){
           return false;
        }
        else if((int)s.charAt(i) == 101 && (isNum(s,i-1)||isDeci(s,i-1,0))&&(isNum(s,i+1)||isNeg(s,i+1,0))){
            return true;
        }
        else if((int)s.charAt(i) == 101 && isDeci(s,i-1,0)){

             return true;
             
         }
        else{

            return false;
        }
    }
  
    private boolean isNeg(String s, int i, int flag){
        if(flag == 1){
            return false;
        }
        else if(((int)s.charAt(i) == 45 && i == s.length()-1)||((int)s.charAt(i) == 43 && i == s.length()-1)){
            return false;
        }
        else if((int)s.charAt(i) == 45 &&(i == 0 || (int)s.charAt(i-1) == 101 || (int)s.charAt(i-1) == 32)){
            return true;
        }
                else if((int)s.charAt(i) == 43 &&(i == 0 || (int)s.charAt(i-1) == 101 || (int)s.charAt(i-1) == 32)){
            return true;
        }
        else{
            return false;
        }
    }
        
    private boolean isDeci(String s, int i, int flag){
        if(flag == 1){
            return false;
        }
        else if(s.length() == 1){
            return false;
        }
        else if(i == 0){
           if((int)s.charAt(i) == 46 &&  isNum(s,i+1)){
            return true;
           }
            else{
                return false;
            }
        }
        else if(i == s.length() - 1){
            if((int)s.charAt(i) == 46 && isNum(s,i-1) ){
            return true;
            }
            else{
                return false;
            }
        }
        
        else if((int)s.charAt(i) == 46 && (isNum(s,i-1) || isNum(s,i+1))){
            
            return true;
        }
        else{
            return false;
        }
        
    }
    
    private boolean isSpace(String s, int i, int num1_flag, int space_flag, int num2_flag){

        if(num1_flag == 1 && num2_flag == 1 && space_flag == 1){
            return false;
        }
        
        if((int)s.charAt(i) == 32 && s.length() ==1){
                           
            return false;
        }
        
        else if((int)s.charAt(i) == 32 && ( i == 0 || i == s.length()-1)){               
            return true;
        }
        else if((int)s.charAt(i) == 32 && ((int)s.charAt(i-1) == 32 || isNum(s,i-1) || isDeci(s,i-1,0))){
            return true;
        }

        else{
            return false;
        }
    }
    
    public boolean isNumber(String s) {

        int dec_flag = 0;
        int neg_flag = 0;
        int e_flag = 0;
        int num1_flag = 0;
        int num2_flag = 0;
        int space_flag = 0;
        int i = 0;

        boolean answer = true;
        
        
        while(answer && i < s.length()){
            // System.out.println(i);
            // System.out.println(answer);
            if(isNum(s,i) || isNeg(s,i,neg_flag) || isE(s,i, e_flag) || isDeci(s,i,dec_flag) || isSpace(s,i,num1_flag,space_flag,num2_flag)){
                
                if(e_flag == 1 && isDeci(s,i,dec_flag)){
                    return false;
                }
                if(isNum(s,i)){
                    num1_flag = 1;
                }
                if(isSpace(s,i,num1_flag,space_flag,num2_flag)&& num1_flag == 1){
                    space_flag = 1;
                    
                }
                if(isNum(s,i) && num1_flag == 1 && space_flag == 1){
                    num2_flag = 1;
                    answer = false;
                    return false;
                }
                if(isDeci(s,i,dec_flag)){
                    
                    dec_flag = 1;
                }
                if(isNeg(s,i,neg_flag)){
                    neg_flag = 1;
                }
                if(isE(s,i, e_flag)){
                    neg_flag = 0;
                  //  dec_flag = 0;
                    e_flag = 1;
                }                
                
                answer = true;
            }
            else{
                answer = false;
            }
            i++;
            System.out.println(answer);
        }
    //    System.out.println(answer);
        return answer;
    }
}


/*

Runtime: 24 ms, faster than 16.37% of Java online submissions for Valid Number.
Memory Usage: 35.2 MB, less than 99.94% of Java online submissions for Valid Number.

*/
