package easy;

public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        if(n==0)
            return true;

        int placed = 0;

        for(int i=0; i<flowerbed.length;i++){

            if(flowerbed[i]==0 && (i==0 || flowerbed[i-1]==0) && (i==flowerbed.length-1 || flowerbed[i+1]==0)){
                flowerbed[i]=1;
                placed++;
            }

            if(placed==n)
                return true;
        }

        return false;
    }
}
