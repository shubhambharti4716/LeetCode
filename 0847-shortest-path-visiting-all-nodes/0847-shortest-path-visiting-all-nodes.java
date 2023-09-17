class Pair{
    int first;
    int second;

    Pair(int first,int second){
        this.first= first;
        this.second= second;
    }
}

class Solution {
    public int shortestPathLength(int[][] graph) {
        int finalState = (1 << graph.length) -1;
        boolean[][] visited = new boolean[graph.length][finalState+1];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            q.add(new Pair(i, 1<< i));
        }
        int ans =0;
        while(!q.isEmpty()){
            ans++;
            int size = q.size();
            while(size-- >0){
                 Pair p  = q.poll();
                int node = p.first;
                int nodeMask = p.second;

                for(int x: graph[node]){
                    int newNodeMask =nodeMask| (1 << x) ; 
                    if(visited[x][newNodeMask]){
                        continue;
                    }
                    
                    if(newNodeMask == finalState){
                        return ans;
                    }

                    visited[x][newNodeMask] = true;
                    q.add(new Pair(x,newNodeMask));
                }
            }
           
        }

        return 0;
    }
}