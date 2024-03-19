class Solution {
         public int leastInterval(char[] tasks, int n) {
            if (n == 0) {
                return tasks.length;
            }
            int[] f = new int[26];
            for (char c : tasks) {
                f[c - 'A']++;
            }
            int max = 0;
            int count = 0;
            for (int i : f) {
                if (i > max) {
                    max = i;
                    count = 1;
                } else if (i == max) {
                    count++;
                }

            }
            return Math.max(tasks.length, (max - 1) * (n + 1) + count);
            // (max-1)*n su pauze između + max sami taskovi -1 + count (ako je count 1,
            // -1+1=0)
        }
    }