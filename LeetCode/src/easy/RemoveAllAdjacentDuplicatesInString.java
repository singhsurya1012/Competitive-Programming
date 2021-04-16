package easy;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {

    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            int size = sb.length();
            if (size > 0 && sb.charAt(size - 1) == c) {
                sb.deleteCharAt(size - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String removeDuplicatesStack(String s) {

        int n =s.length();
        char[] c = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        for(int i=n-1; i>=0;i--){

            if(stack.isEmpty() || stack.peek()!=c[i]){
                stack.push(c[i]);
            }else{
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.toString();

    }
}
