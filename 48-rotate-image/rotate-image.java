class Solution {
    public void rotate(int[][] matrix) {
        //transpose
       for(int i=0;i<matrix.length;i++){
            for(int j=i+1;j<matrix[0].length;j++){
                int temp=0;
                temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //reverse the transpose matrix
        //int temp=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length/2;j++){
                int temp=0;
                temp=matrix[i][j];
                matrix[i][j]=matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j]=temp;
            }
        }
    }
}