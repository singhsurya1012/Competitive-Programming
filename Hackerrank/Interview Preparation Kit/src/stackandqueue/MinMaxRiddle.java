package stackandqueue;

import java.util.Stack;

public class MinMaxRiddle {

    static long[] riddle(long[] arr) {

        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        //Filling the right smaller array
        for(int i=0; i< n;) {

            if(stack.isEmpty() || arr[i]>=arr[stack.peek()]){
                stack.push(i);
                i++;
            }else{
                int prev = stack.pop();
                right[prev] = i;
            }
        }

        while(!stack.isEmpty()){
            int prev = stack.pop();
            right[prev] = n;
        }

        //Filling the left array
        for(int i=n-1; i>=0;){

            if(stack.isEmpty() || arr[i]>=arr[stack.peek()]){
                stack.push(i);
                i--;
            }else {
                int prev = stack.pop();
                left[prev] = i;
            }
        }


        while(!stack.isEmpty()){
            int prev = stack.pop();
            left[prev] = -1;
        }


        long[] ans = new long[n];

        for(int i=0; i< n;i++){

            int len = right[i] - left[i] - 1;
            ans[len-1] = Math.max(ans[len-1], arr[i]);
        }

        for(int i=n-2; i>=0;i--){
            ans[i] = Math.max(ans[i], ans[i+1]);
        }

        return ans;
    }

}
