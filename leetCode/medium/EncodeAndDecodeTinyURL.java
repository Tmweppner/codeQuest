/*

Note: This is a companion problem to the System Design problem: Design TinyURL.
TinyURL is a URL shortening service where you enter a URL such as 
https://leetcode.com/problems/design-tinyurl and it returns a short URL such as 
http://tinyurl.com/4e9iAk.

Design the encode and decode methods for the TinyURL service. There is no 
restriction on how your encode/decode algorithm should work. You just need
to ensure that a URL can be encoded to a tiny URL and the tiny URL can be 
decoded to the original URL.

*/



public class Codec {
    HashMap<String, String> hash = new HashMap();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
     
        Random rand = new Random();  
        int x = rand.nextInt(1000000);
        
        String end = Integer.toString(x);;
        String answer = "http://tinyurl.com/";
        answer += end;
        hash.put(answer, longUrl);
        return answer;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return hash.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));






/*

Runtime: 3 ms, faster than 67.40% of Java online submissions for Encode and Decode TinyURL.
Memory Usage: 35.4 MB, less than 99.62% of Java online submissions for Encode and Decode TinyURL.

*/
