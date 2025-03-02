class Solution {
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up, Down, Left, Right
    private int n, m;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        n = matrix.length;  // Assign values to class-level variables
        m = matrix[0].length;
        int[][] dp = new int[n][m];
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxLen = Math.max(maxLen, dfs(matrix, i, j, dp));
            }
        }
        return maxLen;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] dp) {
        if (dp[i][j] != 0) return dp[i][j]; // Return cached result

        int maxPath = 1;
        for (int[] dir : directions) {
            int ni = i + dir[0], nj = j + dir[1];
            if (ni >= 0 && ni < n && nj >= 0 && nj < m && matrix[ni][nj] > matrix[i][j]) {
                maxPath = Math.max(maxPath, 1 + dfs(matrix, ni, nj, dp));
            }
        }
        return dp[i][j] = maxPath; // Memoize and return
    }
}
