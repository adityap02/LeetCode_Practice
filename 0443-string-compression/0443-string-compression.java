class Solution {
    public int compress(char[] chars) {
        if(chars.length==1){
            return 1;
        }
        int ans=0;
        int l=0,r=0;

        while(r<chars.length){
            int count =0;
            char prev = chars[r];
            while(r<chars.length && prev==chars[r]){
                r++;
                count++;
            }
            chars[l++] = prev;
            if(count>1){
                for(char c : String.valueOf(count).toCharArray()){
                    chars[l++] = c;
                }
            }

        }
return l;
    }
}