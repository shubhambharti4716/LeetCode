class Solution {
    public int bestClosingTime(String customers) {
        int j = -1, score = 0, maxScore = 0;
        char[] a = customers.toCharArray();
        for (int i = 0; i < a.length; i++) {
            score += a[i] == 'Y'? 1 : -1;
            if (score > maxScore) {
                j = i;
                maxScore = score;
            }
        }
        return j + 1;
    }
}