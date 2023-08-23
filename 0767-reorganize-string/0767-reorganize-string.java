class Solution {
    public String reorganizeString(String s) {
        int[] charCount = new int[26];
        
        
        for (char each : s.toCharArray()) {
            charCount[each-'a']++;
        }
        
        int max = 0;
        char maxC = 'a';
        int total = 0;
        for (int i=0; i<charCount.length; i++) {
            total += charCount[i];
            if (charCount[i] > max) {
                max = charCount[i];
                maxC = (char)(i+'a');
            }
        }
        
        if (total-max < max-1) return "";
        
        
        char[] res = new char[s.length()];
        int idx = 0;
        while (charCount[maxC-'a'] > 0) {
            res[idx] = maxC;
            idx += 2;
            charCount[maxC-'a']--;
        }
        for (int i = 0; i < charCount.length; i++) {
            while (charCount[i] > 0) {
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                charCount[i]--;
            }
        }
        return String.valueOf(res);
    }
}