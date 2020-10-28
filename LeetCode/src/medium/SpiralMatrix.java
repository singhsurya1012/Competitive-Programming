package medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>();

        int firstRow = 0;
        int lastRow = matrix.length;

        if(lastRow==0){
            return new ArrayList<>();
        }

        int firstCol = 0;
        int lastCol = matrix[0].length;

        int size = lastRow*lastCol;
        lastRow--;
        lastCol--;

        //We move one by one in all four directions in layers
        while(list.size()<=size) {

            //Right
            for(int i = firstCol; i<=lastCol; i++){
                list.add(matrix[firstRow][i]);
            }

            firstRow++;

            if(list.size()==size){
                return list;
            }

            //Down
            for(int i = firstRow; i<=lastRow; i++){
                list.add(matrix[i][lastCol]);
            }
            lastCol--;

            if(list.size()==size){
                return list;
            }

            //Left
            for(int i=lastCol; i>=firstCol; i--){
                list.add(matrix[lastRow][i]);
            }
            lastRow--;
            if(list.size()==size){
                return list;
            }

            //Up
            for(int i=lastRow; i>=firstRow;i--){
                list.add(matrix[i][firstCol]);
            }
            firstCol++;
            if(list.size()==size){
                return list;
            }
        }

        return list;

    }
}
