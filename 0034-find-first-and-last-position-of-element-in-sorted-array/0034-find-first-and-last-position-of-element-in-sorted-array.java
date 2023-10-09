class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = -1, end = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                start = i;
                break;
            }
        }

        if (start == -1) {
            return new int[]{-1, -1};
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == target) {
                end = i;
                break;
            }
        }

        return new int[]{start, end};
    }
}