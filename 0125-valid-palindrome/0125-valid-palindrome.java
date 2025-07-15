class Solution {
    public boolean isPalindrome(String s) {
        // StringBuilder sb =new StringBuilder();
        // for(char c : s.toCharArray()){
        //     if(Character.isLetterOrDigit(c)){
        //         sb.append(Character.toLowerCase(c));
        //     }
        // }
        // return sb.toString().equals(sb.reverse().toString());
        int l = 0, r = s.length() - 1;
        char[] ch = s.toCharArray();
        while (l <= r) {
            while (l < r && !Character.isLetterOrDigit(Character.toLowerCase(ch[l]))) {
                l++;
            }
            while (l < r && !Character.isLetterOrDigit(Character.toLowerCase(ch[r]))) {
                r--;
            }
            if(Character.toLowerCase(ch[l]) !=Character.toLowerCase(ch[r]) ){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}