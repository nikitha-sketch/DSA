import java.util.*;

class Solution {
    static class Cell {
        int row, col, height;
        Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        if (m <= 2 || n <= 2) return 0; // too small grid

        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> minHeap = new PriorityQueue<>((a, b) -> a.height - b.height);

        // Add boundary cells
        for (int i = 0; i < m; i++) {
            minHeap.offer(new Cell(i, 0, heightMap[i][0]));
            minHeap.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            minHeap.offer(new Cell(0, j, heightMap[0][j]));
            minHeap.offer(new Cell(m - 1, j, heightMap[m - 1][j]));
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }

        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int water = 0;

        // BFS from lowest boundary
        while (!minHeap.isEmpty()) {
            Cell cell = minHeap.poll();
            for (int[] d : dirs) {
                int r = cell.row + d[0];
                int c = cell.col + d[1];

                if (r >= 0 && r < m && c >= 0 && c < n && !visited[r][c]) {
                    visited[r][c] = true;

                    if (heightMap[r][c] < cell.height) {
                        water += cell.height - heightMap[r][c];
                    }

                    // Push neighbor with effective height
                    minHeap.offer(new Cell(r, c, Math.max(heightMap[r][c], cell.height)));
                }
            }
        }

        return water;
    }
}
