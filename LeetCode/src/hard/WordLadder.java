package hard;

import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {


        Set<String> words = new HashSet<>(wordList);

        if (!words.contains(endWord))
            return 0;

        return transform(beginWord, endWord, words);
    }

    private int transform(String beginWord, String endWord, Set<String> words) {

        //Set<String> transformation = new HashSet<>();
        //transformation.add(beginWord);

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        int level = 0;
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!q.isEmpty()) {

            level++;
            int size = q.size();

            while (size-- > 0) {

                String w = q.poll();
                if (w.equals(endWord))
                    return level;

                for (int i = 0; i < w.length(); i++) {

                    char originalChar = w.charAt(i);
                    char[] arr = w.toCharArray();

                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[i] = c;
                        String temp = new String(arr);

                        if (words.contains(temp) && !visited.contains(temp)) {
                            q.offer(new String(arr));
                            visited.add(temp);
                        }
                    }
                    arr[i] = originalChar;
                }

            }

        }

        return 0;
    }



    private int transform2WayBFS(String beginWord, String endWord, Set<String> words) {

        Set<String> visited = new HashSet<>();

        Set<String> beginVisited = new HashSet<>();
        beginVisited.add(beginWord);

        Set<String> endVisited = new HashSet<>();
        endVisited.add(endWord);

        int level = 1;

        while (!beginVisited.isEmpty() && !endVisited.isEmpty()) {

            if(beginVisited.size()>endVisited.size()){
                Set<String> temp = beginVisited;
                beginVisited = endVisited;
                endVisited = temp;
            }

            Set<String> nextLevelVisited = new HashSet<>();

            for(String w: beginVisited){

                int n = w.length();
                char[] arr = w.toCharArray();

                for (int i = 0; i < n; i++) {
                    char originalChar = w.charAt(i);

                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[i] = c;
                        String temp = new String(arr);

                        if(words.contains(temp)){

                            if(endVisited.contains(temp)){
                                return level+1;
                            }

                            if(!visited.contains(temp)){
                                nextLevelVisited.add(temp);
                                visited.add(temp);
                            }

                        }
                    }
                    arr[i] = originalChar;
                }
            }
            level++;
            beginVisited = nextLevelVisited;
        }

        return 0;
    }


}
