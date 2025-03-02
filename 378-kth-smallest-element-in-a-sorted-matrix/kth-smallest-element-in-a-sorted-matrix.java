class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        /*int arr[]=Arrays.stream(matrix)
                            .flatMapToInt(Arrays::stream)
                            .toArray();
        Arrays.sort(arr);
        return arr[k-1];*/
        int arr[]=new int[matrix.length*matrix[0].length];
        int l=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                arr[l]=matrix[i][j];
                l++;
            }
        }
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            if(i==k-1){
                return arr[i];
            }
        }
        return -1;
    }
}