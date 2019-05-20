/*

A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
Note:

S will have length in range [1, 500].
S will consist of lowercase letters ('a' to 'z') only.

*/



class Solution {
    public List<Integer> partitionLabels(String S) {
        HashMap<Character, Integer> char_start = new HashMap();
        HashMap<Character, Integer> char_end = new HashMap();
        ArrayList<Integer> answer = new ArrayList();
        int cur_start = 0;
        int cur_end = 0;        
    
        //position of first occurance of every char
        //mapped with its char
        for(int i = 0; i < S.length(); i++){
            char_start.putIfAbsent(S.charAt(i), i);
        }
        //position of last occurance of every char
        //mapped with its char
        for(int i = S.length()-1; i > -1; i--){
            char_end.putIfAbsent(S.charAt(i), i);
        }

        for(int i = 0; i < S.length(); i++){
            cur_start = i;
            cur_end = char_end.get(S.charAt(i));
            for(int j = cur_start; j <= cur_end; j++){
                if(char_end.get(S.charAt(j)) > cur_end ){
                    cur_end = char_end.get(S.charAt(j));
                }
            }
            answer.add(1+cur_end-cur_start);
            i = cur_end;
        }
        return answer;
    }
}



/*

Runtime: 8 ms, faster than 26.28% of Java online submissions for Partition Labels.
Memory Usage: 35.3 MB, less than 97.47% of Java online submissions for Partition Labels.

*/
