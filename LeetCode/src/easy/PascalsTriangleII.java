package easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {

        List<Integer> triangle = new ArrayList<>();
        triangle.add(1);

        if(rowIndex==0){
            return triangle;
        }

        while(rowIndex-->0){
            //Single only 1 row is needed it can be constructed from the previous row
            //Add last 2 elements and store it in the last element
            for(int i=triangle.size()-2; i>=0; i--){
                triangle.set(i+1,triangle.get(i)+triangle.get(i+1));
            }
            //Add the last 1
            triangle.add(1);
        }
        return triangle;
    }



    public List<Integer> getRowBinomialExpansion(int rowIndex) {
        //nth Row Pascals triangle contains n-1C0 + n-1C1 + n-2C2 +.... n-1Cn-1
        //nCr === nCr-1 *(n-(r-1)/r

        int n = rowIndex+1;

        List<Integer> list = new ArrayList<>(n);

        list.add(1);

        //Nth row contains n elements
        for(int i=1; i<n; i++){

            //Get the previous value in long since it can overflow
            long val = list.get(i-1);

            val = val *(n-i);
            val = val/i;

            list.add((int)val);
        }

        return list;

    }
}
