class Solution {
    public void solve(char[][] board) {
        //So the question is we have to make O to X for all surrounded region (except ones containing borders)
        // So we start with all 4 borders, Wherever O is seen, put any temproary char (Lets say T)
        //Also from that, do a DFS on all 4 directions and keep there T in place of O as we want to make
        // sure that any Area touching Borders - we dont change that. Everything else we will change (O->X)
        // So Once This is done , we change all remainign O to X and thhen all T to O again(as we kept T for temproary)
        //O(m*n)
        int ROWS = board.length;
        int COLS = board[0].length;

        for (int r = 0; r < ROWS; r++) {
            if (board[r][0] == 'O') {//Top Border Row
                dfs(board, r, 0);
            }
            if (board[r][COLS - 1] == 'O') {
                dfs(board, r, COLS - 1);//Bottom Border Row
            }
        }
        //Making all areas with border touching as T
        for (int c = 0; c < COLS; c++) {
            if (board[0][c] == 'O') {// Left Column
                dfs(board, 0, c);
            }
            if (board[ROWS - 1][c] == 'O') {//Right Column
                dfs(board, ROWS - 1, c);
            }
        }
        //Now Converting all O to X and T to O
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
                int ROWS = board.length;
        int COLS = board[0].length;
        if (r < 0 || c < 0 || r >= ROWS ||
                c >= COLS || board[r][c] != 'O') {
            return;
        }
        board[r][c] = 'T';
        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }
}