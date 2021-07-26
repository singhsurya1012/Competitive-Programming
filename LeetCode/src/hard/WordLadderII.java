package hard;

import java.util.*;

public class WordLadderII {

    List<List<String>> ladder = new ArrayList<>();
    Map<String, List<String>> adjList = new HashMap<String, List<String>>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> words = new HashSet<>(wordList);

        if (!words.contains(endWord))
            return ladder;

        constructDAG(beginWord,words);

        List<String> path = new ArrayList<>();
        path.add(beginWord);
        backtrack(beginWord, endWord, path);

        return ladder;
    }


    public void constructDAG(String beginWord, Set<String> words){

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        if(words.contains(beginWord))
            words.remove(beginWord);

        while(!q.isEmpty()){

            int size = q.size();
            while(size-->0){

                String w = q.poll();

                List<String> neighbours = findNeighbours(w,words);
                for(String neighbour: neighbours){

                    if(!adjList.containsKey(w)){
                        adjList.put(w, new ArrayList<>());
                    }

                    adjList.get(w).add(neighbour);
                    words.remove(neighbour);

                }

            }
        }
    }

    public List<String> findNeighbours(String w, Set<String> words){

        List<String> neighbours = new ArrayList<String>();
        int n = w.length();
        char[] arr= w.toCharArray();

        for(int i=0; i<n;i++){

            char originalChar = arr[i];

            for(char c = 'a';c<='z';c++){

                arr[i] = c;
                if(words.contains(String.valueOf(arr))){
                    neighbours.add(String.valueOf(arr));
                }
            }
            arr[i] = originalChar;
        }

        return neighbours;

    }


    public void backtrack(String src, String des,List<String> path){

        if(src.equals(des)){
            List<String> tempPath = new ArrayList<String>(path);
            ladder.add(tempPath);
        }

        if(!adjList.containsKey(src)){
            return ;
        }
        List<String> neighbours = adjList.get(src);
        for(int i =0; i<neighbours.size(); i++){

            path.add(neighbours.get(i));
            backtrack(neighbours.get(i), des, path);
            path.remove(path.size()-1);

        }
    }


}
