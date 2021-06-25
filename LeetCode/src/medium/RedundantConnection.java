package medium;

public class RedundantConnection {

    Set<Integer> visited = new HashSet<>();
    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=1;i<=n;i++){
            map.put(i, new LinkedList<Integer>());
        }

        for(int[] e: edges){
            visited.clear();
            if(connected(e[0],e[1], map))
                return e;

            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }

        return null;
    }


    public boolean connected(int s, int e, Map<Integer,List<Integer>> map){

        visited.add(s);

        if(s==e)
            return true;

        for(int i: map.get(s)){

            if(!visited.contains(i) && connected(i,e, map))
                return true;
        }
        return false;
    }
}
