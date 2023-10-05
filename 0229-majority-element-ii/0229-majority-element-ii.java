

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Integer candidate1 = null, candidate2 = null;
        int count1 = 0, count2 = 0;
        for (int num : nums) {
            if (candidate1 != null && num == candidate1.intValue()) {
                count1++;
            } else if (candidate2 != null && num == candidate2.intValue()) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (candidate1 != null && num == candidate1.intValue()) {
                count1++;
            } 
            if (candidate2 != null && num == candidate2.intValue()) {
                count2++;
            }
        }

        List<Integer> result = new ArrayList<>();
        if (count1 > nums.length / 3) result.add(candidate1);
        if (count2 > nums.length / 3) result.add(candidate2);
        return result;
    }
}