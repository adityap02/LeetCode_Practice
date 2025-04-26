class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        //int l = matrix.length, w = matrix[0].length;
        int top = 0, bottom = matrix.length - 1; // b = length
        int left = 0, right = matrix[0].length - 1; // r = width
        List<Integer> ans = new ArrayList<>();
        //int iter =0;
        while(top <= bottom && left <= right){
        for(int i =left;i<=right;i++){
            ans.add(matrix[top][i]);
        }//Top Row
        top++;
        for(int i=top; i<=bottom; i++){
            ans.add(matrix[i][right]);
        }//Right Col
        right--;
        if (top <= bottom) {
        for(int i=right;i>=left ; i--){
            ans.add(matrix[bottom][i]);
        }//Bottom Row
        }
        bottom--;
        if (left <= right) {
            for(int i = bottom;i >= top; i--){
                ans.add(matrix[i][left]);
            }
            left++;
        }
        }

        // while(iter<Math.max(l,w)-2){
        // for(int i =iter;i<=w-1;i++){
        //     ans.add(matrix[iter][i]);
        // }
        // for(int r=iter+1;r<l;r++){
        //     ans.add(matrix[r][w-1]);
        // }
        // for(int b=w-2;b>=iter;b--){
        //     ans.add(matrix[l-1][b]);
        // }
        // for(int u=l-2;u>iter;u--){
        //     ans.add(matrix[u][iter]);
        // }
        // iter++;
        // }
        return ans;
    }
}