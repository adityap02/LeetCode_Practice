class Solution {
        public int numIslands(char[][] grid) {
        int ans = 0, rp=0;

        for(char[] r : grid){
            int cp=0;
            for(char c : r){
                if(c=='1'){
                    bfs(grid,rp,cp);
                        ans++;
                }
                cp++;   
            }
            rp++;
        }

        return ans;
    }

    class Tuple{
        int x;
        int y;
        Tuple(int x , int y){
            this.x = x;
            this.y = y;
        }

    }
   
    private void bfs(char[][] grid, int r,int c){
        Deque<Tuple> visited = new ArrayDeque<>();
        visited.addFirst(new Tuple(r,c));
        
        while(!visited.isEmpty()){
          Tuple t = visited.removeLast();
            r = t.x;
            c = t.y;
            grid[r][c]='v';
        //Check UP
        if(r!=0){
            if(grid[r-1][c]=='1'){
              visited.addFirst(new Tuple(r-1, c));
              grid[r-1][c]='v';
            }
        }
        if(c!=0){
            if(grid[r][c-1]=='1'){
              visited.addFirst(new Tuple(r, c-1));
              grid[r][c-1]='v';
            }
        }
        if(c!=grid[0].length-1){
            if(grid[r][c+1]=='1'){
              visited.addFirst(new Tuple(r, c+1));
              grid[r][c+1]='v';
            }
        }
        if(r!=grid.length-1){
            if(grid[r+1][c]=='1'){
              visited.addFirst(new Tuple(r+1, c));
              grid[r+1][c]='v';
            }
        }
        
        }

    }
}