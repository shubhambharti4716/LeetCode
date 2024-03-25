class Solution {
    public List<Integer> findDuplicates(int[] nums) {
     List<Integer> res = new ArrayList<Integer>();
     int[]count = new int[nums.length+1];
     for(int freq : nums) 
            count[freq]++;

     for( int i =1 ; i <= nums.length ; i++)
    {
        if(count[i] == 2){
            res.add(i);
        }
     }
     return res;  
    }
}