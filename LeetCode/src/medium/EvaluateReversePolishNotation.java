package medium;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation {

    //Time Complexity : O(N)
    //Space Complexity : O(N)
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");


        //We will push all the numbers in stack
        //When we encounter a operator we will take the two top values and calculate and push it to stack
        for (String s : tokens) {

            if (operators.contains(s)) {

                int b = stack.pop();
                int a = stack.pop();
                int value = operate(a, b, s);
                stack.push(value);

            } else {
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.peek();
    }


    public int operate(int a, int b, String operator) {

        switch (operator) {
            case "+":
                return a + b;

            case "-":
                return a - b;

            case "*":
                return a * b;

            case "/":
                return a / b;

            default:
                return 0;
        }
    }


}
