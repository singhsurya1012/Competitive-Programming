package medium;

import java.util.*;

public class KeysAndRooms {

    //Simple BFS
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        //Set is used instead of usual visited array
        //Since using set we can at anytime break the loop easily if all rooms are visited
        Set<Integer> set = new HashSet<>();

        //Add all the rooms to be visited
        for (int i = 0; i < rooms.size(); i++) {
            set.add(i);
        }

        //Add the first room to queue
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        //Remove it since its visited
        set.remove(0);

        while (!q.isEmpty()) {

            //If Set is empty means we have visited all the rooms
            if (set.isEmpty()) {
                return true;
            }

            int room = q.poll();
            //Else take all keys and see if they are not visited
            for (Integer key : rooms.get(room)) {
                if (set.contains(key)) {
                    //Add to the queue and remove them from set as they are visited
                    q.offer(key);
                    set.remove(key);
                }
            }
        }

        //If set is empty means we visited all the rooms
        return set.isEmpty();
    }
}
