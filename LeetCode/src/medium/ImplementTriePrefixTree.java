package medium;

public class ImplementTriePrefixTree {

    class Trie {

        class TrieNode {

            TrieNode[] next = new TrieNode[R];
            boolean isWord;

        }

        private static final int R = 26;
        private TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            root = put(root,word,0);

        }

        private TrieNode put(TrieNode node, String word, int pos){

            if(node==null)
                node = new TrieNode();

            if(pos==word.length()){
                node.isWord = true;
                return node;
            }

            char c = word.charAt(pos);
            node.next[c-'a'] = put(node.next[c-'a'],word,pos+1);
            return node;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {

            TrieNode node = get(root,word,0);
            if(node!=null && node.isWord)
                return true;

            return false;
        }

        private TrieNode get(TrieNode node, String word, int pos){

            if(node==null || word.length()==pos)
                return node;

            char c = word.charAt(pos);
            return get(node.next[c-'a'],word,pos+1);
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            return null!=get(root,prefix,0);
        }
    }
}
