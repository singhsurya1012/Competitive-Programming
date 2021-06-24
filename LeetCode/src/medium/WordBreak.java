package medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    class TrieNode {

        TrieNode[] next = new TrieNode[26];
        boolean isWord;
    }

    TrieNode root;

    Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict){

        Set<String> set = new HashSet<>(wordDict);
        dp = new Boolean[s.length()];

        //return wordBreakUsingSet(s, 0, set);
        return wordBreakUsingTrie(s, wordDict);

    }

    public boolean wordBreakUsingSet(String s, int pos, Set<String> set){

        if(pos==s.length())
            return true;

        if(dp[pos]!=null)
            return dp[pos];

        for(int i=pos; i<s.length(); i++){

            if(set.contains(s.substring(pos, i+1)) && wordBreakUsingSet(s,i+1,set)){
                dp[pos] = true;
                return true;
            }
        }

        dp[pos] = false;
        return false;
    }



    public boolean wordBreakUsingTrie(String s, List<String> wordDict) {

        buildTrie(wordDict);

        boolean[] dp = new boolean[s.length() + 1];
        char[] c = s.toCharArray();
        dp[0] = true;

        for(int i=0;i<s.length();i++){

            if(!dp[i])
                continue;

            int j = i;
            TrieNode curr = root;
            while(j<s.length() && curr.next[c[j]-'a']!=null){
                curr = curr.next[c[j++]-'a'];
                if(curr.isWord)
                    dp[j]=true;
            }

        }

        return dp[s.length()];

        //return checkWord(s, 0);

    }


    public boolean checkWord(String s, int pos){

        if(pos==s.length())
            return true;

        if(dp[pos]!=null)
            return dp[pos];

        for(int i=pos; i<s.length();i++){

            if(search(s.substring(pos,i+1)) && checkWord(s, i+1)){
                dp[pos] = true;
                return true;
            }

        }

        dp[pos] = false;
        return false;

    }


    public void buildTrie(List<String> words){

        for(String s: words){
            insert(s);
        }

    }


    public void insert(String w){

        root = put(root,w,0);

    }


    public TrieNode put(TrieNode node, String w,int pos){

        if(node==null)
            node = new TrieNode();

        if(pos==w.length()){
            node.isWord = true;
            return node;
        }

        char c = w.charAt(pos);
        node.next[c-'a'] = put(node.next[c-'a'], w, pos+1);
        return node;
    }


    public boolean search(String w){

        TrieNode node = get(root, w, 0);
        if(node!=null && node.isWord)
            return true;

        return false;

    }

    public TrieNode get(TrieNode node, String w, int pos){

        if(node==null)
            return null;

        if(pos==w.length())
            return node;

        char c =w.charAt(pos);
        return get(node.next[c-'a'], w, pos+1);

    }
}
