package medium;

import java.util.*;

public class NumberOfMatchingSubsequence {
    class Word {
        char[] c;
        int index;

        public Word(String w){
            this.c = w.toCharArray();
            this.index = 0;
        }
    }

    public int numMatchingSubseq(String s, String[] words) {

        Queue<Word>[] queue = new LinkedList[26];


        for (int i = 0; i <26; i++)
            queue[i] = new LinkedList<>();

        for(String w: words){
            int i = w.charAt(0)-'a';
            queue[i].add(new Word(w));
        }

        int ans = 0;

        for(char c: s.toCharArray()){
            int j = c - 'a';

            Queue<Word> q = queue[j];
            int size = q.size();
            for(int i=0; i<size;i++){

                Word w = q.poll();
                w.index++;

                if(w.index==w.c.length)
                    ans++;
                else
                    queue[w.c[w.index]-'a'].offer(w);


                //Max answer possible
                if(ans == words.length)
                    return ans;

            }

        }

        return ans;


    }

    public int numMatchingSubseqBinarySearch(String s, String[] words) {

        Map<Character, List<Integer>> charMap = new HashMap<>();

        for(int i=0; i<s.length();i++){

            char c = s.charAt(i);
            if(charMap.containsKey(c)){
                charMap.get(c).add(i);
            }else{
                List<Integer> l = new ArrayList<>();
                l.add(i);
                charMap.put(c,l);
            }
        }

        int ans =0;
        for(String word: words){

            if(isSubsequence(word,charMap))
                ans++;
        }

        return ans;
    }



    public boolean isSubsequence(String s, Map<Character, List<Integer>> map){

        int prev = 0;
        for(int i=0; i<s.length();i++){

            char c = s.charAt(i);

            if(!map.containsKey(c))
                return false;

            List<Integer> charList = map.get(c);
            int j = Collections.binarySearch(charList, prev);
            if(j<0)
                j = -j-1;

            if(j==charList.size())
                return false;

            prev = charList.get(j)+1;
        }

        return true;
    }

}
