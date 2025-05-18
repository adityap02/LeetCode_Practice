class Solution {
    public String longestPalindrome(String s) {
        int len = 0;
        String ans = "";
        //Expand each character of s , to left and right .. and check if borth l & r chars are same ?
        for(int i=0;i< s.length();i++){
            int l=i,r=i;
            //Odd size Palindrome
            while(l>=0 && r<s.length() && (s.charAt(l)==s.charAt(r))){
                if(r-l+1 > len){
                    ans = s.substring(l,r+1);
                    len = r-l+1;
                }
                l--;
                r++;
            }

            //For Even Size Palindrome
            l=i;
            r=i+1;
            while(l>=0 && r<s.length() && (s.charAt(l)==s.charAt(r))){
                if(r-l+1 > len){
                    ans = s.substring(l,r+1);
                    len = r-l+1;
                }
                l--;
                r++;
            }
        }
    return ans;

    }

}