class Solution {
    public int lengthOfLastWord(String s) {
        var len = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            var symbol = s.charAt(i);
            if(symbol != ' ') {
                len ++;
            }
            if(len != 0 && symbol == ' '){
                break;
            }
        }
        return len;
    }
}