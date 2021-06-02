package medium;

import java.util.*;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {

        Map<Integer, List<String>> map = new HashMap<>();

        map.put(0, Arrays.asList(""));
        map.put(1 , Arrays.asList("()"));

        if(n==1){
            return map.get(1);
        }

        for(int i=2;i<=n;i++){
            List<String> list = new ArrayList<>();

            for(int j=0;j<=i-1; j++){

                int k = i-j-1;

                for(String s: map.get(j)){
                    for(String t: map.get(k)){
                        list.add("("+s+")" + t);
                    }
                }
            }
            map.put(i, list);
        }

        return map.get(n);
    }

    public List<String> generateParenthesisBackTracking(int n){
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> list, StringBuilder sb, int open, int close, int n){

        if(sb.length()==2*n){
            list.add(sb.toString());
            return;
        }

        if(open<n){
            sb.append("(");
            backtrack(list,sb,open+1,close,n);
            sb.deleteCharAt(sb.length()-1);
        }

        if(close<open){
            sb.append(")");
            backtrack(list,sb,open,close+1,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public List<String> generateParenthesisBruteForce(int n){

        List<String> combinations = new ArrayList<>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }


    public void generateAll(char[] c, int pos,List<String> list){

        if(pos==c.length){
            if(valid(c)){
                list.add(new String(c));
            }
        }else{

            c[pos] = '(';
            generateAll(c,pos+1,list);
            c[pos] = ')';
            generateAll(c,pos+1,list);
        }
    }

    public boolean valid(char[] c ){
        int balance = 0;
        for(char curr:c){
            if(curr=='('){
                balance++;
            }else{
                balance--;
            }

            if(balance<0){
                return false;
            }
        }
        return balance==0;
    }

}
