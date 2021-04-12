package medium;

public class BeautifulArrangementII {

    public int[] constructArray(int n, int k) {

        int first = 1;
        int last = n;

        int index = 0;
        int[] arr = new int[n];

        while(first<=last){

            if(k%2==0){
                arr[index] = first++;
            }else{
                arr[index] = last--;
            }

            index++;

            if(k>1){
                k--;
            }
        }
        return arr;
    }


}
