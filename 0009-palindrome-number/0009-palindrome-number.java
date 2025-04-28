class Solution {
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        char[] ch = s.toCharArray();

        int l=0, r=ch.length-1;

        while(l<=r){
            if(l==r || (r-l==1 && ch[l]==ch[r])){
                return true;
            }else if(ch[l]==ch[r]){
                l++;
                r--;
                continue;
            }else{
                break;
            }
        }
        return false;
    }
}