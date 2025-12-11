class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
         Map<Integer, int[]> xToYRange = new HashMap<>();
        Map<Integer, int[]> yToXRange = new HashMap<>();

        for (int[] b : buildings) {
            int x = b[0], y = b[1];           

            xToYRange.putIfAbsent(x, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});
            xToYRange.get(x)[0] = Math.min(xToYRange.get(x)[0], y);
            xToYRange.get(x)[1] = Math.max(xToYRange.get(x)[1], y);

            yToXRange.putIfAbsent(y, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});
            yToXRange.get(y)[0] = Math.min(yToXRange.get(y)[0], x);
            yToXRange.get(y)[1] = Math.max(yToXRange.get(y)[1], x);
        }
        
        // Count buildings that are "covered"
        int count = 0;
        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            
            // Check if the building is "covered" by checking the ranges for both axes
            if (yToXRange.get(y)[0] < x && x < yToXRange.get(y)[1] && 
                xToYRange.get(x)[0] < y && y < xToYRange.get(x)[1]) {
                count++;
            }
        }
        
        return count;
    }
}