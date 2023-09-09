class Solution {
    public int combinationSum4(int[] nums, int target) {
        return findAll(target, nums, new HashMap<>());
    }
    
     public int findAll(int target, int[] candidates, HashMap<Integer, Integer> map) {
        if(target == 0) {
            return 1;
        }

        if(map.containsKey(target))
            return map.get(target);

        int sum = 0;
        for(int i=0; i<candidates.length; i++) {
            if(target < candidates[i])
                continue;
            sum += findAll(target-candidates[i], candidates, map);
        }

        map.put(target, sum);

        return sum;
    }
}