package hard;

import java.util.Arrays;

public class Candy {

    public int candy(int[] ratings) {
        int n=ratings.length;
        int[] arr = new int[n];
        Arrays.fill(arr,1);

        //left
        for(int i=1; i<n;i++){

            if(ratings[i]>ratings[i-1])
                arr[i] = Math.max(arr[i], arr[i-1]+1);

        }

        //right
        for(int i=n-2; i>=0;i--){

            if(ratings[i]>ratings[i+1])
                arr[i] = Math.max(arr[i], arr[i+1]+1);

        }

        return  Arrays.stream(arr).sum();
    }

    public int candyOptimised(int[] ratings) {

        int ans = 1;
        int up = 0;
        int down = 0;
        int peak = 0;

        for(int i=1; i<ratings.length;i++){

            if(ratings[i]>ratings[i-1]){
                up++;
                down=0;
                peak = up;
                ans+= 1 + up;
            }else if(ratings[i]==ratings[i-1]){
                peak = up = down = 0;
                ans++;
            }else{
                up=0;
                down++;
                ans += 1 + down + (peak>=down?-1:0);
            }
        }

        return ans;
    }
}
