package easy;

import java.util.Arrays;

public class MaximumUnitsOnATruck {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (b1, b2) -> b2[1]- b1[1]);
        int totalUnits = 0;
        int i = 0;

        while(truckSize>0 && i<boxTypes.length){

            int numberOfBoxes = boxTypes[i][0];
            int unitPerBox = boxTypes[i][1];

            if(truckSize>=numberOfBoxes){
                totalUnits +=(unitPerBox*numberOfBoxes);
                truckSize-=numberOfBoxes;
            }else{
                totalUnits+=(unitPerBox*truckSize);
                truckSize = 0;
            }

            i++;
        }
        return totalUnits;
    }
}
