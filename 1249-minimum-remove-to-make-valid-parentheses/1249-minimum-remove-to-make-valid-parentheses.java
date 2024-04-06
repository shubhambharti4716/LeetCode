class Solution {
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> para = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ')') {
                if (para.size() != 0 && chars[para.getLast()] == '(') {
                    para.removeLast();
                } else {
                    para.add(i);
                }
            } else if (chars[i] == '(') {
                 para.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (para.size() != 0 && para.getFirst() == i) {
                para.pop();
                continue;
            }
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}