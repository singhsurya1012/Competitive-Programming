package medium;

public class GameOfLife {

    int[] dir = new int[]{-1,0,1};
    public void gameOfLife(int[][] board) {

        int m = board.length;
        int n = board[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n;j++) {

                int neighbours = getAliveNeighbours(i,j,m,n,board);

                if(board[i][j]==0 && neighbours==3){
                    board[i][j] = 2;

                }else if(board[i][j]==1 && (neighbours<2 || neighbours>3)){
                    board[i][j] = -1;
                }
            }
        }



        for(int i=0; i<m; i++){
            for(int j=0; j<n;j++) {

                if(board[i][j]==2){
                    board[i][j]=1;
                }else if(board[i][j]==-1){
                    board[i][j] =0;
                }
            }
        }

    }


    public boolean isSafe(int i, int j, int m, int n){
        return i>=0 && j>=0 && i<m && j<n;
    }

    public int getAliveNeighbours(int i, int j, int m, int n, int[][] board){

        int neighbours = 0;
        for(int x:dir){
            for(int y:dir){

                if(x==0 && y==0)
                    continue;

                if(isSafe(i+x,y+j,m,n)
                        && (board[i+x][j+y]==1 || board[i+x][y+j]==-1 )) {
                    neighbours++;
                }
            }
        }

        return neighbours;
    }

}
