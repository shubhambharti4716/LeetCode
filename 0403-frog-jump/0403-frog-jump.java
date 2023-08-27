class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        return helper(stones, 0, 0, new Boolean[n + 1][n + 1]);
    }

    private boolean helper(int[] stones, int index, int prevJump, Boolean[][] memo) {
        if(index == stones.length - 1) return true;

        if(memo[index][prevJump] != null) return memo[index][prevJump];

        int max = stones[index] + prevJump + 1;
        for(int next = index + 1; next < stones.length && stones[next] <= max; next++) {
            if(stones[next] == stones[index] + prevJump - 1) {
                if(helper(stones, next, prevJump - 1, memo)) return true;
            }

            if(stones[next] == stones[index] + prevJump) {
                if(helper(stones, next, prevJump, memo)) return true;
            }

            if(stones[next] == max) {
                if(helper(stones, next, prevJump + 1, memo)) return true;
            }
        }

        return memo[index][prevJump] = false;
    }
}