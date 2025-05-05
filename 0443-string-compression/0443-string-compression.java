class Solution {
    public int compress(char[] chars) {
        int l = 0;
        int r=0;

        while(r<chars.length){
            char currentChar = chars[r];
            int count =0;
            while(r<chars.length && chars[r]==currentChar){
                r++;
                count++;

            }
            chars[l++] = currentChar;
            if(count>1){
                //TODO for loop .. int to strring to char
                for(char c : String.valueOf(count).toCharArray()){
                    chars[l++] = c;
                    
                }
                //l++;
            }
            //chars[l+1] = count;
        }
        return l;

    }
}