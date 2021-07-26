package easy;

public class ValidPalindromeII {

    public boolean validPalindrome(String s) {

        char[] c = s.toCharArray();

        return validPalindrome(c,0, c.length-1, false);
    }

    public boolean validPalindrome(char[] c, int start, int end, boolean deleted){

        if(start==end || start>end){
            return true;
        }

        if(c[start]==c[end]){
            return validPalindrome(c,start+1,end-1, deleted);
        }

        if(deleted){
            return false;
        }
        deleted = !deleted;

        return validPalindrome(c,start+1,end,deleted) || validPalindrome(c,start,end-1,deleted);

    }
}
