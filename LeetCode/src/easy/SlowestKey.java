package easy;

public class SlowestKey {

    public char slowestKey(int[] releaseTimes, String keysPressed) {

        int maxDiff = releaseTimes[0];
        char c = keysPressed.charAt(0);

        for(int i=1;i<releaseTimes.length;i++){

            int diff = releaseTimes[i]-releaseTimes[i-1];
            if(diff>maxDiff || (diff==maxDiff && keysPressed.charAt(i)>c)){
                maxDiff = diff;
                c = keysPressed.charAt(i);
            }
        }

        return c;
    }
}
