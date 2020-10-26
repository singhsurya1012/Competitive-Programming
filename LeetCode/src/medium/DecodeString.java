package medium;

import java.util.Stack;

public class DecodeString {


    public String decodeString(String s) {

        Stack<Character> stack = new Stack<>();

        //Add all the characters to stack till we see a closing bracket
        for(int i =0; i<s.length(); i++) {
            char c = s.charAt(i);

            //When we see a closing bracket
            if(c==']') {

                //Pop the string which needs to to repeated which ends before opening bracket
                StringBuilder sb = new StringBuilder();
                while(!stack.isEmpty() && stack.peek()!='[') {
                    sb.append(stack.pop());
                }

                //Removing  the opening bracket
                stack.pop();
                //Reverse the string which is to be repeated
                sb.reverse();

                //Pop the number of times the string needs to be repeated
                StringBuilder num = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    num.append(stack.pop());
                }

                num.reverse();
                //Decode the string
                String decodedString = decode(num.toString(),sb.toString());
                //Add it to the stack again
                pushOnStack(decodedString, stack);

            }else {
                stack.push(c);
            }
        }

        //Convert the stack to string
        return stackToString(stack);

    }

    private String stackToString(Stack<Character> stack) {

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    private void pushOnStack(String decodedString , Stack stack) {
        for(char c: decodedString.toCharArray()) {
            stack.push(c);
        }
    }

    private String decode(String num, String string) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<=Integer.parseInt(num); i++) {
            sb.append(string);
        }

        return sb.toString();
    }
}
