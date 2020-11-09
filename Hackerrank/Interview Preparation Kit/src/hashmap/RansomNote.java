package hashmap;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    static void checkMagazine(String[] magazine, String[] note) {

        Map<String,Integer> map = new HashMap<>();
        //Count each word in magazine
        for(String s: magazine){
            map.put(s,map.getOrDefault(s,0)+1);
        }

        for(String s: note){
            //Check if word contains in magazine and decrease its count since its used
            if(map.containsKey(s) && map.get(s)!=0){
                map.put(s, map.get(s)-1);
            }else {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }
}
