class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int area = 0;
        while (l < r && r > 0) {
            if (height[l] < height[r]) {
                area = Math.max(area, Math.min(height[l], height[r]) * (r - l));
                l++;
            }
            else{
                area = Math.max(area, Math.min(height[l], height[r]) * (r - l));
                r--;
            }

        }

        return area;
    }
}