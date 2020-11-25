package easy;

public class Sqrtx {

    public int mySqrt(int x) {

        if (x <= 1) {
            return x;
        }
        //Any square root cannot be greater than its half
        int min = 1;
        int max = x / 2;

        while (min <= max) {

            int mid = min + (max - min) / 2;
            //To prevent overflow since mid*mid can be greater than max value
            int q = x / mid;

            if (q == mid) {
                return mid;
            } else if (q > mid) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        return max;

    }
}
