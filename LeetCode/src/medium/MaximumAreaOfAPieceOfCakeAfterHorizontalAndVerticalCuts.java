package medium;

import java.util.Arrays;

public class MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts {

    int mod = 1000000007;
    public int maxArea(int h, int w, int[] hc, int[] vc) {

        Arrays.sort(hc);
        Arrays.sort(vc);

        //return maxAreaBruteForce(h,w, hc,vc);

        int maxH = Math.max(hc[0],h-hc[hc.length-1]);
        int maxV = Math.max(vc[0], w-vc[vc.length-1]);

        for(int i=1;i<hc.length;i++){
            maxH = Math.max(maxH, hc[i]-hc[i-1]);
        }

        for(int i=1;i<vc.length;i++){
            maxV = Math.max(maxV, vc[i]-vc[i-1]);
        }

        return calculateArea(maxH,maxV);

    }


    public int maxAreaBruteForce(int h, int w, int[] hc, int[] vc){

        int maxArea = 0;
        int x = 0;
        int y = 0;

        for(int i: hc){

            int b = i-x;
            int l = 0;
            int area = 0;

            for(int j: vc){

                l = j-y;
                maxArea = Math.max(calculateArea(l,b),maxArea);
                y = j;
            }

            //last piece
            l = w-y;
            maxArea = Math.max(calculateArea(l,b),maxArea);

            //reset x and y;
            x = i;
            y = 0;
        }


        //last bottom piece
        for(int i:vc){
            maxArea = Math.max(calculateArea(h-x,i-y),maxArea);
            y= i;
        }

        maxArea = Math.max(calculateArea(h-x,w-y),maxArea);
        return maxArea;
    }

    public int calculateArea(int l, int b){
        long area = (1l*l*b)%mod;
        return (int)area;
    }
}
