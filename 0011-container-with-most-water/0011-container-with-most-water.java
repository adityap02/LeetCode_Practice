class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int l=0, r= height.length-1;
        //TC :  O(n). Single pass.
        //SC : O(1). Constant space is used.
        while(l<r){
            int water = Math.min(height[l], height[r]) * (r-l);
            max = Math.max(max,water);

            if(height[l]<height[r]){
                l++;
            }else{
                r--;
            }

        }


        return max;

    }
}