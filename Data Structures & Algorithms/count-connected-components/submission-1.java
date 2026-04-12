class Solution {
    private int[] parent;
    private int[] rank;
     private int count;        // tracks number of components

    public int countComponents(int n, int[][] edges) {
        //using union find algo/
        parent = new int[n];
        rank = new int[n];
         for (int i = 0; i < n; i++) {
            parent[i] = i;  // every node starts as its own root
            rank[i]   = 0;
        }
        count = n;

        for (int[] edge : edges) {
         union(edge[0], edge[1]);   // ← this is the call
        }

        return count;

    }
    public int find(int x) {

            if (parent[x] != x) {
                parent[x] = find(parent[x]); // compress path on the way back
            }
            return parent[x];
        }
    public boolean union(int x,int y){

        int rootX = find(x);
        int rootY = find(y);

        //attach the lower ranked node to higher ranked parent/
         if (rootX == rootY) return false;  // already same group

        if (rank[rootX] < rank[rootY]){
            parent[rootX] = rootY;
        }
        else if (rank[x] > rank[y]){
            parent[rootY] = rootX;
        }
        else{
            //both ranks are equal/
            parent[rootY] = rootX;
            rank[rootX]++;             // only increments when ranks are equal
        } 
        count--;
         return true;
    }    
}
