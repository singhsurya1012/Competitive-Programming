package easy;

public class ShortestDistanceToACharacter {

    public static int[] shortestToCharClean(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];

        int prev = -n;

        for(int i=0; i<n;i++){

            if(s.charAt(i)==c)
                prev = i;
            ans[i] = i-prev;
        }

        //Since prev will be pointing to last character c
        for(int i=prev-1;i>=0;i--){

            if(s.charAt(i)==c)
                prev = i;
            ans[i] = Math.min(ans[i], prev - i);
        }
        return ans;

    }

    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] arr = new int[n];

        int last = s.indexOf(c);
        //starting
        for (int i = last - 1; i >= 0; i--) {
            arr[i] = arr[i + 1] + 1;
        }

        int i = last;
        for (int j = last + 1; j < n; j++) {

            if (s.charAt(j) == c) {

                arr[i] = 0;

                int mid = j - i - 1;
                i++;
                for (int k = 1; k <= mid / 2; k++) {
                    arr[i] = k;
                    i++;
                }

                if (mid % 2 == 1) {
                    arr[i] = arr[i - 1] + 1;
                    i++;
                }

                for (int k = mid/2; k >=1; k--) {
                    arr[i] = k;
                    i++;
                }
                i = j;
            }
        }

        arr[i] = 0;
        i++;
        while (i < n) {
            arr[i] = arr[i - 1] + 1;
            i++;
        }

        return arr;
    }
}
