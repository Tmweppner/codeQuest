/*

You have a list of words and a pattern, and you want to know which words in words matches the pattern.

A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.

(Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)

Return a list of the words in words that match the given pattern. 

You may return the answer in any order.

 

Example 1:

Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
Output: ["mee","aqq"]
Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}. 
"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
since a and b map to the same letter.
 

Note:

1 <= words.length <= 50
1 <= pattern.length = words[i].length <= 20

*/


class Solution {

    
    public ArrayList<Integer> intPattern(String pattern){
        
        ArrayList<Integer> int_pat = new ArrayList();
        HashMap<Character,Integer> char_int_map = new HashMap();       
        if(pattern.length() == 1){
            int_pat.add(1);
            return int_pat;
        }
        if(pattern.length() == 2){
            if(pattern.charAt(0) == pattern.charAt(1)){
                int_pat.add(1);
                int_pat.add(1);
            }
            else{
                int_pat.add(1);
                int_pat.add(2);
            }
            return int_pat;
        }
        
        int char_num = 1;
        char cur_char = pattern.charAt(0);
        char_int_map.put(cur_char,char_num);
        
        for(int i = 1; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            if(char_int_map.containsKey(c)){
                int_pat.add(char_int_map.get(c));
            }
            else{
                char_num++;
                char_int_map.put(c,char_num);
                int_pat.add(char_num);
            }
        }
        return int_pat;
    }
    
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        
        ArrayList<Integer> int_pat = new ArrayList();
        int_pat = intPattern(pattern);
        ArrayList<ArrayList<Integer>> int_words = new ArrayList();
        
        for(int i = 0; i<words.length; i++){
            int_words.add(intPattern(words[i]));
        }
        ArrayList<String> answer = new ArrayList();
        for(int i = 0; i < int_words.size(); i++){            
            if(int_words.get(i).equals(int_pat)){
                answer.add(words[i]);
            }
        }
        return answer;
    }
}



/*

Runtime: 2 ms, faster than 91.81% of Java online submissions for Find and Replace Pattern.
Memory Usage: 35.7 MB, less than 98.26% of Java online submissions for Find and Replace Pattern.

*/
