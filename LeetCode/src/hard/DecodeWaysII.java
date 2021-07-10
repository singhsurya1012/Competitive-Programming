package hard;

public class DecodeWaysII {

    Long[] dp;
    int M = 1000000007;

    public int numDecodings(String s) {

        int n = s.length();
        dp = new Long[n];

        //return (int) count(s.toCharArray(), n-1);
        return (int) countBottomUp(s.toCharArray());

    }


    public long count(char[] arr, int pos) {

        if (pos < 0)
            return 1;

        if (dp[pos] != null)
            return dp[pos];

        char c = arr[pos];

        if (c == '*') {

            long res = 9 * count(arr, pos - 1) % M;

            if (pos > 0 && arr[pos - 1] == '1') {
                res = (res + 9 * count(arr, pos - 2)) % M;
            } else if (pos > 0 && arr[pos - 1] == '2') {
                res = (res + 6 * count(arr, pos - 2)) % M;
            } else if (pos > 0 && arr[pos - 1] == '*') {
                res = (res + 15 * count(arr, pos - 2)) % M;
            }

            dp[pos] = res;
            return res;
        }

        long res = c != '0' ? count(arr, pos - 1) : 0;

        if (pos > 0 && arr[pos - 1] == '1')
            res = (res + count(arr, pos - 2)) % M;
        else if (pos > 0 && arr[pos - 1] == '2' && c <= '6')
            res = (res + count(arr, pos - 2)) % M;
        else if (pos > 0 && arr[pos - 1] == '*')
            res = (res + (arr[pos] <= '6' ? 2 : 1) * count(arr, pos - 2)) % M;

        dp[pos] = res;
        return res;

    }


    public long countBottomUp(char[] arr) {

        int n = arr.length;

        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = arr[0] == '*' ? 9 : arr[0] == '0' ? 0 : 1;

        for (int i = 1; i < n; i++) {

            if (arr[i] == '*') {

                dp[i + 1] = 9 * dp[i] % M;
                if (arr[i - 1] == '1')
                    dp[i + 1] = (dp[i + 1] + 9 * dp[i - 1]) % M;
                else if (arr[i - 1] == '2')
                    dp[i + 1] = (dp[i + 1] + 6 * dp[i - 1]) % M;
                else if (arr[i - 1] == '*')
                    dp[i + 1] = (dp[i + 1] + 15 * dp[i - 1]) % M;

            } else {

                dp[i + 1] = arr[i] != '0' ? dp[i] : 0;

                if (arr[i - 1] == '1') {
                    dp[i + 1] = (dp[i + 1] + dp[i - 1]) % M;
                } else if (arr[i - 1] == '2' && arr[i] <= '6') {
                    dp[i + 1] = (dp[i + 1] + dp[i - 1]) % M;
                } else if (arr[i - 1] == '*') {
                    dp[i + 1] = (dp[i + 1] + (arr[i] <= '6' ? 2 : 1) * dp[i - 1]) % M;
                }
            }

        }

        return dp[n];
    }
}
