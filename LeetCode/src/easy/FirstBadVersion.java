package easy;

public class FirstBadVersion {

    public int firstBadVersion(int n) {

        int l = 0;
        int r = n;

        while (l < r) {

            int m = l + (r - l) / 2;

            if (isBadVersion(m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    //Dummy Implementation
    boolean isBadVersion(int version){
        return true;
    }
}
