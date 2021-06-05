package easy;

import java.util.Collections;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {

        if(s.length()==0){
            return true;
        }

        if(s.length()>t.length())
            return false;

        int index = 0;
        for(char c: t.toCharArray()){

            if(c==s.charAt(index))
                index++;

            if(index==s.length())
                return true;
        }

        return false;
    }
}
