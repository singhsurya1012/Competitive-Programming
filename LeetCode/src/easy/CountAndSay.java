package easy;

public class CountAndSay {

    //Time Complexity : O(N)
    //Space Complexity : O(1)
    public static String countAndSay(int n) {

        String currentTerm = "1";
        int i = 1;

        //Iterating till the i is n-1, since the n-1 call will generate nth term
        while(i<n) {
            currentTerm = generateTerm(currentTerm);
            i++;
        }

        return currentTerm;
    }

    public static String generateTerm(String s) {

        StringBuilder term = new StringBuilder();

        //Setting first Character and its count
        char lastChar = s.charAt(0);
        int charCount = 1;

        //Iterating each character in string and checking if its equal to the last char
        for(int i = 1; i<s.length(); i++) {

            //If current Character is not equal to last char means we have hit the end of sequence
            //So we update the final String with charCount + lastChar  (Take care of adding directly)
            if(s.charAt(i)!=lastChar) {

                term.append(charCount);
                term.append(lastChar);

                //Update the lastChar to currentChar and set count to 1
                lastChar = s.charAt(i);
                charCount = 1;

            }else {
                //Update the count since current char is equal to lastChar
                charCount++;
            }


        }

        //Update the remaining character after complete iteration
        term.append(charCount);
        term.append(lastChar);

        return term.toString();
    }
}
