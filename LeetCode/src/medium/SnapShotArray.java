package medium;

import java.util.ArrayList;
import java.util.List;

public class SnapShotArray {

    class SnapshotArray {

        List<Pair>[] array;
        int snapId;

        public SnapshotArray(int length) {
            snapId = 0;
            array = new List[length];
            for(int i=0; i<length; i++){

                ArrayList l = new ArrayList<>();
                l.add(new Pair(0,0));
                array[i] = l;
            }

        }

        public void set(int index, int val) {
            List<Pair> snap = array[index];

            if(snap.get(snap.size()-1).snapId==snapId){
                snap.get(snap.size()-1).val = val;
            }else{
                snap.add(new Pair(snapId,val));
            }
        }

        public int snap() {
            return snapId++;
        }

        public int get(int index, int snapId) {

            List<Pair> snap = array[index];

            int l = 0;
            int r = snap.size()-1;

            while(l<=r){

                int m = (l+r)/2;
                Pair p = snap.get(m);

                if(p.snapId==snapId){
                    return p.val;
                }

                if(p.snapId>snapId){
                    r = m-1;
                }else{
                    l = m+1;
                }
            }

            return snap.get(l-1).val;
        }
    }

    class Pair {

        int snapId;
        int val;

        public Pair(int snapId, int val){
            this.snapId = snapId;
            this.val = val;
        }

    }
}