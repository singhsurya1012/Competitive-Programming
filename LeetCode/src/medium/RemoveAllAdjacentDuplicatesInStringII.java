package medium;

public class RemoveAllAdjacentDuplicatesInStringII {

    public String removeDuplicates(String s, int k) {

        int n = s.length();
        char[] res = s.toCharArray();
        int[] count = new int[n];
        int i= 0;

        for(int j=0; j<n;j++){

            res[i]=res[j];

            if(i==0 || res[i]!=res[i-1]){
                count[i] = 1;
            }else if(res[i]==res[i-1]){

                count[i] = count[i-1]+1;
                if(count[i]==k){
                    i = i-k;
                }
            }
            i++;
        }

        return new String(res,0,i);

    }
}
