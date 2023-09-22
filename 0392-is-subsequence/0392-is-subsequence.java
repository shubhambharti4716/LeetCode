class Solution {
    public boolean isSubsequence(String s, String t) {
    int c = 0, index = -1;
    for(int i = 0; i<s.length() ;i++) {
            c = 0;
        for(int j = index + 1 ; j<t.length() ;j++) {
              if(s.charAt(i) == t.charAt(j)) {
                   index = j;
                   c = 1;
                   break;
              }
        }
        if(c == 0) {
             return false;
        }
    }   
     return true;
    }
}