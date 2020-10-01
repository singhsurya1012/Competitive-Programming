package medium;

public class SubrectangleQueries {

    int[][] rectangle = null;

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    //update all values between top left corner = (row1,col1) and  bottom right corner = (row2,col2) of rectangle
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                this.rectangle[i][j] = newValue;
            }
        }

    }

    //Get the value of (row,col) in rectangle
    public int getValue(int row, int col) {
        return this.rectangle[row][col];

    }
}
