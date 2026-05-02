class Solution {
    int[] rowDir = {0, 0, -1, 1};
    int[] colDir = {-1, 1, 0, 0};

    public int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, boolean[][] visited, int row, int col) {
        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int newRow = row + rowDir[i];
            int newCol = col + colDir[i];

            // Check boundaries and if it's land and not visited
            if (newRow >= 0 && newRow < grid.length &&
                newCol >= 0 && newCol < grid[0].length &&
                !visited[newRow][newCol] && grid[newRow][newCol] == '1') {
                dfs(grid, visited, newRow, newCol);
            }
        }
    }
}
