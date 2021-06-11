package easy;

public class CountPrimes {

    public int countPrimes(int n) {

        boolean[] num = new boolean[n];

        if(n<=2){
            return 0;
        }



        for(int i=2; i<Math.sqrt(n);i++){

            if(num[i]==false){
                for(int j = i*i; j<n; j+=i){
                    num[j] = true;
                }
            }
        }

        int count = 0;
        for(int i=2;i<n;i++){
            if(num[i]==false)
                count++;
        }

        return count;
    }
}
