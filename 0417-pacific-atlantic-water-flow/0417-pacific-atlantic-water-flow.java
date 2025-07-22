public class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        //As we want cells which meet both oceans, we start with all 4 borders
        //left and top touch Pacific and Right & bottom touch Atlantic
        //Start From these border cells and move in all 4 directions and update the corrosponding ocean 
        //if that cell can reach that ocean. We have 2 Ocean Arrays(2d Arrays)
        //At End, add all the coordinates which are in Both the arrays
        int ROWS = heights.length, COLS = heights[0].length;
        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];
        
        for (int c = 0; c < COLS; c++) {
            dfs(0, c, pac, heights);//Top(Pacific)
            dfs(ROWS - 1, c, atl, heights);//Bottom(Atlantic)
        }
        for (int r = 0; r < ROWS; r++) {
            dfs(r, 0, pac, heights);//Left(Pacific)
            dfs(r, COLS - 1, atl, heights);//Right(Atlantic)
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pac[r][c] && atl[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }

    private void dfs(int r, int c, boolean[][] ocean, int[][] heights) {
        ocean[r][c] = true;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] d : directions) {
            int nr = r + d[0], nc = c + d[1];
            if (nr >= 0 && nr < heights.length && 
                nc >= 0 && nc < heights[0].length && 
                !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]) {
                dfs(nr, nc, ocean, heights);
            }
        }
    }
}