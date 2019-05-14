/*

Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.

 

Example 1:

Input: "Hello"
Output: "hello"
Example 2:

Input: "here"
Output: "here"
Example 3:

Input: "LOVELY"
Output: "lovely"

*/
class Solution {
    public String toLowerCase(String str) {
        String out = "";
       // System.out.println((char)((int)str.charAt(0)+32));
        for(int i = 0; i < str.length(); i++){
            if(((int)str.charAt(i)>64)&&((int)str.charAt(i)<91)){
                char temp = ((char)((int)str.charAt(i)+32));
                out = out + temp;
            }
            else{
                out = out + str.charAt(i);
            }
        }
        return out;
    }
}



/*

Runtime: 0 ms, faster than 100.00% of Java online submissions for To Lower Case.
Memory Usage: 33.2 MB, less than 100.00% of Java online submissions for To Lower Case.

*/
