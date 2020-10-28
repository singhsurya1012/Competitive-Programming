package easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> triangle = new ArrayList<>();
        if(numRows==0){
            return triangle;
        }

        List<Integer> lastRow = new ArrayList<>();
        lastRow.add(1);

        triangle.add(lastRow);
        numRows--;

        //Each Pascal Row can be calculated from previous row by adding two consecutive values
        while(numRows-->0){
            List<Integer> r = new ArrayList<>();

            r.add(1);

            for(int i=0; i<lastRow.size()-1; i++){
                r.add(lastRow.get(i)+lastRow.get(i+1));
            }

            r.add(1);

            triangle.add(r);
            lastRow = r;

        }

        return triangle;
    }
}
