class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        if(s.length() != t.length())
            return false;

        int [] tempS = new int[127];
        int [] tempT = new int[127];
        for(int i = 0; i < s.length(); i++){
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            if(tempS[charS] != tempT[charT])
                return false;

            tempS[charS] = i + 1;
            tempT[charT] = i + 1;
        }
        return true;
    }
}