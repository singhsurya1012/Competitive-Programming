package medium;

import java.util.*;

public class ReconstructItinerary {

    List<String> result = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {

        Map<String, PriorityQueue<String>> adjMap = new HashMap<>();

        for(List<String> ticket : tickets){
            adjMap.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            adjMap.get(ticket.get(0)).offer(ticket.get(1));
        }

        travel("JFK", adjMap);
        return result;
    }

    public void travel(String source, Map<String, PriorityQueue<String>> map){

        while(map.containsKey(source) && !map.get(source).isEmpty()){
            travel(map.get(source).poll(), map);
        }

        result.add(0,source);
    }
}
