class Solution {
    public int countComponents(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        boolean[] visited = new boolean[n];

        int count = 0; 
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                count++;
                bfs(i, adj, visited);
            }
        }
        return count;
    }

    public void bfs(int start, List<Integer>[] adj, boolean[] visited){
        Queue<Integer> q = new ArrayDeque<>();
        visited[start] = true;
        q.add(start);
        while(!q.isEmpty()){
            int node = q.poll();
            for(int neighbor : adj[node]){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
    }
}
