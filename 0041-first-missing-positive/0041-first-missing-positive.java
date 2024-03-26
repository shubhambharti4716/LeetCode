class Solution {
    public int firstMissingPositive(int[] nums) {
             int n = nums.length;
        boolean contains1 = false;

        // Replace negative numbers, zeros,
        // and numbers larger than n with 1s.
        // After this nums contains only positive numbers.
        for (int i = 0; i < n; i++) {
            // Check whether 1 is in the original array
            if (nums[i] == 1) {
                contains1 = true;
            }
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }      
        }

        if (!contains1) return 1;

        // Mark whether integers 1 to n are in nums
        // Use index as a hash key and negative sign as a presence detector.
        for (int i = 0; i < n; i++) {
            int value = Math.abs(nums[i]);
            if (value == n) {
                nums[0] = - Math.abs(nums[0]);
            } else {
                nums[value] = - Math.abs(nums[value]);
            }       
        }

        // First positive in nums is smallest missing positive integer
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0)
                return i;
        }

        // nums[0] stores whether n is in nums
        if (nums[0] > 0){
            return n;
        }
            
        // If nums contains all elements 1 to n
        // the smallest missing positive number is n + 1
        return n + 1;
    }
}