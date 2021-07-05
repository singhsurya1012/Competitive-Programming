package medium;

import java.util.Stack;

public class RemoveKDigits {


    public String removeKdigits(String num, int k) {

        int n = num.length();

        if (k >= n)
            return "0";

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            //Remove peeks
            while (!stack.isEmpty() && k > 0 && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }


        //Check if we have remove required k digits
        while (k > 0) {
            stack.pop();
            k--;
        }


        //Construct new num
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();

        //remove leading zeros
        int i = 0;
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.toString();

    }

}
