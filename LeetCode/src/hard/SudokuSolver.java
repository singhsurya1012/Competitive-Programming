package hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SudokuSolver {

    int[][] rows = new int[9][9];
    int[][] cols = new int[9][9];
    int[][] box = new int[9][9];

    public void solveSudoku(char[][] board) {

        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++ ){

                if(board[i][j]=='.')
                    continue;

                int val = board[i][j] - '1';
                rows[i][val] = 1;
                cols[j][val] = 1;
                box[(i/3)*3 + j/3][val] = 1;
            }
        }


        solve(board,0,0);

    }



    public boolean solve(char[][] board,
                         int i, int j){

        if(i==9)
            return true;
        if(j==9)
            return solve(board,i+1,0);

        if(board[i][j]!='.')
            return solve(board,i,j+1);

        for(int c=1; c<=9;c++){

            if(isValid(i,j,c)){

                board[i][j] = (char)(c+'0');
                rows[i][c]=1;
                cols[j][c]=1;
                box[(i/3)*3 + j/3][c]=1;

                if(solve(board,i,j+1))
                    return true;

                board[i][j] = '.';
                rows[i][c]=0;
                cols[j][c]=0;
                box[(i/3)*3 + j/3][c]=0;
            }
        }

        return false;

    }

    private boolean isValid(int i, int j, int c) {

        if(rows[i][c]==1)
            return false;

        if(cols[j][c]==1)
            return false;

        if(box[(i/3)*3 + j/3][c]==1)
            return false;

        return true;
    }




    void solveSudokuUsingMaps(char[][] board) {

        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer,Set<Character>> cols = new HashMap<>();
        Map<Integer,Set<Character>> box = new HashMap<>();

        for(int i=0; i<9;i++){
            rows.put(i, new HashSet<>());
            cols.put(i, new HashSet<>());
            box.put(i, new HashSet<>());
        }


        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++ ){

                if(board[i][j]=='.')
                    continue;

                rows.get(i).add(board[i][j]);
                cols.get(j).add(board[i][j]);

                int boxNum = (i/3)*3 + j/3;
                box.get(boxNum).add(board[i][j]);
            }
        }


        solve(board,rows,cols,box,0,0);

    }



    public boolean solve(char[][] board, Map<Integer,Set<Character>> rows, Map<Integer,Set<Character>> cols,
                         Map<Integer,Set<Character>> box, int row, int col){


        for(int i = row; i<9; i++, col=0){

            for(int j = col; j<9; j++){

                if(board[i][j]!='.')
                    continue;

                for(char c='1';c<='9'; c++){

                    if(!rows.get(i).contains(c) && !cols.get(j).contains(c) && !box.get((i/3)*3 + j/3).contains(c)){

                        board[i][j] = c;
                        rows.get(i).add(c);
                        cols.get(j).add(c);
                        box.get((i/3)*3 + j/3).add(c);


                        if(solve(board, rows, cols, box,i,j+1)){
                            return true;
                        }else{
                            board[i][j] = '.';
                            rows.get(i).remove(c);
                            cols.get(j).remove(c);
                            box.get((i/3)*3 + j/3).remove(c);
                        }

                    }
                }
                return false;
            }
        }

        return true;

    }
}
