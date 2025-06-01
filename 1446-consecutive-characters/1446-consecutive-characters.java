class Solution {
    public int maxPower(String s) {
        int l=0,r=0,ans=0;

        while(r<s.length()){
            int count=0;
            while(r<s.length() && s.charAt(l)==s.charAt(r)){
                count++;
                r++;
            }
            l=r;
            ans = Math.max(count, ans);
        }
        return ans;
    }
}