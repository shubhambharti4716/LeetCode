class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int length = 0, i = 0, j = 0, n = nums.length;
        while (j < n) {
            m.put(nums[j], m.getOrDefault(nums[j], 0) + 1);
            while (m.get(nums[j]) > k) {
                m.put(nums[i], m.get(nums[i]) - 1);
                i++;
            }
            length = Math.max(length, j - i + 1);
            j++;
        }
        return length;
    }
}