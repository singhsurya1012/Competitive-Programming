package medium;

public class DesignAddAndSearchWordsDataStructure {

    class WordDictionary {

        /** Initialize your data structure here. */

        TrieNode root;

        public WordDictionary() {
        }

        public void addWord(String word) {

            root = insert(root,word,0);
        }

        public TrieNode insert(TrieNode node, String word, int pos){

            if(node==null)
                node = new TrieNode();

            if(pos==word.length()){
                node.isWord = true;
                return node;
            }

            char c = word.charAt(pos);

            node.next[c-'a'] = insert(node.next[c-'a'],word,pos+1);
            return node;
        }


        public boolean search(String word) {

            return get(root,word,0);
        }

        private boolean get(TrieNode node, String word, int pos){

            if(node==null)
                return false;

            if(pos==word.length())
                return node.isWord;

            char c = word.charAt(pos);

            if(c!='.'){
                return get(node.next[c-'a'],word,pos+1);
            }else{

                for(int i=0; i<26;i++){

                    if(get(node.next[i],word,pos+1))
                        return true;
                }
                return false;
            }

        }
    }

    class TrieNode {

        boolean isWord;
        TrieNode[] next = new TrieNode[26];

    }
}
