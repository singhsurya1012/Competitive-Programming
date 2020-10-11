public class CyclicBinaryString {

    public static int maximumPower(String s) {

        String newS = s + s;
        char[] charArr = newS.toCharArray();

        int maxConsZero = 0;
        int consZero = 0;
        boolean containsOne = false;
        for (int i = 0; i < charArr.length; i++) {

            if (charArr[i] == '0') {
                consZero++;
            } else {
                maxConsZero = Integer.max(maxConsZero, consZero);
                consZero = 0;
                containsOne = true;
            }
        }

        maxConsZero = Integer.max(maxConsZero, consZero);

        if (!containsOne) {
            return -1;
        }


        return maxConsZero;

    }
}
