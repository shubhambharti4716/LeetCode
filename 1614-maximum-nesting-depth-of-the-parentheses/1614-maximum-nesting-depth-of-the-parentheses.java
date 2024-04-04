class Solution {
    public int maxDepth(String s) {
        int ans = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
                ans = Math.max(ans, stack.size());
            } else if(s.charAt(i) == ')') {
                stack.pop();
            }
        }
        return ans;
        
    }
}