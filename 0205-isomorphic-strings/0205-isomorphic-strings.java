class Solution {
    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int l = s.length();

        int[] map1 = new int[256];
        int[] map2 = new int[256];

        for (int i = 0; i < l; i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if (map1[ch1]>0) {
                if (map1[ch1] != ch2) {
                    return false;
                } 
            } else {
                if (map2[ch2]==1) {
                    return false;
                } else {
                    map1[ch1]=ch2;
                    map2[ch2]=1;
                }
            }
        }

        return true;
    }
}