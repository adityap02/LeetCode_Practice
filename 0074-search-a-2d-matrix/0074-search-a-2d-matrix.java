class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length-1, c = matrix[0].length-1;
        int i = 0, j = 0;
        //Bin search - O(log mn)
        while (i <= r) {//this step - calculating row
            int m = (r + i) / 2;
            if (matrix[m][0] < target && (matrix[m][c]-1) >target) {
                //means target is between 0th index of a row and last index of same row
                //If this condition is met, it means the target could potentially exist in this row. 
                break;
            }
            if (target < matrix[m][0]) {
                r = m - 1;
            } else {
                i = m + 1;
            }
        }

        int row = (i+r)/2 ;
        while (j <= c) {
            int m = (j + c) / 2;
            if (matrix[row][m] == target) {
                return true;
            }
            if (target < matrix[row][m]) {
                c = m - 1;
            } else {
                j = m + 1;
            }

        }
        return false;
    }
}