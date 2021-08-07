package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LargestNumber {

    public String largestNumber(int[] nums) {

        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }

        Collections.sort(list, (a,b) -> {

            String x = a+b;
            String y = b+a;

            int c = x.compareTo(y);

            if(c==0){
                return 0;
            }else if(c>0){
                return -1;
            }else{
                return 1;
            }
        });

        if(list.get(0).equals("0")){
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for(String s: list){
            sb.append(s);
        }

        return sb.toString();
    }
}
