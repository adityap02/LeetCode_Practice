class Solution {
    public int reverse(int x) {

        //---------------Working Method 
        // int ans = 0;

        // while (x != 0) {
        //     if (ans > Integer.MAX_VALUE / 10) return 0;
        //     if (ans < Integer.MIN_VALUE / 10) return 0;

        //     int remainder = x % 10;
        //     ans = (ans * 10) + remainder;
        //     x = x / 10;
        // }
        // return ans;

        //---------------------------
        // boolean neg = false;
        // if(x<0){
        //     neg = true;
        // }
        // System.out.println(x);
        // String s = Integer.valueOf(x).toString();
        // if(neg){
        //     s = s.substring(1);
        // }
        // String reversed = new StringBuilder(s).reverse().toString();

        // if(Long.parseLong(reversed)>=Integer.toUnsignedLong(Integer.MAX_VALUE)){
        //     return 0;
        // }
        // return neg ? 0-Integer.parseInt(reversed) : Integer.parseInt(reversed) ;


        //Another Method (100%)

        int sign = x<0 ? -1 : 1;
        int i =0, ans = 0;
        x = x*sign;
        while(x>0){
            int mod = x %10;
            x = x/10;
            if(ans>Integer.MAX_VALUE/10){
                return 0;
            }
            ans = ans *10 +mod;
        }  
        return sign * ans;
    }
}