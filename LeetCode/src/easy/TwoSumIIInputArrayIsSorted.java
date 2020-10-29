package easy;

public class TwoSumIIInputArrayIsSorted {

    public int[] twoSum(int[] numbers, int target) {

        int s = 0;
        int e = numbers.length-1;

        //Since the array is sorted, we can use two pointer and move towards the target
        while(s<e){

            int sum = numbers[s]+numbers[e];

            if(sum==target)
                return new int[]{s+1,e+1};
            else if(sum<target)
                s++;
            else
                e--;

        }
        return null;
    }
}
