public class Solution {
    public int numberOfSteps(int num) {
        int steps = 0;

        while (num > 0) {
            if ((num & 1) == 0) {
                num >>= 1; // Right shift by 1 (equivalent to dividing by 2)
            } else {
                num -= 1; // Subtract 1 from odd numbers
            }
            steps++;
        }

        return steps;
    }
}
