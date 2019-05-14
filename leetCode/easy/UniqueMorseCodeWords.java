/*

International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.

For convenience, the full table for the 26 letters of the English alphabet is given below:

[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, "cba" can be written as "-.-..--...", (which is the concatenation "-.-." + "-..." + ".-"). We'll call such a concatenation, the transformation of a word.

Return the number of different transformations among all words we have.

Example:
Input: words = ["gin", "zen", "gig", "msg"]
Output: 2
Explanation: 
The transformation of each word is:
"gin" -> "--...-."
"zen" -> "--...-."
"gig" -> "--...--."
"msg" -> "--...--."

There are 2 different transformations, "--...-." and "--...--.".
Note:

The length of words will be at most 100.
Each words[i] will have length in range [1, 12].
words[i] will only consist of lowercase letters.

*/

class Solution {
    
    String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
    public int uniqueMorseRepresentations(String[] words) {
        HashMap<String,Integer> answer = new HashMap();
        String s = "";
        //this is still only O(n) because the word strings 
        //have fixed length
        for(int i = 0; i < words.length; i++){
            String temp = words[i];
            for(int j = 0; j < temp.length(); j++){
                char c = temp.charAt(j);
                int morse_index = c;
                morse_index -= 97;
                s += morse[morse_index];
            }
            if(!answer.containsKey(s)){
                answer.put(s,1);
                s = "";    
            }
            s="";
        }
        return answer.size();
    }
}



/*

Runtime: 2 ms, faster than 88.10% of Java online submissions for Unique Morse Code Words.
Memory Usage: 34.8 MB, less than 97.70% of Java online submissions for Unique Morse Code Words.

*/
