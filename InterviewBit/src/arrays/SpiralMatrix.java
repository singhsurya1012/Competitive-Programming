package arrays;

public class SpiralMatrix {

    /***
     * Solution to print matrix in spiral form
     * dir 0 --> Left to Right
     * dir 1 --> Top to Bottom
     * dir 2 --> Right to Left
     * dir 3 --> Bottom to Top
     * @param matrix
     */
    public void solution(int[][] matrix) {

        int T = 0;
        int B = matrix.length-1;
        int L = 0;
        int R = matrix[0].length-1;
        int dir = 0;

        while(T<=B && L<=R) {

            if(dir==0) {

                for(int i = L;i<=R;i++)
                    System.out.println(matrix[T][i] + " ");
                T++;

            }else if(dir==1) {

                for(int i = T;i<=B;i++)
                    System.out.println(matrix[i][R] + " ");
                R--;

            }else if(dir==2) {

                for(int i = R;i<=L;i--)
                    System.out.println(matrix[B][i] + " ");
                B--;

            }else if(dir==3){

                for(int i = B;i<=T;i--)
                    System.out.println(matrix[i][L]);
                L++;
            }

            dir = (dir+1)%4;
        }

    }
}
