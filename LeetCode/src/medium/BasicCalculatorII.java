package medium;

import java.util.Stack;

public class BasicCalculatorII {

    public int calculateClean(String s) {

        if (s == null || s.isEmpty())
            return 0;
        int n = s.length();

        Stack<Integer> stack = new Stack<Integer>();
        int currentNumber = 0;
        char operation = '+';

        for(int i=0; i<n; i++){

            char c = s.charAt(i);

            if(Character.isDigit(c)){
                currentNumber = currentNumber*10 + (c-'0');
            }

            if(!Character.isDigit(c) && !Character.isWhitespace(c)
                    || i==n-1){

                if (operation == '-') {
                    stack.push(-currentNumber);
                }
                else if (operation == '+') {
                    stack.push(currentNumber);
                }
                else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                }
                else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }
                operation = c;
                currentNumber = 0;
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }


    public int calculate(String s) {

        Stack<String> stack = new Stack<>();

        char[] c = s.toCharArray();
        int index = 0;
        int n = c.length;

        while(index<n){

            if(c[index]==' '){
                index++;
                continue;
            }

            if(c[index]=='+' || c[index]=='-' || c[index]=='*' || c[index]=='/'){
                stack.push(""+c[index]);
                index++;
            }else{

                StringBuilder sb =new StringBuilder();

                while(index<n && Character.isDigit(c[index])){
                    sb.append(c[index++]);
                }

                String num2 = sb.toString();
                while(!stack.isEmpty() && (stack.peek().equals("*") || stack.peek().equals("/"))){
                    String operator = stack.pop();
                    String num1 = stack.pop();
                    String result = calculate(num1,num2,operator);
                    num2= result;
                }
                stack.push(num2);
            }
        }

        String num2 = null;
        stack = reverse(stack);
        if(!stack.isEmpty()){
            num2 = stack.pop();
        }
        while(!stack.isEmpty()){
            String operator = stack.pop();
            String num1 = stack.pop();
            String result = calculate(num1,num2,operator);
            num2= result;
        }

        return Integer.parseInt(num2);
    }

    private Stack<String> reverse(Stack<String> stack) {
        Stack<String> s = new Stack<>();
        while(!stack.isEmpty()){
            s.push(stack.pop());
        }
        return s;
    }


    public String calculate(String n1, String n2, String operator){

        Long a = Long.parseLong(n1);
        Long b = Long.parseLong(n2);

        if(operator.equals("+")){
            a = a+ b;
            return Long.toString(a);
        }else if(operator.equals("-")){
            a = a - b;
            return Long.toString(a);
        }else if(operator.equals("*")){
            a = a * b;
            return Long.toString(a);
        }else{
            a = a / b;
            return Long.toString(a);
        }
    }
}
