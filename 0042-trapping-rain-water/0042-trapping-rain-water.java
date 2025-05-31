class Solution {
    public int trap(int[] height) {
        int lBound =0, rBound =0; // create two bounds, at each position these bounds will help to calc that how much water it can hold 
        int l=0,r = height.length-1;
        int ans = 0;
        while(l<r){
            if(height[l]<height[r]){
                lBound = Math.max(lBound, height[l]);//check and update if we got a better/max left bound
                ans+= lBound-height[l]; // this is basically the height diff from left bound , and that much amount of water we can hold here
                l++;
            }else{
                rBound = Math.max(rBound, height[r]);
                ans+= rBound -height[r];
                r--;
            }
        }
return ans;
    }
}