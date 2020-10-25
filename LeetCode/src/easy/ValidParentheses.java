package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    //Time Complexity : O(N)
    //Space Complexity : O(N)
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        Map<Character, Character> mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            //Push the opening brackets to stack
            if (mappings.containsKey(c)) {


                if (stack.isEmpty()) {
                    return false;
                }

                //Whenever we encounter a closing bracket its opening should be at the top
                char top = stack.pop();
                if (top != mappings.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
