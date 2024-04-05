class Solution {
    public String makeGood(String s) {

        Stack<Character> stack = new Stack();

        for (char ch : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(ch);
                continue;
            }

            if ((Character.isUpperCase(ch) && Character.isLowerCase(stack.peek())
                    && Character.toUpperCase(stack.peek()) == ch) ||
                    Character.isUpperCase(stack.peek()) && Character.isLowerCase(ch)
                            && Character.toUpperCase(ch) == stack.peek()) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }
        return sb.toString();

    }
}