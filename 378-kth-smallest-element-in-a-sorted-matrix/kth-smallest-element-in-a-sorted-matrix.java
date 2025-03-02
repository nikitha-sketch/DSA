class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int arr[]=Arrays.stream(matrix)
                            .flatMapToInt(Arrays::stream)
                            .toArray();
        Arrays.sort(arr);
       // int n=arr.length-k;
        return arr[k-1];
    }
}