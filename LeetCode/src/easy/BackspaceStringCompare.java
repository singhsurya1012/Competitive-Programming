package easy;

public class BackspaceStringCompare {

    public boolean backspaceCompare(String s, String t) {

        int i = s.length()-1;
        int j = t.length()-1;

        int skipS = 0;
        int skipT = 0;

        while(i>=0 || j>=0){

            while(i>=0){

                if(s.charAt(i)=='#'){
                    skipS++;
                    i--;
                }else if(skipS>0){
                    skipS--;
                    i--;
                }else{
                    break;
                }
            }


            while(j>=0){
                if(t.charAt(j)=='#'){
                    skipT++;
                    j--;
                }else if(skipT>0){
                    skipT--;
                    j--;
                }else{
                    break;
                }
            }

            if(i>=0 && j>=0 && s.charAt(i)!=t.charAt(j))
                return false;

            if((i>=0) != (j>=0)){
                return false;
            }

            i--; j--;
        }

        return true;

    }

    public boolean backspaceCompareMoreSpace(String s, String t) {

        s = processString(s);
        t = processString(t);

        return s.equals(t);
    }

    public String processString(String s){

        StringBuilder sb = new StringBuilder();

        for(char c: s.toCharArray()){

            if(c=='#'){
                if(sb.length()==0)
                    continue;
                sb.deleteCharAt(sb.length()-1);
            }else{
                sb.append(c);
            }
        }

        return sb.toString();
    }

}
