package medium;

import java.util.TreeMap;

public class MyCalanderI {

    class MyCalendar {

        class Node {
            int start;
            int end;

            Node left;
            Node right;

            public Node(int start, int end){
                this.start = start;
                this.end = end;
            }
        }

        private Node rootCalender;
        private TreeMap<Integer,Integer> calendar;
        public MyCalendar() {
            calendar = new TreeMap<>();
        }

        public boolean bookSlotUsingTreeMap(int start, int end) {
            Integer prev = calendar.floorKey(start),
                    next = calendar.ceilingKey(start);
            if ((prev == null || calendar.get(prev) <= start) &&
                    (next == null || end <= next)) {
                calendar.put(start, end);
                return true;
            }
            return false;
        }

        public boolean book(int start, int end) {

            if(rootCalender ==null){
                rootCalender = new Node(start, end);
                return true;
            }

            return insert(start, end);
        }


        public boolean insert(int s, int e){

            Node curr = this.rootCalender;
            Node prev = null;

            while(curr!=null){

                if(overlap(curr.start, curr.end,s,e))
                    return false;

                prev = curr;

                if(e<=curr.start)
                    curr = curr.left;
                else
                    curr = curr.right;
            }

            curr = new Node(s,e);

            if(curr.start>=prev.end)
                prev.right = curr;
            else
                prev.left = curr;

            return true;


        }

        private boolean overlap(int s1, int e1, int s2, int e2){

            if(s2>=e1 || e2<=s1 ){
                return false;
            }

            return true;
        }
    }
}
