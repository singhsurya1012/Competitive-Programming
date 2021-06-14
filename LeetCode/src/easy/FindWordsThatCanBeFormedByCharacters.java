package easy;

public class FindWordsThatCanBeFormedByCharacters {

    public int countCharacters(String[] words, String chars) {

        int[] arr = new int[26];

        for(char c: chars.toCharArray()){
            arr[c-'a']+=1;
        }

        int ans = 0;
        for(String word: words){
            ans+=checkIfGood(word,arr);
        }
        return ans;
    }


    public int checkIfGood(String word, int[] arr){
        int[] w = new int[26];
        for(char c: word.toCharArray()){
            w[c-'a']++;
            if(w[c-'a']>arr[c-'a'])
                return 0;
        }
        return word.length();
    }
}
