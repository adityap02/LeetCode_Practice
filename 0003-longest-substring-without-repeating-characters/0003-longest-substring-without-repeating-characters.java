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
        //Another Solution

        // if(s.length()==0){
        //     return 0;
        // }
        // int ans = 0;
        // int l=0,r=0;
        // Map<Character,Integer> map = new HashMap<>();

        // while(r<s.length()){
        //     if(map.containsKey(s.charAt(r))){
        //         l= Math.max(map.get(s.charAt(r)), l);
        //         // if we dont do Math.max- it will fail at "abba"
        //     }
        //     ans = Math.max(ans, r-l+1);
        //     map.put(s.charAt(r),r+1);
        //     r++;
        // }
    }
}