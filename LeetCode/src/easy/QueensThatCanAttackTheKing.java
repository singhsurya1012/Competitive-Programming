package easy;

import java.util.ArrayList;
import java.util.List;

public class QueensThatCanAttackTheKing {

    //Time Complexity : O(1)
    //Space Complexity : O(1)
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> possibleQueens = new ArrayList<>();
        //Initializing the chessboard
        int[][] cb = new int[8][8];

        //Setting all queens
        for (int[] queen : queens) {
            cb[queen[0]][queen[1]] = 1;
        }

        //Creating direction array. Picking combination of any two dir will result in all 8 dir. (0,0) invalid direction
        int[] dirs = new int[]{-1, 0, 1};

        for (int dirX : dirs) {

            for (int dirY : dirs) {

                //Skipping the invalid direction
                if (dirX == 0 && dirY == 0) {
                    continue;
                }

                //Initial King position
                int x = king[0];
                int y = king[1];

                //Checking boundary conditions
                while (x >= 0 && y >= 0 && x < 8 && y < 8) {

                    //Checking if queen is present
                    if (cb[x][y] == 1) {
                        List<Integer> l = new ArrayList<>();
                        l.add(x);
                        l.add(y);
                        possibleQueens.add(l);

                        //breaking since no other queen can attack in that direction
                        break;
                    }

                    //moving ahead in that direction
                    x+=dirX;
                    y+=dirY;
                }

            }

        }


        return possibleQueens;
    }

}
