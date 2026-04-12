class Solution {
    private static int [] dx = {-1, 1, 0, 0};
    private static int [] dy = {0, 0, -1, 1};
    public static int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1'){
                    count+=1;
                    bfs(i,j,grid);
                }
            }
        }
        return count;
    }
    public static void bfs(int r, int c, char[][] grid){
        Queue<Integer> row = new ArrayDeque<>();
        Queue<Integer> col = new ArrayDeque<>();
        int n = grid.length, m = grid[0].length;
        row.offer(r);
        col.offer(c);
        grid[r][c] = '0'; // mark as visited '1' -> '0'
        while(!row.isEmpty()){
            int rr = row.poll();
            int cc = col.poll();
            for(int i = 0; i < 4; i++){
               int nr = rr + dx[i];
               int nc = cc + dy[i];
               if(nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == '1'){
                row.offer(nr);
                col.offer(nc);
                grid[nr][nc] = '0';
                }
            }
        }
    }
}
