class Solution {
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};
    private int INF = 2147483647;
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == INF) {
                    grid[i][j] = bfs(i, j, grid);
                }
            }
        }
    }

    public int bfs(int r, int c, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int distance = 0;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        visited[r][c] = true;
        q.offer(new int[] {r, c});
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] dir = q.poll();
                if (grid[dir[0]][dir[1]] == 0)
                    return distance;
                for (int i = 0; i < 4; i++) {
                    int nx = dir[0] + dx[i];
                    int ny = dir[1] + dy[i];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny]
                        && grid[nx][ny] != -1) {
                        visited[nx][ny] = true;
                        q.offer(new int[] {nx, ny});
                    }
                }
            }
            distance++;
        }
        return INF;
    }
}
