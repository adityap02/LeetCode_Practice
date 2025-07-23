public class Solution {
    
    public int countSubstrings(String s) {
        //Will use 2 pointer approach
        //We will try building palindrome from string index 0 and move our way forward (for foth Odd and Even)
        //Will use a helper functionto count num of palindromes for all substrings 
        //O(n^2) , SC : O(1)
        int res = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // odd length
            int l = i, r = i;
            while (l >= 0 && r < s.length() && 
                   s.charAt(l) == s.charAt(r)) {
                res++;
                l--;
                r++;
            }

            // even length
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && 
                   s.charAt(l) == s.charAt(r)) {
                res++;
                l--;
                r++;
            }
        }

        return res;
    }
}