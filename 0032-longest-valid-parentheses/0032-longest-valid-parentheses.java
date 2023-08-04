class Solution {
    public int longestValidParentheses(String s) {
    int leftCount = 0;
    int rightCount = 0;
    int maxLength = 0;
    
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '(') {
            leftCount++;
        } else {
            rightCount++;
        }
        
        if (leftCount == rightCount) {
            maxLength = Math.max(maxLength, 2 * rightCount);
        } else if (rightCount > leftCount) {
            leftCount = rightCount = 0;
        }
    }
    
    leftCount = rightCount = 0;
    
    for (int i = s.length() - 1; i >= 0; i--) {
        if (s.charAt(i) == '(') {
            leftCount++;
        } else {
            rightCount++;
        }
        
        if (leftCount == rightCount) {
            maxLength = Math.max(maxLength, 2 * leftCount);
        } else if (leftCount > rightCount) {
            leftCount = rightCount = 0;
        }
    }
    
    return maxLength;
    }
}