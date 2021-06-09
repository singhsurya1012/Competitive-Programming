package easy;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FizzBuzz {

    public List<String> fizzBuzz(int n) {

        Map<Integer, String> map = new LinkedHashMap<Integer, String>();
        map.put(3,"Fizz");
        map.put(5,"Buzz");

        List<String> list = new ArrayList<>(n);
        for(int i=1;i<=n;i++){

            String s = "";
            for(Integer key: map.keySet()){
                if(i%key==0)
                    s+=map.get(key);
            }

            if(s.length()==0)
                list.add(s+i);
            else
                list.add(s);

        }
        return list;
    }
}
