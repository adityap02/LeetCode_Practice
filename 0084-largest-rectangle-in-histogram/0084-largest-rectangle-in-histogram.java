class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        stack.push(-1);
        for(int i =0;i<heights.length;i++){
            while(stack.peek()!=-1 && (heights[stack.peek()] >= heights[i])){
                int currentHeight = heights[stack.pop()];
                int currentWidth = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, currentHeight * currentWidth);
            }
            stack.push(i);
            
        }
                while (stack.peek() != -1) {
            int currentHeight = heights[stack.pop()];
            int currentWidth = heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, currentHeight * currentWidth);
        }
        return maxArea;
    }
}