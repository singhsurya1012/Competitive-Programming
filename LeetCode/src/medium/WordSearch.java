package medium;

public class WordSearch {

    int m ;
    int n;
    public boolean exist(char[][] board, String word) {

        m = board.length;
        n = board[0].length;

        for(int i=0; i<m;i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board, word, 0 , i, j))
                        return true;

                }
            }
        }

        return false;
    }



    public boolean dfs(char[][] board, String word, int pos, int i, int j){

        if(pos==word.length())
            return true;

        if(!isSafe(i,j) || board[i][j] !=word.charAt(pos))
            return false;

        char c = board[i][j];
        board[i][j] = ' ';


        boolean found = dfs(board, word, pos+1, i,j+1) || dfs(board, word, pos+1, i,j-1)
                || dfs(board, word, pos+1, i-1,j) || dfs(board, word, pos+1, i+1,j);


        board[i][j] = c;
        return found;


    }


    public boolean isSafe(int i, int j){
        return i>=0 && i<m && j>=0 && j<n;
    }
}
