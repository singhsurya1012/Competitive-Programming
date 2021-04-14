package medium;

public class RotateImage {

    public void rotate(int[][] m) {

        int n = m.length;


        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {

                int temp = m[i][j];
                m[i][j] = m[n - 1 - j][i];
                m[n - 1 - j][i] = m[n - 1 - i][n - 1 - j];
                m[n - 1 - i][n - 1 - j] = m[j][n - 1 - i];
                m[j][n - 1 - i] = temp;
            }
        }

    }

    public void rotateUsingTranspose(int[][] matrix) {

        int m = matrix.length;

        transpose(matrix, m);
        reverse(matrix, m);
    }


    public void transpose(int[][] matrix, int n) {

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(matrix, i, j);
            }
        }
    }


    public void swap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }


    public void reverse(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            reverse(matrix[i], n);
        }
    }

    public void reverse(int[] arr, int n) {
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

}
