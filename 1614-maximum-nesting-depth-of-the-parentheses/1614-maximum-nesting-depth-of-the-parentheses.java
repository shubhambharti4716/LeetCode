class Solution {
    public int maxDepth(String s) {
            int ans=0;
            int temp=0;
            for
            (char i:s.toCharArray()){
                if(i=='('){
                    temp++;
                }
                if(i==')'){
                    temp--;
                }
                ans=temp>ans?temp:ans;
            }
            return ans;
    }
}