package medium;

public class CountNumberOfTeams {

    //Time Complexity : O(N^2)
    //Space Complexity : O(1)
    public int numTeams(int[] rating) {

        int teams = 0;

        //Calculating Combinations around the middle element (a,b,c)
        //So possible combination is any a (on the left) which is less than b and any c (on the right) which is greater than b (a<b<c)
        //Or any element which is a (on the left) is greater than b and any c (on the right) which is less than b (a>b>c)
        for (int i = 1; i < rating.length - 1; i++) {

            int currentRating = rating[i];

            int leftGreater = 0;
            int leftSmaller = 0;

            //By traversing left we can calculate number of elements smaller and greater than pivot
            for (int j = i - 1; j >= 0; j--) {

                if (rating[j] > currentRating) {
                    leftGreater++;
                } else {
                    leftSmaller++;
                }

            }

            int rightGreater = 0;
            int rightSmaller = 0;

            //By traversing right we can calculate number of elements smaller and greater than pivot
            for (int j = i + 1; j < rating.length; j++) {

                if (rating[j] > currentRating) {
                    rightGreater++;
                } else {
                    rightSmaller++;
                }
            }

            //increasing combinations (a<b<c) is selecting 1 element from leftSmaller * selecting 1 element from rightGreater
            teams += (leftSmaller * rightGreater);
            //decreasing combinations (a>b>c) is selecting 1 element from leftGreater * selecting 1 element from rightSmaller
            teams += (leftGreater * rightSmaller);

        }

        return teams;
    }
}
