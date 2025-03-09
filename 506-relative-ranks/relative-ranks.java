class Solution {
    public String[] findRelativeRanks(int[] score) {
        
       int n = score.length;
        String[] result = new String[n];

        // Store scores with their original indices
        int[][] scoreWithIndex = new int[n][2];
        for (int i = 0; i < n; i++) {
            scoreWithIndex[i][0] = score[i]; // Score
            scoreWithIndex[i][1] = i;        // Original index
        }

        // Sort scores in descending order
        Arrays.sort(scoreWithIndex, (a, b) -> b[0] - a[0]);

        // Assign ranks based on sorted order
        for (int rank = 0; rank < n; rank++) {
            int index = scoreWithIndex[rank][1]; // Get original index
            if (rank == 0) {
                result[index] = "Gold Medal";
            } else if (rank == 1) {
                result[index] = "Silver Medal";
            } else if (rank == 2) {
                result[index] = "Bronze Medal";
            } else {
                result[index] = String.valueOf(rank + 1);
            }
        }

        return result; 
    }
}