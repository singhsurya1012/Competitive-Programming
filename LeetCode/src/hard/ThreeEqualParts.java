package hard;

import java.util.Arrays;

public class ThreeEqualParts {


    public int[] threeEqualParts(int[] arr) {

        int n = arr.length;

        int totalOnes = 0;
        for(int x: arr){
            totalOnes+=x;
        }

        if(totalOnes==0)
            return new int[]{0,n-1};

        if(totalOnes%3!=0)
            return new int[]{-1,-1};

        int ones = totalOnes/3;

        int i1 = -1, j1 = -1, i2 = -1, j2 = -1, i3 = -1, j3 = -1;
        int count = 0;

        for(int i=0; i<n;i++){

            if(arr[i]==1){

                count++;

                if(count==1) i1 = i;
                if(count==ones) j1 = i;
                if(count==ones+1) i2 = i;
                if(count==2*ones) j2 = i;
                if(count==2*ones+1) i3 = i;
                if(count==3*ones) j3 = i;
            }
        }

        int[] part1 = Arrays.copyOfRange(arr, i1, j1+1);
        int[] part2 = Arrays.copyOfRange(arr, i2, j2+1);
        int[] part3 = Arrays.copyOfRange(arr, i3, j3+1);

        if (!Arrays.equals(part1, part2)) return new int[]{-1,-1};
        if (!Arrays.equals(part1, part3)) return new int[]{-1,-1};

        // x, y, z: the number of zeros after part 1, 2, 3
        int x = i2 - j1 - 1;
        int y = i3 - j2 - 1;
        int z = n - j3 - 1;

        if(x<z || y<z)
            return new int[]{-1,-1};


        return new int[]{j1+z, j2+z+1};
    }

    public int[] threeEqualPartsSlow(int[] arr) {

        int n = arr.length;

        int[] nextOne = new int[n];
        fillNextOne(arr, nextOne);

        if(arr[0]==0 && nextOne[0]==0){
            return new int[]{0,2};
        }

        int start = (arr[0]==0)?nextOne[0]:0;

        for(int i=start;i<n-2;i++){

            int len = i-start+1;

            int k = nextOne[i];
            if(k==0)
                continue;

            int j = k+len;

            if(j<n && arr[j]==0){
                j = nextOne[j];
            }

            if(j==0 || j>=n || j+len!=n)
                continue;

            System.out.println(i +":" + k+  ":" + j);

            if(isValidSplit(arr, start , k, j , len)){
                return new int[]{i,k+len};
            }
        }

        return new int[]{-1,-1};
    }


    public void fillNextOne(int[] arr, int[] nextOne){
        int index = 0;
        int n = arr.length;

        for(int i=1; i<n;i++){

            if(arr[i]==1){
                while(index!=i){
                    nextOne[index++] = i;
                }
            }
        }
    }


    public boolean isValidSplit(int[] arr, int start, int k, int j, int len){

        int n = arr.length;

        while(len-->0){

            if(arr[start]!=arr[k] || arr[k]!=arr[j])
                return false;

            start++;
            k++;
            j++;
        }

        return true;
    }
}
