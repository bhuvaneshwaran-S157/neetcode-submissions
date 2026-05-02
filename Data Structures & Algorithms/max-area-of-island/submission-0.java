class Solution {
    int[] dirRow = {0, 0, -1, 1};
    int[] dirCol = {-1, 1, 0, 0};

    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int max = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, visited, i, j));
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, boolean[][] visited, int row, int col) {
        visited[row][col] = true;
        int area = 1; 
        for (int i = 0; i < 4; i++) {
            int newRow = row + dirRow[i];
            int newCol = col + dirCol[i];

            if (newRow >= 0 && newRow < grid.length &&
                newCol >= 0 && newCol < grid[0].length &&
                grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                area += dfs(grid, visited, newRow, newCol);
            }
        }
        return area;
    }
}
