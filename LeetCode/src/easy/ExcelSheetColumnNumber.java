package easy;

public class ExcelSheetColumnNumber {

    public int titleToNumber(String columnTitle) {

        int base = 26;
        int column = 0;

        for(char c: columnTitle.toCharArray()){

            int val = c-'A'+1;
            column = column*base+val;
            System.out.println(column);
        }

        return column;
    }
}
