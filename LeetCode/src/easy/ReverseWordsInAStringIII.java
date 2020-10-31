package easy;

public class ReverseWordsInAStringIII {

    public String reverseWords(String s) {

        char[] c = s.toCharArray();

        int start = 0;
        for(int end = 0; end<c.length ; end++ ){

            //Check the occurrence of space and reverse the word before the space
            if(c[end]==' '){
                reverse(c, start, end-1);
                start = end+1;
            }
        }

        reverse(c, start, c.length-1);

        return new String(c);

    }

    public void reverse(char[] c , int start, int end){

        while(start<end){
            char temp = c[start];
            c[start] = c[end];
            c[end] = temp;

            start++;
            end--;
        }
    }
}
