class Solution {
    public boolean search(int[] nums, int target) {
        List<Integer>list=new LinkedList<>();
        for(int num:nums){
            list.add(num);
        }
        return list.contains(target);
    }
}