class Solution {
    public boolean isPowerOfThree(int n) {
        if(n==1){
            return true;
        }else if(n<1){
            return false;
        }
        while(n>3){
            if(n%3!=0){
                return false;
            }
            n=n/3;
        }
        return n==3;
    }
    //Mathematics Solution
    // n = 3^i
    //i = Log n Base 3
    // i = Log n Base 10 / Log 3 Base 10 (Logn/Log3)
    //return (Math.log10(n) / Math.log10(3)) % 1 == 0;

    ///
}