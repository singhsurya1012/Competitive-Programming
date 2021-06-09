package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Combinations {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {

        if(k <= 0 || n < k){
            return result;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        backtrack(1,n,k,deque);
        return result;
    }

    public void backtrack(int pos, int n, int k, Deque<Integer> deque){

        if(k==0){
            result.add(new ArrayList<>(deque));
            return;
        }

        for(int i=pos; i <= n - k + 1; i++){
            deque.addLast(i);
            backtrack(i+1,n,k-1,deque);
            deque.removeLast();
        }
    }

    //C[n,k] = C[n-1,k] + C[n-1,k-1]*(n added to all combination)
    public List<List<Integer>> combineRec(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (k > n || k < 0) {
            return result;
        }

        if (k == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }

        result = combineRec(n - 1, k - 1);
        for (List<Integer> list : result) {
            list.add(n);
        }
        result.addAll(combineRec(n - 1, k));
        return result;
    }
}
