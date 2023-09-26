class Solution {
    public String removeDuplicateLetters(String s) {
        int dp[] = new int[26];
        for (char c : s.toCharArray()) {
            dp[c - 'a']++;
        }
        Stack<Character> stack = new Stack<>();
        boolean visited[] = new boolean[26];
        for (char c : s.toCharArray()) {
            dp[c - 'a']--;

            if (visited[c - 'a']) {
                continue;
            }

            while (!stack.isEmpty() && c < stack.peek()) {
                if (dp[stack.peek() - 'a'] > 0) {
                    visited[stack.pop() - 'a'] = false;
                } else {
                    break;
                }
            }
            visited[c - 'a'] = true;
            stack.push(c);
        }
        StringBuilder str = new StringBuilder();
        for (char c : stack) {
            str.append(c);
        }
        return str.toString();
    }
}