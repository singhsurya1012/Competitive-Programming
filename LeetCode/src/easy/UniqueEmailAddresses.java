package easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

    public int numUniqueEmails(String[] emails) {

        Set<String> set = new HashSet<>();

        for(String e: emails){
            addEmail(e,set);
        }

        return set.size();
    }


    public void addEmail(String email, Set<String> set){

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<email.length();i++){
            char c = email.charAt(i);

            if(c=='@'){
                sb.append(email.substring(i));
                break;
            }
            if(c=='+'){
                while(c!='@'){
                    c = email.charAt(++i);
                }
                sb.append(email.substring(i));
                break;
            }else if(c!='.'){
                sb.append(c);
            }
        }

        if (sb.length()>0){
            set.add(sb.toString());
        }
    }

}
