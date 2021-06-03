package medium;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

    public List<Integer> partitionLabels(String s) {

        int[] lastOccurrance = new int[26];

        for(int i=0; i<s.length();i++){
            lastOccurrance[s.charAt(i) - 'a'] = i;
        }


        List<Integer> parts = new ArrayList<>();
        int start = 0;
        int last = 0;
        for(int i=0;i<s.length();i++){

            int l = lastOccurrance[s.charAt(i)-'a'];
            last=Math.max(last,l);

            if(last==i){
                parts.add(last-start+1);
                start = i+1;
                last = i+1;
            }
        }

        return parts;
    }
}
