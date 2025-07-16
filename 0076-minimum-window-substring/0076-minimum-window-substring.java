class Solution {
    //Intution
    //We use a sliding window to find the smallest substring in s that contains all characters from t. As we expand and shrink the window, we track character counts and update the result when all required characters are matched. This ensures we return the minimum valid window efficiently.
    public String minWindow(String s, String t) {
        // if(t.length()>s.length()){
        //     return"";
        // }
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        Map<Character,Integer> tMap = new HashMap<>();

        for(int i=0;i<t.length();i++){
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i),0)+1);
        }
        // Map<Character,Integer> sMap = new HashMap()<>;
        // for(int i =0; i < s.length();i++){
        //     sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i),0)+1);
        // }
        int l=0,r=0;
        Map<Character,Integer> window = new HashMap<>();
        int formed = 0, required = tMap.size();
        //(window length, left, right)
        int[] ans = { -1, 0, 0 };
        while(r<s.length()){
            char c = s.charAt(r);
            window.put(c,window.getOrDefault(c,0)+1);
            if(tMap.containsKey(c) && tMap.get(c).intValue()==window.get(c).intValue()){
                formed++;
            }
            while(l<=r && formed==required){
                c = s.charAt(l);
                if(ans[0]==-1 || r-l+1 < ans[0]){
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                // The character at the position pointed by the
                // `Left` pointer is no longer a part of the window.
                window.put(c,window.get(c) - 1);
                if (tMap.containsKey(c) && window.get(c).intValue() < tMap.get(c).intValue()){
                    formed--;
                }
                l++;
            }
            r++;

        }//O(S+T)
        return ans[0] == -1 ? "" : s.substring(ans[1],ans[2]+1);
    }
}