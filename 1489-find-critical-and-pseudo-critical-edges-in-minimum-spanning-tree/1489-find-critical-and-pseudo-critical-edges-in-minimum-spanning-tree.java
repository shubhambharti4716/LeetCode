class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>(2);
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        int m = edges.length;
        int[][] es = new int[m][4];
        for (int i = 0; i < m; i++) {
            es[i][0] = edges[i][0];
            es[i][1] = edges[i][1];
            es[i][2] = edges[i][2];
            es[i][3] = i;
        }
        Arrays.sort(es, (a, b) -> a[2] - b[2]);
        List<List<int[]>> buffer = new ArrayList<>();
        List<int[]> cur = new ArrayList<>();
        cur.add(es[0]);
        for (int i = 1; i < m; ++i) {
            int[] e = es[i];
            if (cur.get(0)[2] < e[2]) {
                buffer.add(cur);
                cur = new ArrayList<>();
            }
            cur.add(e);
        }
        buffer.add(cur);
        UF uf = new UF(n);
        for (List<int[]> slot: buffer) {
            int l = slot.size();
            List<int[]> candidates = new ArrayList<>();
            for (int i = 0; i < l; ++i) {
                int[] e = slot.get(i);
                if (uf.isConnected(e[0], e[1])) {
                    continue;
                }
                candidates.add(e);
            }
            l = candidates.size();
            for (int i = 0; i < l; ++i) {
                UF cp = uf.clone();
                int[] e0 = candidates.get(i);
                for (int j = 0; j < l; ++j) {
                    if (j == i) {
                        continue;
                    }
                    int[] e = candidates.get(j);
                    cp.union(e[0], e[1]);
                }
                if (cp.isConnected(e0[0], e0[1])) {
                    ans.get(1).add(e0[3]);
                } else {
                    ans.get(0).add(e0[3]);
                }
            }
            for (int[] e: candidates) {
                uf.union(e[0], e[1]);
            }
        }
        return ans;
    }

    private static final class UF {

        private UF(int n) {
            this.n = n;
            this.size = n;
            parent = new int[size];
            sz = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                sz[i] = 1;
            }
        }

        private int[] parent;
        private int[] sz;
        private int size;
        private int n;

        @Override
        public UF clone() {
            UF copy = new UF(1);
            copy.size = this.size;
            copy.n = this.n;
            copy.sz = this.sz.clone();
            copy.parent = this.parent.clone();
            return copy;
        }

        private int find(int x) {
            if (x == parent[x]) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        private void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot == yRoot) {
                return;
            }
            if (sz[xRoot] > sz[yRoot]) {
                parent[yRoot] = xRoot;
                sz[xRoot] += sz[yRoot];
            } else {
                parent[xRoot] = yRoot;
                sz[yRoot] += sz[xRoot];
            }
            --size;
        }

        private boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}