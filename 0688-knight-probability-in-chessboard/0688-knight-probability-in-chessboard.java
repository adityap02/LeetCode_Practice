public class Solution {
    public double knightProbability(int n, int k, int startRow, int startCol) {
        // All 8 possible knight moves
        int[][] moves = {
            {1, 2}, {1, -2}, {-1, 2}, {-1, -2},
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1}
        };

        // dp[step][i][j] = probability of being at (i, j) after 'step' moves
        double[][][] dp = new double[k + 1][n][n];
        dp[0][startRow][startCol] = 1.0; // Starting position, step = 0

        // Iterate through each move from 1 to k
        for (int step = 1; step <= k; step++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // Try all 8 possible directions from which (i, j) could be reached
                    for (int[] move : moves) {
                        int prevRow = i + move[0];
                        int prevCol = j + move[1];

                        // Only consider previous positions that are still on the board
                        if (prevRow >= 0 && prevRow < n && prevCol >= 0 && prevCol < n) {
                            dp[step][i][j] += dp[step - 1][prevRow][prevCol] / 8.0;
                        }
                    }
                }
            }
        }

        // Sum up the total probability of being anywhere on the board after k moves
        double total = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                total += dp[k][i][j];
            }
        }

        return total;
    }
}
