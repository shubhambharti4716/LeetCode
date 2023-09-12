class Solution {
    public int minDeletions(String s) {
        int[] freqs = new int[26];
        for (char c : s.toCharArray()) {
            freqs[c - 'a']++;
        }
        int deletions = 0;
        Set<Integer> uniqueIntegers = new HashSet();
        for (int freq : freqs) {
            while (freq != 0 && !uniqueIntegers.add(freq)) {
                deletions++;
                freq--;
            }
        }
        return deletions;        
    }
}