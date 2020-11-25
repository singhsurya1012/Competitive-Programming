package easy;

public class FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {


        int l = 0;
        int r = letters.length;

        while(l<r){

            int m = l + (r-l)/2;

            //If letter is smaller or equal me move to the left since we need to find the first largest target
            if(letters[m] <= target){
                l = m+1;
            }else{
                r = m;
            }
        }

        if(l==letters.length){
            return letters[0];
        }else{
            return letters[l];
        }
    }
}
