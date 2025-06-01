public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        //Backtracking on DFS
        boolean[][] visited = new boolean[m][n];
        boolean result = false;
         // Try starting from every cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                 // Start DFS only if first letter matches
                if (board[i][j] == word.charAt(0)) {
                    result = backtrack(board, word, visited, i, j, 0);
                    if (result) return true;
                    // Found the word
                }
            }
        }
        
        return false;
    }
    
    private boolean backtrack(char[][] board, String word, boolean[][] visited, int i, int j, int index) {
        //  all characters matched
        if (index == word.length()) {
            return true;
        }
        // Check bounds and constraints:
        // - Inside board
        // - Not already visited
        // - Current board char matches current word char
        //if anything - fallback to false
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        
        visited[i][j] = true;
        // Explore all 4 directions: down, up, right, left
        // Only 3 valid directions at most after the first call because
        // the direction you came from is now marked visited
        if (backtrack(board, word, visited, i + 1, j, index + 1) ||
            backtrack(board, word, visited, i - 1, j, index + 1) ||
            backtrack(board, word, visited, i, j + 1, index + 1) ||
            backtrack(board, word, visited, i, j - 1, index + 1)) {
            return true;
        }
        
        visited[i][j] = false;
        return false;
    }
}