class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int correct = nums[i] - 1;
            if(nums[i] != nums[correct]){
                swap(nums, i, correct);
            }else{
                i++;
            }
        }

        List<Integer> l = new ArrayList<>();
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != j+1){
                l.add(nums[j]);
            }
        }
        return l;

    }
    static void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}