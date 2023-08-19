class Solution {
    class UnionFind{
        int[] root;
        int[] size;
        UnionFind(int n){
            root = new int[n];
            for(int i=0;i<n;i++)
                root[i] = i;
            size = new int[n];
            Arrays.fill(size, 1);
        }

        int find(int x){
            while(root[x] != x){
                x = root[root[x]];
            }
            return x;
        }

        boolean merge(int x, int y){
            int rx = find(x);
            int ry = find(y);
            if(rx == ry)
                return false;
            if(size[rx]>size[ry]){
                root[ry] = rx;
                size[rx]+=size[ry];
            }else{
                root[rx]=ry;
                size[ry] += size[rx];
            }
            return true;
        }
    }
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<List<Integer> > ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());

        for(int i=0;i<edges.length;i++){
            edges[i] = new int[]{edges[i][0], edges[i][1], edges[i][2], i};
        }

        Arrays.sort(edges, (a,b)->a[2]-b[2]);

        int min = minCost(edges, n, -1, -1);
        // System.out.println("min="+min);

        // for(int[] e:edges)
            // System.out.println(Arrays.toString(e));

        for(int i=0;i<edges.length;i++){
            int m1 = minCost(edges, n, i, -1);
            // System.out.printf("exclude:%s, %d", Arrays.toString(edges[i]), m1);
            if(m1>min){
                ans.get(0).add(edges[i][3]);
            }else{
                int m2 = minCost(edges, n, -1, i);
                // System.out.printf("include:%s, %d", Arrays.toString(edges[i]), m2);
                if(m2==min){
                    ans.get(1).add(edges[i][3]);
                }
            }
        }

        return ans;

    }

    int minCost(int[][] edges, int n, int exclude, int mustInclude){
        UnionFind uf = new UnionFind(n);
        int cnt = 0;
        int sum = 0;
        if(mustInclude>=0){
            uf.merge(edges[mustInclude][0], edges[mustInclude][1]);
            sum += edges[mustInclude][2];
            cnt++;
        }

        for(int i=0;i<edges.length;i++){
            if(i==exclude  || i == mustInclude)
                continue;
            int[] e = edges[i];
            int u = e[0];
            int v = e[1];
            int c = e[2];
            if(uf.merge(u, v)){
                cnt++;
                sum+=c;
            }
            if(cnt == n-1)
                return sum;
        }
        // it is possible not compose a connect tree, so it is showing it is critical path if removed.
        return cnt==n-1?sum:Integer.MAX_VALUE;
    }
}