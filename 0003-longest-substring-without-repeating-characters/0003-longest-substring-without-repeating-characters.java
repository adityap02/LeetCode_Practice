class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] c = s.toCharArray();
        int l=0,r=0;
        int max =0;
        Set<Character> set = new HashSet<>();
        while(r<=s.length()-1){
            if(set.add(c[r])){
                
            }else{
                while(c[l]!=c[r] && l<=r){
                    set.remove(c[l]);
                    l++;
                }
                l++;
            }
            
            max = Math.max(max,r-l+1);
            r++;
        }
        return max;

    }
}