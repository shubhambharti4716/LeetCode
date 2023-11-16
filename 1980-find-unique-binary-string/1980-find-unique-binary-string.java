class Solution {
    public String findDifferentBinaryString(String[] nums) {
        HashSet<Integer> seen = new HashSet<>();

        for (String binaryString : nums) {
            seen.add(Integer.parseInt(binaryString, 2));
        }

        int n = nums[0].length();

        for (int i = 0; i <= n; i++) {
            if (!seen.contains(i)) {
                StringBuilder binaryStringBuilder = new StringBuilder(Integer.toBinaryString(i));
                while (binaryStringBuilder.length() < n) {
                    binaryStringBuilder.insert(0, '0');
                }
                return binaryStringBuilder.toString();
            }
        }

        return ""; 
    }
}