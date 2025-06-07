class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
    
        int num = n*n;
        int l=0,r=n-1;
        int counter =1;
        int rcol = n-1,lcol=0; 


        for(int pass =0; pass<(n+1)/2; pass++){
        //Traversing Layer by layer -> pass = Layer
        //(n+1)/2 -> gives number of layers 
            for (int i = pass; i < n - pass; i++) {
                // direction 1 - traverse from left to right
                ans[pass][i] = counter++;
            }

            
            for (int i = pass + 1; i < n - pass; i++) {
                // direction 2 - traverse from top to bottom
                ans[i][n - pass - 1] = counter++;
            }

            
            for (int i = pass + 1; i < n - pass; i++) {
                // direction 3 - traverse from right to left
                ans[n - pass - 1][n - i - 1] = counter++;
            }

            // direction 4 - traverse from bottom to top
            for (int i = pass + 1; i < n - pass - 1; i++) {
                ans[n - i - 1][pass] = counter++;
            }
        }
        

        return ans;
    }
}