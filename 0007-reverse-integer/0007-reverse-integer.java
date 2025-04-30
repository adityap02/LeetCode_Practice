class Solution {
    public int reverse(int x) {
        boolean neg = false;
        if(x<0){
            neg = true;
        }
        System.out.println(x);
        String s = Integer.valueOf(x).toString();
        if(neg){
            s = s.substring(1);
        }
        String reversed = new StringBuilder(s).reverse().toString();

        if(Long.parseLong(reversed)>=Integer.toUnsignedLong(Integer.MAX_VALUE)){
            return 0;
        }
        return neg ? 0-Integer.parseInt(reversed) : Integer.parseInt(reversed) ;
    }
}