package hard;

public class PatchingArray {

    public int minPatches(int[] nums, int n) {

        long sum = 0;
        int patches = 0;
        int i = 0;

        while(sum<n){

            if(i<nums.length && sum+1>=nums[i]){
                sum+=nums[i++];
            }else{
                patches++;
                sum+=(sum+1);
            }

        }

        return patches;

    }
}
