class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int cols  =matrix.length-1; // no of cols index
        int n  = matrix[0].length-1;//no of rows index

        int l = 0, r =cols;
        //calculating row
        while(l<=r){
            int m = (l+r)/2;
            if(target == matrix[m][0]){
                return true;
            }
            if(target>matrix[m][0] && target< matrix[m][n] ){
                break;
            }
            if(target < matrix[m][0]){
                r= m-1;
            }else{
                l=m+1;
            }
        }

        int row = (l+r)/2 ;
        l=0;
        r=n;
        //finding in that row
        while(l<=r){
            int m  = (l+r)/2;
            if(target==matrix[row][m]){
                return true;
            }else if(target<matrix[row][m]){
                r=m-1;
            }else{
                l=m+1;
            }
        }

        return false;
    }
}