public class Solution {
    public int reverse(int x) {
        int negative = 0;
        
        if( x < 0 ){
            int original = x;
            negative = 1;
            x -= original;
            x -= original;
        }
        if(x == 0){
            return 0;
        }
        
        String s = Integer.toString(x);
        StringBuilder rs = new StringBuilder(s).reverse();
        if(negative == 1){
            rs.insert(0, "-");
        }
        
        
        return Integer.parseInt(rs.toString());
        
       // return 0;
    }
}
