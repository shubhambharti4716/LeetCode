class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[][] graph = new int[n][n];
        int[] degree = new int[n];

        for(int[] info : roads){
            int u = info[0];
            int v = info[1];

            graph[u][v] = 1;
            graph[v][u] = 1;

            degree[u]++;
            degree[v]++;
        }

        int ans = 0;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int rank = degree[i] + degree[j];
                if(rank<ans) continue;

                if(graph[i][j]==1) rank--;

                ans = Math.max(ans,rank);
            }
        }

        return ans;
    }
}