class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1);
    }

    private int helper(int nums[], int k) {
        if (k == 0) {
            return 0;
        } else {
            int count[] = new int[nums.length + 1];
            int windowStart = 0, windowEnd = 0, res = 0;
            int currCount = 0;

            while (windowEnd != nums.length) {
                int curr = nums[windowEnd++];
                
                if (count[curr] == 0) {
                    currCount++;
                }
                count[curr]++;

                while (currCount > k) {
                    if (--count[nums[windowStart++]] == 0) {
                        currCount--;
                    }
                }

                res += windowEnd - windowStart;
            }

            return res;
        }
    }
}