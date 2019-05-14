/*

The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.

*/


class Solution {
    public int hammingDistance(int x, int y) {
        String binary_x = Integer.toBinaryString(x);
        String binary_y = Integer.toBinaryString(y);
        String with_zeroes = "";
        int hamming = 0;
        
        //X > Y, add 0's to Y
        if(binary_x.length() > binary_y.length()){
            int zero_buffer = binary_x.length() - binary_y.length();
            while(with_zeroes.length() != zero_buffer){
                with_zeroes+="0";
            }
            with_zeroes+=binary_y;
        
            for(int i = 0; i < with_zeroes.length(); i++){
                if(with_zeroes.charAt(i) != binary_x.charAt(i)){
                    hamming++;
                }
            }
        }

        //Y > X, add 0's to X
        else if(binary_x.length() < binary_y.length()){
            int zero_buffer = binary_y.length() - binary_x.length(); 

            while(with_zeroes.length() != zero_buffer){
                with_zeroes+="0";
            }
            with_zeroes+=binary_x;
        
            for(int i = 0; i < with_zeroes.length(); i++){
                if(binary_y.charAt(i) != with_zeroes.charAt(i)){
                    hamming++;
                }
            }
            
        }
        //Y == X
        else{
            for(int i = 0; i < binary_y.length(); i++){
                if(binary_y.charAt(i) != binary_x.charAt(i)){
                    hamming++;
                }
            }
        }
        
        return hamming;
    }
}


/*

Runtime: 1 ms, faster than 63.85% of Java online submissions for Hamming Distance.
Memory Usage: 32.6 MB, less than 59.14% of Java online submissions for Hamming Distance.

*/
