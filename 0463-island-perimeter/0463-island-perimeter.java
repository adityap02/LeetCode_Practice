class Solution {
    public int islandPerimeter(int[][] grid) {
        int r =0; 
        int ans = 0;
        for(int[] i : grid){
            int c =0;
            for(int j : i){
                if(j==1){
                   ans += 4 - count(grid, r,c);
                    
                }
                c++;
            }
            r++;
        }
        return ans;
    }
    public int count(int[][] grid, int r, int c){
        int ans = 0;
        int[][] moves = {{-1,0},{0,1},{1,0},{0,-1}}; // top , right, bottom, left
        //UP
        if(r!=0){
            ans+= grid[r-1][c];
        }
        //RIGHT
        if(c!=grid[0].length-1){
            ans+= grid[r][c+1];
        }
        //DOWN
        if(r!=grid.length-1){
            ans+= grid[r+1][c];
        }
        //LEFT
        if(c!=0){
            ans+= grid[r][c-1];
        }
        return ans;
    }
}