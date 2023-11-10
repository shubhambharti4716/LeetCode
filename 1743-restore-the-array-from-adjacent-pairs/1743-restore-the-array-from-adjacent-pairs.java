class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        /* For each number, record its neighbours using a hash map. 
        The number with only one neighbour is the head (or the tail) of the list.
        The number in the middle of the array have two neighbors in the adjacentPairs.
        */

        Map<Integer, List<Integer>> num2Neighbors = new HashMap<>();
        for(int[] adj : adjacentPairs) {
            num2Neighbors.putIfAbsent(adj[0], new ArrayList<>());
            num2Neighbors.putIfAbsent(adj[1], new ArrayList<>());
            num2Neighbors.get(adj[0]).add(adj[1]);
            num2Neighbors.get(adj[1]).add(adj[0]);
        }

        int start = 0;
        for(int num: num2Neighbors.keySet()) {
            if (num2Neighbors.get(num).size() == 1) {
                start = num;
                break;
            }
        }

        int[] resArr = new int[adjacentPairs.length+1]; 
        resArr[0] = start;
        resArr[1] = num2Neighbors.get(start).get(0);
        for(int i=2; i<resArr.length; i++) {
            List<Integer> neighbors = num2Neighbors.get(resArr[i-1]);
            int prevNum = resArr[i-2];
            if (neighbors.get(0) != prevNum) {
                resArr[i] = neighbors.get(0);
            } else {
                resArr[i] = neighbors.get(1);
            }
        }
        return resArr;
    }
}