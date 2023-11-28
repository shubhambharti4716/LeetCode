class Solution {
    public int numberOfWays(String corridor) {
       int MOD = 1_000_000_007;
        int n = corridor.length();
        int[][] count = new int[n + 1][3];

        // Fill base cases
        count[n][0] = 0;
        count[n][1] = 0;
        count[n][2] = 1;

        // Fill the array in a bottom-up fashion
        for (int index = n - 1; index >= 0; index--) {
            if (corridor.charAt(index) == 'S') {
                count[index][0] = count[index + 1][1];
                count[index][1] = count[index + 1][2];
                count[index][2] = count[index + 1][1];
            } else { // if corridor[index] is 'P'
                count[index][0] = count[index + 1][0];
                count[index][1] = count[index + 1][1];
                count[index][2] = (count[index + 1][0] + count[index + 1][2]) % MOD;
            }
        }

        return count[0][0];
    }
}