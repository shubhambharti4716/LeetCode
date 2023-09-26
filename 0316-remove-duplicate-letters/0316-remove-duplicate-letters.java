class Solution {
    public String removeDuplicateLetters(String s) {
        boolean[] vis = new boolean[26];
        StringBuilder sb = new StringBuilder();
        int count[] = new int[26];

        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                count[c - 'a']++;
            }
        }

        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                count[c - 'a']--;
                if (vis[c - 'a']) continue;

                while (sb.length() > 0 && c < sb.charAt(sb.length() - 1) && count[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                    vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                    sb.deleteCharAt(sb.length() - 1);
                }
                vis[c - 'a'] = true;
                sb.append(c);
            }
        }
        return sb.toString();
    }
}