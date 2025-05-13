class Solution {
    public int myAtoi(String s) {
        
        s = s.trim();
        if(s.length()==0){
            return 0;
        }
        int sign = s.charAt(0)=='-' ? -1 : 1;
        int ans = 0;
        int i = (sign ==  -1 || s.charAt(0)=='+')  ? 1 : 0;
        char[] ch = s.toCharArray();

        while(i<s.length() && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i) - '0';
            if(ans>Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE/10 && digit > Integer.MAX_VALUE%10)){
                return sign ==1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = 10*ans +digit;
            i++;
        }
        return sign * ans;
    }
}