package medium;

public class RobotBoundedInACircle {

    public boolean isRobotBounded(String instructions) {

        int[] arr = new int[4];
        int x = 0;
        int y = 0;

        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, { -1, 0}};
        //north  = 0; right = 1

        int curr = 0;

        for(char c: instructions.toCharArray()){

            if('G'==c){
                x+= dir[curr][0];
                y+= dir[curr][1];
            }else if('R'==c){
                curr = (curr+1)%4;
            }else{
                curr = (curr-1+4)%4;
            }
        }

        if(x==0 && y==0 || curr!=0)
            return true;

        /*for(int i=1; i<=4;i++){

            for(char c: instructions.toCharArray()){

                if('G'==c){
                    x+= dir[curr][0];
                    y+= dir[curr][1];
                }else if('R'==c){
                    curr = (curr+1)%4;
                }else{
                    curr = (curr-1+4)%4;
                }
            }

            if(x==0 && y==0)
                return true;
        }*/

        return false;
    }
}
