package easy;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<nums.length;i++){

            //Check if we have already encountered the number
            if(map.containsKey(nums[i])){
                //Check it difference in index
                if(i-map.get(nums[i])<=k)
                    return true;
            }

            //Even if me have seen the number we replace its old index with the latest index
            //Since its distance with latest index will be the smallest
            map.put(nums[i],i);
        }

        return false;
    }
}
