public class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] in_degree = new int[n + 1];
        for (int[] relation : relations) {
            graph.computeIfAbsent(relation[0], k -> new ArrayList<>()).add(relation[1]);
            in_degree[relation[1]]++;
        }

        int[] dist = new int[n + 1];
        System.arraycopy(time, 0, dist, 1, n);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (in_degree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int course = q.poll();
            if (graph.containsKey(course)) {
                for (int next_course : graph.get(course)) {
                    dist[next_course] = Math.max(dist[next_course], dist[course] + time[next_course - 1]);
                    in_degree[next_course]--;
                    if (in_degree[next_course] == 0) {
                        q.add(next_course);
                    }
                }
            }
        }

        int maxVal = 0;
        for (int val : dist) {
            maxVal = Math.max(maxVal, val);
        }
        return maxVal;
    }
}