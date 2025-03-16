class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       /* int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==target){
                    return true;
                }
            }
        }
        return false;*/

        if(matrix==null || matrix.length<1 || matrix[0].length<1){
            return false;
        }
        int col=matrix[0].length-1;
        int row=0;
        while(col>=0 && row<=matrix.length-1){
            if(target==matrix[row][col]){
                return true;
            }
            else if(target<matrix[row][col]){
                col--;
            }
            else if(target>matrix[row][col]){
                row++;
            }
        }
        return false;
    }
}