class Solution {
    public int minDistance(String word1, String word2) {
        //if chars match (i&j++) and 0 operations
        //if not match ( 3 possible operations (+1 Operations) -> insert (i,j+1) , 
        //Delete (i+1,j), Replace(i+1,j+1))
        //2d DP Approach bottom-up
        int m = word1.length();
        int n = word2.length();
        //Fill 1st row and col , as # of operations required if any one word is empty
        //this will act as base to fill up other cells/positions
        int[][] cost = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            cost[i][0] = i;
        for (int i = 1; i <= n; i++)
            cost[0][i] = i;

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                //0th row and 0th column is dummy that's why (+1 +1)
                //if chars are same
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    cost[i][j] = cost[i-1][j-1];//no need to change anything, no extra operations
                else {
                    //Replace -> aligning word1[i-1] with word2[j-1]
                    int a = cost[i-1][j-1];//diagonal up left (Replace)
                    int b = cost[i-1][j];//up (Delete)
                    int c = cost[i][j-1];//left (Insert)
                    cost[i][j] = Math.min(a, Math.min(b, c)); // min of a,b,c
                    cost[i][j]++;//increasing the cost
                }
            }
        }
        return cost[m][n];
    }//O(m × n) (BOTH)
}