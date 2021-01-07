package medium;

public class BeautifulArrangement {

    int count = 0;

    public int countArrangement(int n) {

        //To keep track of all the values used
        boolean[] used = new boolean[n + 1];
        //Position to be filled
        int i = 1;
        calculate(n, i, used);
        return count;
    }

    public void calculate(int n, int i, boolean[] used) {

        //Check if all the N positions are filled
        if (i > n) {
            count++;
            return;
        }

        //Iterate for all possible values
        for (int val = 1; val <= n; val++) {

            //If current value is not used and is a valid values
            if (!used[val] && (val % i == 0 || i % val == 0)) {
                //mark it as used and try to fill the next position
                used[val] = true;
                calculate(n, i + 1, used);

                //unmark the value and try to fill it with the next possible value
                used[val] = false;
            }
        }
    }
}
