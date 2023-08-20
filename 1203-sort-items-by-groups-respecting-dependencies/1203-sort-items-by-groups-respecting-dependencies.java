class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        // build graph, group is treated as extra node
        List<Integer>[] graph = new ArrayList[n+m];
        int[] indegree = new int[n+m];

        for(int i = 0; i < n+m; ++i) graph[i] = new ArrayList<>();
        
        for(int i = 0; i < group.length; ++i) {
            if(group[i] == -1) continue;
            graph[n+group[i]].add(i);
            indegree[i]++;
        }

        for(int i = 0; i < beforeItems.size(); ++i) {
            for(int item : beforeItems.get(i)) {
                int repBeforeGroup = group[item] == -1 ? item : n+group[item];
                int repCurrentGroup = group[i] == -1 ? i : n+group[i];

                if(repBeforeGroup == repCurrentGroup){
                    graph[item].add(i);
                    indegree[i]++;
                }else{
                    graph[repBeforeGroup].add(repCurrentGroup);
                    indegree[repCurrentGroup]++;
                }
            }
        }
        
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n+m; ++i){
            //System.out.println(indegree[i]);
            if(indegree[i] == 0) dfs(graph, indegree, i, n, res);
        }

        return res.size() == n ? res.stream().mapToInt(i -> i).toArray() : new int[]{};
    }

    private void dfs(List<Integer>[] graph, int[] indegree, int cur, int n, List<Integer> res) {
        if(cur < n) res.add(cur);
        //System.out.println(cur);
        indegree[cur]--;

        for(int child : graph[cur]) {
            if(--indegree[child] == 0) dfs(graph, indegree, child, n, res);
        }
    }
}