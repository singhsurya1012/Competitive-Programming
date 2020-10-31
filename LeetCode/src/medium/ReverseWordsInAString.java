package medium;

import java.util.ArrayList;
import java.util.List;

public class ReverseWordsInAString {

    //Best approach is to reverse the individual words
    //THen reverse the whole string
    public String reverseWords(String s) {

        char[] c = s.toCharArray();

        int start = 0;
        //Reverse Individual words
        for(int end = 0; end<c.length; end++){

            if(c[end]==' '){

                if(start==end){
                    start++;
                }else{
                    reverse(c, start, end-1);
                    start = end+1;
                }
            }

        }

        //Reverse the last word
        reverse(c, start, c.length-1);

        //Reverse the whole string
        reverse(c, 0, c.length-1);

        //Create the string removing extra space
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<c.length; i++){

            if(c[i]!=' '){
                sb.append(c[i]);
            }else if(c[i]==' ' && i>0 && c[i-1]!=' '){
                sb.append(' ');
            }

        }

        if(sb.charAt(sb.length()-1)==' '){
            return sb.substring(0, sb.length()-1);
        }
        return sb.toString();
    }



    //Method to reverse the character array used to reverse string
    public void reverse(char[] c, int start, int end){

        while(start<end){
            char temp = c[start];
            c[start] = c[end];
            c[end] = temp;

            start++;
            end--;
        }
    }


    public String reverseWordsWithExtraSpace(String s) {

        List<String> str = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        //Store each work in a list
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (c != ' ') {
                sb.append(c);
            } else if (sb.length() > 0) {
                str.add(sb.toString());
                sb = new StringBuilder();
            }
        }

        if (sb.length() > 0) {
            str.add(sb.toString());
            sb = new StringBuilder();
        }

        //Append all the words in reverse order
        for (int i = str.size() - 1; i >= 1; i--) {
            sb.append(str.get(i) + " ");
        }

        sb.append(str.get(0));
        return sb.toString();
    }
}
