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
}
