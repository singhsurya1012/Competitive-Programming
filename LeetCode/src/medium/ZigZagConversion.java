package medium;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {

    public String convert(String s, int numRows) {

        if(numRows==1)
            return s;

        List<StringBuilder> rows = new ArrayList<>(numRows);
        for(int i=0; i<Math.min(numRows,s.length());i++){
            rows.add(new StringBuilder());
        }

        int currRow = 0;
        boolean down = false;
        for(char c: s.toCharArray()){
            rows.get(currRow).append(c);

            if(currRow==0 || currRow == numRows-1)
                down  = !down;

            currRow += down?1:-1;
        }

        StringBuilder res = new StringBuilder();
        for(StringBuilder sb: rows)
            res.append(sb);

        return res.toString();

    }


    public String convertClean(String s, int numRows) {

        if(numRows==1)
            return s;

        StringBuilder res = new StringBuilder();
        int n = s.length();
        int cycleLength = 2*numRows-2;

        for(int i=0; i<numRows;i++){
            for(int j=0; i+j<n; j+=cycleLength){
                res.append(s.charAt(i+j));
                if(i!=0 && i!=numRows-1 && j+cycleLength-i<n)
                    res.append(s.charAt(j+cycleLength-i));
            }
        }

        return res.toString();

    }
}
