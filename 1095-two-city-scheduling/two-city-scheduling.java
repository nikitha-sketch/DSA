class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs,(a,b)->(a[0]-a[1])-(b[0]-b[1]));
        int totalSum=0;
        int n=costs.length/2;
        for(int i=0;i<n;i++){
            totalSum+=costs[i][0];
        }
        for(int i=n;i<2*n;i++){
            totalSum+=costs[i][1];
        }
        return totalSum;
    }
}