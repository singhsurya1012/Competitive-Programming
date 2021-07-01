package medium;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

    public List<Integer> grayCode(int n) {
        return grayCodeIterative(n);
    }


    public List<Integer> grayCodeIterative(int n){

        List<Integer> result = new ArrayList<>(1<<n);
        result.add(0);

        for(int i=1; i<=n;i++){
            int size = result.size();
            int x = 1<<(i-1);
            for(int j=size-1; j>=0;j--){
                result.add(x+result.get(j));
            }
        }

        return result;
    }

    public void grayCodeRec(int n, List<Integer> ans){

        if(n==0){
            ans.add(0);
            return ;
        }

        grayCodeRec(n-1, ans);

        int size = ans.size();
        int x = 1<<(n-1);
        for(int i=size-1; i>=0;i--){
            ans.add(x + ans.get(i));
        }

    }
}
