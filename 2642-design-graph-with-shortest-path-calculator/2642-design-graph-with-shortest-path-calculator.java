class Graph {

    int[][] adj;
    int n;
    public Graph(int n, int[][] edges) {
        adj = new int[n][n];
        this.n = n;
        for(int[] a: adj) {
            Arrays.fill(a, (int)1e9);
        }

        for(int[] e: edges) {
            adj[e[0]][e[1]] = e[2];
        }

        for(int i = 0; i < n; i++) {
            adj[i][i] = 0;
        }

        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
                }
            }
        }
    }
    
    public void addEdge(int[] e) {
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                adj[i][j] = Math.min(adj[i][j], adj[i][e[0]] + adj[e[1]][j] + e[2]);
            }
        }
    }
    
    public int shortestPath(int node1, int node2) {
        
        if(adj[node1][node2] >= (int)1e9) return -1;
        return adj[node1][node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */