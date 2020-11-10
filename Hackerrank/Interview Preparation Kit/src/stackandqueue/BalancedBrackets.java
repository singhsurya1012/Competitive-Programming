package stackandqueue;

import java.util.Stack;

public class BalancedBrackets {

    static String isBalanced(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {

                if (stack.isEmpty()) {
                    return "NO";
                }
                char top = stack.pop();

                if (top == '(' && c != ')') {
                    return "NO";
                } else if (top == '{' && c != '}') {
                    return "NO";
                } else if (top == '[' && c != ']') {
                    return "NO";
                }

            }
        }

        if (stack.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
