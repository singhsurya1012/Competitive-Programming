package medium;

import java.util.*;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        ArrayList<Integer>[] adjList = new ArrayList[numCourses];

        int[] inDegree = new int[numCourses];

        for(int i=0; i<numCourses; i++){
            adjList[i] = new ArrayList<>();
        }

        for(int[] p: prerequisites){

            int a = p[1];
            int b = p[0];

            adjList[a].add(b);
            inDegree[b]++;
        }


        int index = 0;
        int[] order = new int[numCourses];

        Queue<Integer> bfs = new LinkedList<>();

        for(int i = 0; i<numCourses;i++){
            if(inDegree[i]==0)
                bfs.offer(i);
        }

        while(!bfs.isEmpty()){

            int i = bfs.poll();
            order[index++] = i;

            for(int neighbour: adjList[i]){
                inDegree[neighbour]--;
                if(inDegree[neighbour]==0)
                    bfs.offer(neighbour);
            }
        }

        return (index==numCourses)? order : new int[0];
    }

    public boolean canFinishDFS(int numCourses, int[][] prerequisites) {

        Map<Integer,List<Integer>> adjMap = new HashMap<>();

        for(int[] p: prerequisites){

            int a = p[1];
            int b = p[0];

            if(!adjMap.containsKey(a))
                adjMap.put(a,new LinkedList<>());

            adjMap.get(a).add(b);
        }

        Set<Integer> visited = new HashSet<>();

        for(int i=0; i<numCourses;i++){

            if(visited.contains(i))
                continue;

            if(containsCycle(adjMap,i,visited,new HashSet<>()))
                return false;
        }

        return true;
    }

    public boolean containsCycle(Map<Integer, List<Integer>> adjMap , int start, Set<Integer> visited, Set<Integer> stack){

        visited.add(start);

        if(!adjMap.containsKey(start))
            return false;

        stack.add(start);


        for(int neighbour : adjMap.get(start)){

            if(visited.contains(neighbour)){
                if(stack.contains(neighbour))
                    return true;
                continue;
            }

            if(containsCycle(adjMap,neighbour, visited,stack))
                return true;
        }

        stack.remove(start);
        return false;
    }
}
