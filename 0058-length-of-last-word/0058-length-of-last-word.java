class Solution {
    public int lengthOfLastWord(String s) {
        String trimmed = s.trim();
        
        String[] words = trimmed.split(" ");
        
        return words[words.length - 1].length();
    }
}