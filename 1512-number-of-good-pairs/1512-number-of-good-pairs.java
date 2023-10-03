class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int result = 0;

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
            result += count.get(num) - 1;
        }

        return result;
    }
}