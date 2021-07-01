package medium;

public class DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {

        return deleteAndEarnDp(nums);


    }


    public int deleteAndEarnTwoWay(int[] nums){


        int[] count = new int[10001];
        for (int x: nums) count[x]++;

        int avoid = 0, using = 0, prev = -1;

        for(int i=1;i<=10000;i++){

            if(count[i]==0)
                continue;

            int m = Math.max(avoid,using);

            if(i-1!=prev){
                using = i*count[i] + m;
                avoid = m;
            }else{
                using = i*count[i] + avoid;
                avoid = m;
            }

            prev = i;
        }

        return Math.max(using,avoid);

    }

    public int deleteAndEarnDp(int[] nums){

        int[] count = new int[10001];
        for (int x: nums) count[x]+=x;

        int nextToNext = count[10000];
        int next = Math.max(nextToNext, count[10000-1]);

        for(int i=10000-2; i>=1;i--){

            int score = Math.max(count[i]+ nextToNext, next);

            nextToNext = next;
            next = score;
        }
        return next;
    }
}
